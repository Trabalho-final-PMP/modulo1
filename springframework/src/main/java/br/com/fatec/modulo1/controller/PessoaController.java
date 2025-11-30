package br.com.fatec.modulo1.controller;

import br.com.fatec.modulo1.controller.adapter.PessoaControllerAdapter;
import br.com.fatec.modulo1.controller.dto.request.PessoaRequest;
import br.com.fatec.modulo1.controller.dto.response.PageResponse;
import br.com.fatec.modulo1.controller.dto.response.PessoaResponse;
import br.com.fatec.modulo1.entity.Pessoa;
//import br.com.fatec.modulo1.repository.MongoPessoaRepository;
import br.com.fatec.modulo1.repository.PessoaRepository;
import br.com.fatec.modulo1.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("modulo1/v1/pessoa")
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaRepository repository) {
        this.service = new PessoaService(repository);
    }

    @GetMapping
    public PageResponse<PessoaResponse> listar(Pageable pageable) {
        Page<Pessoa> page = service.listar(pageable);

        List<PessoaResponse> content = page.getContent()
                .stream()
                .map(PessoaControllerAdapter::cast)
                .toList(); // usando Java 16+ List.toList()

        return new PageResponse<>(
                content,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
//        return this.service.listar(pageable)
//                .stream()
//                .map(PessoaControllerAdapter::cast)
//                .collect(Collectors.toList());
    }

    @PostMapping
    public PessoaResponse cadastrar(@RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = PessoaControllerAdapter.cast(pessoaRequest);
        return PessoaControllerAdapter.cast(this.service.salvar(pessoa));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        this.service.remover(id);
    }

    @PutMapping("/{id}")
    public PessoaResponse atualizar(@PathVariable String id, @RequestBody PessoaRequest newPessoa) {
        Pessoa p = PessoaControllerAdapter.cast(id, newPessoa);

        return PessoaControllerAdapter.cast(this.service.atualizar(p));
    }
}
