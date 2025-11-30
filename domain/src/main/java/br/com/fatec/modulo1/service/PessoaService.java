package br.com.fatec.modulo1.service;

import br.com.fatec.modulo1.entity.Pessoa;
import br.com.fatec.modulo1.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PessoaService {
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Page<Pessoa> listar(Pageable pageable) {
        return this.repository.findAllAtivosTrue(pageable);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public void remover(String id) {
        this.repository.delete(id);
    }
}
