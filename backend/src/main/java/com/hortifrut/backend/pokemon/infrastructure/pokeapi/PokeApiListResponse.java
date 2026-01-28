package com.hortifrut.backend.pokemon.infrastructure.pokeapi;

import com.hortifrut.backend.pokemon.application.dto.PokemonListItemDto;

import java.util.List;


public record PokeApiListResponse(
        int count,
        List<PokeApiResult> results
){
    public record PokeApiResult(String name, String url){}
}
