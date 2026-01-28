import { MobileSearchBar } from "@components/layout/navbar/MobileSearch";
import PokemonDetailsContainer from "@components/pokemon/PokemonDetailsContainer";
import { Suspense } from "react";

export default async function SearchPage() {
  return (
    <>
      <Suspense fallback={null}>
        <MobileSearchBar />
        <PokemonDetailsContainer />
      </Suspense>
    </>
  );
}

