package br.quixada.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.quixada.ufc.model.Person;
import br.quixada.ufc.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/list")
	public ModelAndView index() {
		List<Person> people = this.personService.list();
		ModelAndView modelAndView = new ModelAndView("person/index");
		modelAndView.addObject("listPeople", people);
		return modelAndView;
	}
	
	@RequestMapping("/form")
	public String form() {
		return "person/new";
	}
	
	@RequestMapping("/save")
	public ModelAndView save(Person person) {
		this.personService.save(person);
		ModelAndView modelAndView = new ModelAndView("redirect:/person/list");
		return modelAndView;
	}		
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		this.personService.delete(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/person/list");
		return modelAndView;
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable Long id) {
		Person person = this.personService.findById(id);
		ModelAndView modelAndView = new ModelAndView("person/edit");
		modelAndView.addObject("person", person);
		return modelAndView;
	}
}
