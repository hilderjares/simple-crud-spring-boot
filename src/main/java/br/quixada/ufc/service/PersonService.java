package br.quixada.ufc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.quixada.ufc.model.Person;
import br.quixada.ufc.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public void save(Person person) {
		this.personRepository.save(person);
	}

	public List<Person> list() {
		return this.personRepository.findAll();
	}

	public void delete(Long id) {
		this.personRepository.deleteById(id);
	}

	public Person findById(Long id) {
		return this.personRepository.getOne(id);		
	}
}
