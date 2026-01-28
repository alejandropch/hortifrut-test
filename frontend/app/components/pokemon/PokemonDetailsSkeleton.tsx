import clsx from "clsx";

export default function PokemonDetailsSkeleton() {
  return (
    <div
      className={clsx(
        "relative rounded-3xl bg-stone-100 p-6 shadow-sm",
        "max-w-lg mx-auto mt-24 animate-pulse"
      )}
    >
      {/* image */}
      <div className="mx-auto h-36 w-36 rounded-full bg-stone-200" />

      {/* name */}
      <div className="mt-6 h-6 w-32 mx-auto rounded bg-stone-200" />

      {/* types */}
      <div className="mt-4 flex justify-center gap-2">
        <div className="h-5 w-16 rounded-full bg-stone-200" />
        <div className="h-5 w-16 rounded-full bg-stone-200" />
      </div>

      {/* stats */}
      <div className="mt-6 space-y-3">
        {Array.from({ length: 6 }).map((_, i) => (
          <div
            key={i}
            className="h-4 w-full rounded bg-stone-200"
          />
        ))}
      </div>

      {/* button */}
      <div className="mt-8 h-8 w-full rounded-xl bg-stone-200" />
    </div>
  );
}

