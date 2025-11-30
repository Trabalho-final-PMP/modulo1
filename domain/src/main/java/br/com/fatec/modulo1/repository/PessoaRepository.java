package br.com.fatec.modulo1.repository;

import br.com.fatec.modulo1.entity.Pessoa;

import java.util.List;

public interface PessoaRepository {
    public List<Pessoa> findAll();
    public Pessoa save(Pessoa pessoa);
}
