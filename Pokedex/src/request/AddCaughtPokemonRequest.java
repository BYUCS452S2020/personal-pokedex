package request;

import model.CaughtPokemon;

public class AddCaughtPokemonRequest {
    private CaughtPokemon caughtPokemon;

    public AddCaughtPokemonRequest(CaughtPokemon caughtPokemon) { this.caughtPokemon = caughtPokemon; }

    public CaughtPokemon getCaughtPokemon() { return caughtPokemon; }

    public void setCaughtPokemon(CaughtPokemon caughtPokemon) { this.caughtPokemon = caughtPokemon; }
}
