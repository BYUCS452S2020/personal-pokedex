package response;

import model.CaughtPokemon;
import model.PokemonSpecies;

public class GetCaughtSpeciesResponse {
    CaughtPokemon caughtPokemon[] = new CaughtPokemon[151];
    PokemonSpecies pokemonSpecies[] = new PokemonSpecies[151];

    public GetCaughtSpeciesResponse(CaughtPokemon[] caughtPokemon, PokemonSpecies[] pokemonSpecies) {
        this.caughtPokemon = caughtPokemon;
        this.pokemonSpecies = pokemonSpecies;
    }

    public CaughtPokemon[] getCaughtPokemon() { return caughtPokemon; }
    public PokemonSpecies[] getPokemonSpecies() { return pokemonSpecies; }

    public void setCaughtPokemon(CaughtPokemon[] caughtPokemon) { this.caughtPokemon = caughtPokemon; }
    public void setPokemonSpecies(PokemonSpecies[] pokemonSpecies) { this.pokemonSpecies = pokemonSpecies; }
}
