package TestBD.service;

import TestBD.model.Pokemon;
import TestBD.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository repository;
    public Pokemon getPokemonById(int id) {
        return null;
    }
    public List<Pokemon> getAllPokemon() {
        return null;
    }

    public void saveOrUpdate(Pokemon pokemon) {
    }

    public void deletePokemonById(int id) {
    }



}
