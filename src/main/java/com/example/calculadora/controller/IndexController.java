package com.example.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.calculadora.model.Numeros;

@Controller
@RequestMapping("/")

public class IndexController {

	@GetMapping
	public String index() {
		return "index";

	}

	@PostMapping("calcular")
	public ModelAndView calcular(Numeros numeros) {
		ModelAndView mv = new ModelAndView("resposta");
		double resultado = 0.0;
		switch (numeros.getOperacao()) {
		case "somar":
			resultado = numeros.getNumero1() + numeros.getNumero2();
			break;
		case "diminuir":
			resultado = numeros.getNumero1() - numeros.getNumero2();
			break;
		case "multiplicar":
			resultado = numeros.getNumero1() * numeros.getNumero2();
			break;
		case "dividir":
			resultado = numeros.getNumero1() / numeros.getNumero2();
			break;
		default:
			break;
		}

		mv.addObject("resultado", resultado);
		return mv;

	}

}
