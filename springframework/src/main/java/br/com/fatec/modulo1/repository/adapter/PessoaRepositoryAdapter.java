package br.com.fatec.modulo1.repository.adapter;

import br.com.fatec.modulo1.entity.Pessoa;
import br.com.fatec.modulo1.repository.orm.PessoaOrm;

public class PessoaRepositoryAdapter {
    public static Pessoa convertToEntity(PessoaOrm orm) {
        return new Pessoa(
                orm.id(),
                orm.nome(),
                orm.dt_nascimento(),
                orm.ativo()
        );
    }

    public static PessoaOrm convertToOrm(Pessoa pessoa) {
        return new PessoaOrm(
                pessoa.id(),
                pessoa.nome(),
                pessoa.dataNascimento(),
                pessoa.ativo()
        );
    }
}
