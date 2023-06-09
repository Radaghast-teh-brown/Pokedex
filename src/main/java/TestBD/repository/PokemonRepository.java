package TestBD.repository;

import TestBD.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    }

