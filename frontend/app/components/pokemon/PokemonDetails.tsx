"use client";

import { clsx } from "clsx";
import { BoltIcon } from "@heroicons/react/24/solid";
import { PokemonDetail } from "@components/catalog/type";
import { useRef } from "react";


export default function PokemonDetails({ pokemon }: { pokemon: PokemonDetail }) {
  const audioRef = useRef<HTMLAudioElement | null>(null);
  const playCry = (e: React.MouseEvent) => {
    e.preventDefault();
    e.stopPropagation();

    if (!audioRef.current) {
      audioRef.current = new Audio(pokemon.cry);
    }

    audioRef.current.currentTime = 0;
    audioRef.current.play();
  };

  return (
    <div
      className={clsx(
        "group relative rounded-3xl bg-stone-100 p-6 shadow-sm",
        "transition-all duration-300 ease-out",
        "hover:-translate-y-2 hover:shadow-xl",
        "max-w-lg mx-auto mt-24 text-black"
      )}
    >
      <div className="relative flex justify-center">
        <img
          src={pokemon.image}
          alt={pokemon.name}
          className="h-40 w-40 object-contain transition-transform duration-300 group-hover:scale-120"
        />
      </div>

      <h3 className="mt-3 text-center text-lg font-semibold capitalize">
        {pokemon.name}
      </h3>

      <div className="mt-2 flex justify-center gap-2">
        {pokemon.types.map((type) => (
          <span
            key={type}
            className="rounded-full bg-black px-3 py-1 text-sm text-white font-medium capitalize"
          >
            {type}
          </span>
        ))}
      </div>

      <div className="mt-4 space-y-3">
        {pokemon.stats.map((stat) => (
          <div key={stat.name} className="flex items-center gap-2">
            <BoltIcon className="h-4 w-4 text-yellow-400" />
            <span className="text-sm capitalize">{stat.name}</span>
            <div className="ml-auto text-xs font-semibold">
              {stat.value}
            </div>
          </div>
        ))}
      </div>

      {pokemon.cry && (
        <button
          onClick={playCry}
          className="mt-6 mb-2 w-full rounded-xl bg-black py-2 text-xs font-medium text-white transition hover:bg-gray-800"
        >
         🔊
        </button>
      )}
    </div>
  );
}
