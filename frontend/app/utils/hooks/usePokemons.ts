import { Pokemon } from "@components/catalog/type";
import { useInfiniteQuery } from "@tanstack/react-query";
import { fetchPokemons } from "@utils/api/pokemon";

const LIMIT = 12;

type PokemonPage = {
  items: Pokemon[];
  total: number;
};

export function usePokemons() {
  return useInfiniteQuery<PokemonPage>({
    queryKey: ["pokemons"],

    initialPageParam: 0,

    queryFn: ({ pageParam }) =>
      fetchPokemons(LIMIT, pageParam as number),

    getNextPageParam: (lastPage, allPages) => {
      const loaded = allPages.reduce(
        (sum, page) => sum + page.items.length,
        0
      );

      if (loaded >= lastPage.total) return undefined;

      return loaded;
    },

    staleTime: 60_000,
  });
}

