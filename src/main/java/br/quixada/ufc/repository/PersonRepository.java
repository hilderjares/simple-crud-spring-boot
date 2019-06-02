package br.quixada.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.quixada.ufc.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
