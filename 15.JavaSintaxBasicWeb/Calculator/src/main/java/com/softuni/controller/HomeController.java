package com.softuni.controller;

import com.softuni.Entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/") // SLUSHA NA TOZI URL
	public String index(Model model) {

		//Dobavq atribut na modela, MODELA E TOVA KOETO PODAVAME NA VIEWTO!
		model.addAttribute("operator", "+");
		// DOBAVQME SI ${view}-to KOETO BASE LAYOUT OCHAKVA
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";  // VRUSHTA BASE LAYOUT
	}

	@PostMapping("/") // KAZVAME CHE TOZI METOD SHTE E POST  ZAQVKA!
	public String  calculate(
			@RequestParam String leftOperand,
			@RequestParam String operator,
			@RequestParam String rightOperand,
			Model model){
		// VZEHME SI PARAMETRITE OT FORMICHKATA NO TE IDVAT KATO STRINGCHETA
		// TRQBVA DA GI PARSNEM PREDI DA GI PODADEM NA NASHIQ KALKULATOR!

		double num1;
		double num2;

		try{
			num1 = Double.parseDouble(leftOperand);
		}catch (NumberFormatException ex){
			num1 = 0;
		}


		try{
			num2 = Double.parseDouble(rightOperand);
		}catch (NumberFormatException ex){
			num2 = 0;
		}

		// SUZDAVAME SI KALKULATORA
		Calculator calculator = new Calculator(num1, num2, operator);

		// VZIMAME SI REZULTATA OT SUZDADENIQ METOD
		double result = calculator.calculateResult();

		// SEGA SAMO TRQBVA DA IZPRATIM REZULTATA NA VIEWTO
		// SAMOCHE ZA DA ZAPAZIM SUSTOQNIETO NA KALKULATORA SHTE IZPRATIM I
		// leftOperand, rightOperand i operator IZPOLZVAIKI model.AddAttribute Funkciq

		model.addAttribute("leftOperand", calculator.getLeftOperand());
		model.addAttribute("rightOperand", calculator.getRightoperand());
		model.addAttribute("operator", calculator.getOperator());

		// Izprashtame si rezultata
		model.addAttribute("result", result);

		// i nakraq si izprashtame view-to koeto e views/calculatorForm
		model.addAttribute("view", "views/calculatorForm");

		return "base-layout";
	}

}
