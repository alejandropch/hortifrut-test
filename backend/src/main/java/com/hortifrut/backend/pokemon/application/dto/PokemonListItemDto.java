package com.hortifrut.backend.pokemon.application.dto;

public record PokemonListItemDto(
        int id,
        String name,
        String image,
        String cry) {}
