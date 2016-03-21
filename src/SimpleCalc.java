class badInputException extends Exception{
	badInputException(String msg){
		System.out.println(msg);
	}
}

class CalculatorEngine{
	int value;
	int keep;
	char toDo;
	
	void binaryOperation(char op){
		keep = value;
		value = 0;
		toDo = op;
	}
	
	void add(){
		binaryOperation('+');
	}
	void subtract(){
		binaryOperation('-');
	}
	void multiply(){
		binaryOperation('*');
	}
	void divide(){
		binaryOperation('/');
	}
	
	void compute() throws badInputException{
		if (toDo == '+')
			value = keep + value;
		else if (toDo == '-')
			value = keep - value;
		else if (toDo == '*')
			value = keep * value;
		else if (toDo == '/'){
			if(value == 0){
				throw new badInputException("Cannot divide by zero!");
			}
			value = keep / value;
		}
		keep = 0;
	}
	
	void clear(){
		value = 0;
		keep = 0;
	}
	
	void digit(int x){
		value = value*10 + x;
	}
	
	int display(){
		return(value);
	}
	
	CalculatorEngine(){
		clear();
	}
}
public class SimpleCalc {
	
	public static void main(String args[]){
		CalculatorEngine calc = new CalculatorEngine();
		calc.digit(1);
		calc.digit(3);
		calc.divide();
		calc.digit(0);
		try{
			calc.compute();
			System.out.println(calc.display());
		} catch(badInputException e){
			System.out.println("ERROR");
		}
	}
}