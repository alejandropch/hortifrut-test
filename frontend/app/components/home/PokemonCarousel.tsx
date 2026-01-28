"use client";
import { FC, useEffect, useRef } from "react";
import Theme from "./PokemonCarouselTheme";
import { usePokemons } from "@utils/hooks/usePokemons";


interface PokemonCarouselProps {
    options: {
        title?: string;
        filters: Record<string, any>;
    };
    itemCount?: number;
}

const PokemonCarousel: FC<PokemonCarouselProps> = ({ 
    options
  }) => {
    const { title } = options;

    return (
      <Theme
          title={title || "Products"}
          description="Gotta Catch 'Em All!"
      />
    );
};

export default PokemonCarousel;

