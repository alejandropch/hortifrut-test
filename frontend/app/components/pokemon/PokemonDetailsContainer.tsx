"use client";

import Grid from "@/components/theme/ui/grid/Grid";
import PokemonDetails from "./PokemonDetails";
import { useSearch } from "@utils/hooks/useSearch";
import NotFound from "@/(public)/not-found";
import { useSearchStore } from "@/stores/useSearchStore";
import { useSearchParams } from "next/navigation";
import { useEffect } from "react";
import PokemonDetailsSkeleton from "./PokemonDetailsSkeleton";

export default function PokemonDetailsContainer() {

  const params = useSearchParams();
  const urlSearch = params.get("q") || "";

  const setSearch = useSearchStore((s) => s.setSearch);

  useEffect(() => {
    setSearch(urlSearch);
  }, [urlSearch, setSearch]);

  const { data, isLoading, isError } = useSearch();


  if (isLoading) return <PokemonDetailsSkeleton />

  if (isError || !data) {
    return (
      <NotFound />
    );
  }

  return (
    <div className="w-full" >
      <PokemonDetails pokemon={data} />
    </div>
  );
}

