package com.codeworld.DinuAlexandru;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.*;



@RestController
public class TrackController {

	@Autowired
	Produs produs;
	
	@Autowired
	Utilizator utilizator;
	
	@GetMapping("/Idp")
	public ModelAndView product(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product");
        Optional<Produs> produsul = produs.findId(id);
        modelAndView.addObject("produs", produsul);
        return modelAndView;
	}
	@GetMapping("/produs")
	public ModelAndView product() {
	        ModelAndView modelAndView = new ModelAndView("product");
	        List<Produs> produsul = produs.findAll();
	        modelAndView.addObject("produs", produsul);
	        return modelAndView;
	}
	@PostMapping("/register")
	public ModelAndView register(@RequestParam("email")String email,@RequestParam("Nume")String nume,@RequestParam("Prenume")String prenume,@RequestParam("Parola")String parola,@RequestParam("username")String username)
	{
		ModelAndView Registrul=new ModelAndView("register");
		return Registrul;
	}
	@GetMapping("/Details")
	public ModelAndView detalii(@RequestParam("email")String email)
	{
		ModelAndView Detaliere = new ModelAndView("Detalii");
		Utilizator utilizat =new Utilizator();
		Detaliere.addObject("Utilizator",utilizat);
		return Detaliere;
	}
	@GetMapping("/clienti")
	public ModelAndView clienti() {
        ModelAndView modelAndView = new ModelAndView("product");
        List<Utilizator> clienti =utilizator.findAll();
        for(int i=0;i<=clienti.size();i++)
        {
        modelAndView.addObject("client", clienti.get(i));
        }
        return modelAndView;
	}
	@GetMapping("/Idu")
	public ModelAndView clienti(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("clienti");
        Optional<Utilizator> utilizatorul = utilizator.findId(id);
        modelAndView.addObject("utilizator", utilizatorul);
        return modelAndView;
	}
}
