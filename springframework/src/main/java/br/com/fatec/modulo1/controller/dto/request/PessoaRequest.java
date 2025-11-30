package br.com.fatec.modulo1.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PessoaRequest(
        @NotBlank(message = "Nome é um campo obrigatório")
        String nome,

        @NotBlank(message = "Data de nascimento é um campo obrigatório")
        String dataNascimento,

        @NotBlank(message = "Campo ativo é obrigatório")
        Boolean ativo
) {
}
