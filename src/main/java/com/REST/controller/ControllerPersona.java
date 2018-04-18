package com.REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.REST.model.Persona;
import com.REST.repository.PersonaRepository;

@Controller
@RequestMapping(path="/persona")
public class ControllerPersona {
	@Autowired
	
	private PersonaRepository personaRepository;

	@GetMapping(path="/add")
	public @ResponseBody String addNewPersona (@RequestParam String name
			, @RequestParam String apellido) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Persona p = new Persona();
		p.setNombre(name);
		p.setApellido(apellido);
		personaRepository.save(p);
		return "Saved";
	}

}
