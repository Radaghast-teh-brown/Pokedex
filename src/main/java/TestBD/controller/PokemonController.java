package TestBD.controller;

import TestBD.model.Pokemon;
import TestBD.repository.PokemonRepository;
import TestBD.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pok")
@Controller
public class PokemonController {
    private PokemonRepository repository;
    @Autowired
    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

//    @PostMapping("/save")
//    public void createPokemon(@RequestBody Pokemon pokemon) {
//        Pokemon pokemonIncluido = repository.save(pokemon);
//    }
//    @GetMapping("/api")
//    public String getBook(){
//        return "Api rest";
//    }
//    @GetMapping("/findAll")
//    public List<Pokemon> getAll(){
//        return repository.findAll();
//    }

//    @GetMapping("/findId/{id}")
//    public List<Pokemon> getPokemonById(@PathVariable int id){
//        return repository.findById(id);
//    }

    //------------------------------------------------------------------------------------------------//
    @QueryMapping
    public Iterable<Pokemon> pegaPokemon() {
        return repository.findAll();
    }

    @QueryMapping
    public Optional<Pokemon> pegaPokemonPorId(@Argument("id") int id){
        return repository.findById(id);
    }

    @MutationMapping
    public Pokemon inserirPokemon(@Argument int id, @Argument String nome, @Argument String tipo){
        Pokemon pokemon = new Pokemon(id, nome, tipo);
        return repository.save(pokemon);
    }
}
