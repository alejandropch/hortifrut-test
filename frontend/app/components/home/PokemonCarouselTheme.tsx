import { PokemonCard } from "@components/catalog/pokemon/PokemonCard";
import { usePokemons } from "@utils/hooks/usePokemons";
import { useEffect, useRef } from "react";


const Theme = ({ title, description }: any) => {

    const { data, fetchNextPage, hasNextPage, isFetchingNextPage } = usePokemons();
    const pokemons =  data?.pages.flatMap((page) => page.items) ?? [];
    const bottomRef = useRef<HTMLDivElement | null>(null);

    useEffect(() => {
      if (!bottomRef.current || !hasNextPage) return;

      const observer = new IntersectionObserver(
        ([entry]) => {
          if (entry.isIntersecting) {
            fetchNextPage();
          }
        },
        { threshold: 1 }
      );

      observer.observe(bottomRef.current);
      return () => observer.disconnect();
    }, [hasNextPage, fetchNextPage]);
  return (
    <section className="pt-8 sm:pt-12">
      <div className="md:max-w-4.5xl mx-auto mb-6 w-full px-0 text-center xss:mb-10 md:px-36">
        <h2 className="mb-4 font-outfit text-xl md:text-4xl font-semibold text-black dark:text-white">
          {title}
        </h2>
        <p className="text-sm md:text-base font-normal text-black/60 dark:text-neutral-300">
          {description}
        </p>
      </div>

      <div className="w-full pb-6 pt-1">
        <ul className="m-0 grid grid-cols-2 justify-center gap-5 md:gap-11.5 p-0 xss:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
         {pokemons.map((item: any) => (
            <PokemonCard
              key={item.id}
              pokemon={item}
             />
          ))}
        </ul>
        <div ref={bottomRef} className="h-10" />
        {isFetchingNextPage && <p className="text-center font-bold text-sm" >Loading more pokemons...</p>}
      </div>
    </section>
  );
};

export default Theme;

