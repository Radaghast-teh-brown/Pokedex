package TestBD.controller;

import TestBD.model.Pokemon;
import TestBD.repository.PokemonRepository;
import graphql.ErrorType;
import graphql.GraphQLException;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//
//    @GetMapping("/findId/{id}")
//    public Optional<Pokemon> getPokemonById(@PathVariable int id){
//        return repository.findById(id);
//    }

    //------------------------------------------------------------------------------------------------//
    @QueryMapping
    public Iterable<Pokemon> pegaPokemon() {
        return repository.findAll();
    }

    @QueryMapping
    public Pokemon pegaPokemonPorId(@Argument("id") int id) {
        Optional<Pokemon> pokemon = repository.findById(id);
        if (pokemon.isPresent()) {
            return pokemon.get();
        } else {
            throw new GraphQLException("Pokemon não encontrado");
        }
    }

    @MutationMapping
    public Pokemon inserirPokemon( @Argument String nome, @Argument String tipo){
        Pokemon pokemon = new Pokemon( 0, nome, tipo);
        List<Pokemon> listaPokemon = repository.findAll();
        boolean contemNome = listaPokemon.stream().filter(p -> p.getNome().equals(nome)).count() >0 ;
        if(contemNome) {
            throw new GraphQLException("Pokemon já cadastrado");
        }
        return repository.save(pokemon);
    }








}


