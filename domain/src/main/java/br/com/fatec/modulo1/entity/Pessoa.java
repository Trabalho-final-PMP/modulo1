package br.com.fatec.modulo1.entity;

public record Pessoa(
        String id,
        String nome,
        String dataNascimento,
        Boolean ativo
) {
}
