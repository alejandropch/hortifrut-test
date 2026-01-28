package com.hortifrut.backend.pokemon.domain.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String name) {
        super("PokemonRef not found: " + name);
    }
}
