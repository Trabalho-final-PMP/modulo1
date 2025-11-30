package br.com.fatec.modulo1.repository;

import br.com.fatec.modulo1.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaRepository {
    public Page<Pessoa> findAllAtivosTrue(Pageable pageable);
    public Pessoa save(Pessoa pessoa);
    public void delete(String id);
}
