package br.com.fatec.modulo1.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pessoas")
public record PessoaOrm(
        @Id
        String id,
        String nome,
        String dt_nascimento,
        Boolean ativo
) {
}
