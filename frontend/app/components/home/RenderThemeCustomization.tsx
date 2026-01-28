import { MobileSearchBar } from "@components/layout/navbar/MobileSearch";
import PokemonCarousel from "./PokemonCarousel";
import { Suspense } from "react";

const RenderThemeCustomization = () => {
  return (
    <>
      <Suspense fallback={null}>
        <MobileSearchBar />
      </Suspense>
      <section className="w-full max-w-screen-2xl mx-auto pb-4 px-4 xss:px-7.5">
        <PokemonCarousel
          options={{
            title: "Pokemons",
            filters: { limit: 12 },
          }}
          itemCount={12}
        />
      </section>
    </>
  );
};

export default RenderThemeCustomization;

