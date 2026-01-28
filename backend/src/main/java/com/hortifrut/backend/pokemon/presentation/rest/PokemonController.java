package com.hortifrut.backend.pokemon.presentation.rest;

import com.hortifrut.backend.pokemon.application.query.GetPokemonByNameQuery;
import com.hortifrut.backend.pokemon.application.query.GetPokemonPageQuery;
import com.hortifrut.backend.shared.bus.QueryBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {
    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    private final QueryBus queryBus;

    public PokemonController(QueryBus queryBus){
        this.queryBus = queryBus;
    }

    @GetMapping
    public Object list(
            @RequestParam(defaultValue = "12") int limit,
            @RequestParam(defaultValue = "0") int offset
    ){
        return queryBus.dispatch(
                new GetPokemonPageQuery(limit, offset)
        );
    }
    @GetMapping("/{name}")
    public Object findByName(@PathVariable String name) {
        return queryBus.dispatch(
                new GetPokemonByNameQuery(name)
        );
    }


}
