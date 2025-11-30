package br.com.fatec.modulo1.controller;

import br.com.fatec.modulo1.entity.Pessoa;
//import br.com.fatec.modulo1.repository.MongoPessoaRepository;
import br.com.fatec.modulo1.repository.PessoaRepository;
import br.com.fatec.modulo1.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("modulo1/v1/pessoa")
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaRepository repository) {
        this.service = new PessoaService(repository);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return this.service.listar();
    }

    @GetMapping("/teste")
    public String teste() {
        return "Ola";
    }

    @PostMapping
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return this.service.salvar(pessoa);
    }
}
