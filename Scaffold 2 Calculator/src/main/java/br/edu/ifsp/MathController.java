package br.edu.ifsp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.exception.UnsuporttedMathOperationException;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne,
								@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return subtraction;
	}
	
	@RequestMapping(value = "/multiple/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiple(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		Double multiple = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multiple;
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return division;
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return mean;
	}
	
	@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) {
		
		if(!isNumeric(number)){
			throw new UnsuporttedMathOperationException(
					"Por favor entre com um valor numérico!");
		}
		
		Double squareRoot = (Double) Math.sqrt(convertToDouble(number));
		return squareRoot;
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
