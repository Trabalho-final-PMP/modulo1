package br.com.fatec.modulo1.controller.dto.response;

public record PessoaResponse(
        String id,
        String nome,
        String dataNascimento,
        Boolean ativo
) {
}
