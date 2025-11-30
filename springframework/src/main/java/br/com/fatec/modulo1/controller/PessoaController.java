package br.com.fatec.modulo1.controller;

import br.com.fatec.modulo1.controller.adapter.PessoaControllerAdapter;
import br.com.fatec.modulo1.controller.dto.request.PessoaRequest;
import br.com.fatec.modulo1.controller.dto.response.PessoaResponse;
import br.com.fatec.modulo1.entity.Pessoa;
//import br.com.fatec.modulo1.repository.MongoPessoaRepository;
import br.com.fatec.modulo1.repository.PessoaRepository;
import br.com.fatec.modulo1.service.PessoaService;
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
    public List<PessoaResponse> listar() {
        return this.service.listar()
                .stream()
                .map(PessoaControllerAdapter::cast)
                .collect(Collectors.toList());
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
