package br.edu.ifsp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.exception.UnsuporttedMathOperationException;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
	
	@RequestMapping(value = "/{operator}/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(	@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo,
						@PathVariable("operator") String operator
						) throws Exception {
							
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		switch(operator) {
			case "sum":
				return convertToDouble(numberOne) + convertToDouble(numberTwo);
				
			case "subtraction":
				return convertToDouble(numberOne) - convertToDouble(numberTwo);
			
			case "multiple":
				return convertToDouble(numberOne) * convertToDouble(numberTwo);
				
			case "division":
				return convertToDouble(numberOne) / convertToDouble(numberTwo);
				
			case "mean":
				return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
				
			default: throw new UnsuporttedMathOperationException(
					"Operação inválida!");
			
		}
		
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double sum(	@PathVariable("numberOne") String numberOne) throws Exception {
		
		if(!isNumeric(numberOne)){
		throw new UnsuporttedMathOperationException(
		"Por favor entre com um valor numérico!");
		}else {	
			return (Double) Math.sqrt(convertToDouble(numberOne));
		}
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
