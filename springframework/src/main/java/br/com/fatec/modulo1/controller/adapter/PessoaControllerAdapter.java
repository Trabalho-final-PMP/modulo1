package br.com.fatec.modulo1.controller.adapter;

import br.com.fatec.modulo1.controller.dto.request.PessoaRequest;
import br.com.fatec.modulo1.controller.dto.response.PessoaResponse;
import br.com.fatec.modulo1.entity.Pessoa;
import br.com.fatec.modulo1.repository.orm.PessoaOrm;

import java.util.UUID;

public class PessoaControllerAdapter {
    private PessoaControllerAdapter() {}

    public static PessoaResponse cast(Pessoa pessoa) {
        return new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.dataNascimento(),
                pessoa.ativo()
        );
    }

    public static Pessoa cast(PessoaRequest pessoa) {
        return new Pessoa(
                UUID.randomUUID().toString(),
                pessoa.nome(),
                pessoa.dataNascimento(),
                pessoa.ativo()
        );
    }

    public static Pessoa cast(String id, PessoaRequest pessoa) {
        return new Pessoa(
                id,
                pessoa.nome(),
                pessoa.dataNascimento(),
                pessoa.ativo()
        );
    }
}