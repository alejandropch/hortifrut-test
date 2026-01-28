package com.hortifrut.backend.pokemon.application.dto;
import java.util.List;

public record PokemonDTO (
        int id,
        String name,
        String image,
        String cry,
        List<String> types,
        List<BaseStat> stats
) {
    public record BaseStat(
            String name,
            int value
     ){}
}
