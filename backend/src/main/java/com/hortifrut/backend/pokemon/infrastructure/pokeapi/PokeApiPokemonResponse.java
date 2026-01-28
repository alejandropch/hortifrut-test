package com.hortifrut.backend.pokemon.infrastructure.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokeApiPokemonResponse(

        int id,
        String name,

        List<TypeSlot> types,
        List<StatSlot> stats
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TypeSlot(
            Type type
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Type(String name) {}
    }

    // ===== STATS =====

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record StatSlot(
            @JsonProperty("base_stat")
            int baseStat,
            Stat stat
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Stat(String name) {}
    }

    // ===== FLATTEN HELPERS =====

    public List<String> flatTypes() {
        return types.stream()
                .map(t -> t.type().name())
                .toList();
    }

    public List<BaseStat> flatStats() {
        return stats.stream()
                .map(s -> new BaseStat(
                        s.stat().name(),
                        s.baseStat()
                ))
                .toList();
    }

    public record BaseStat(
            String name,
            int value
    ) {}
}
