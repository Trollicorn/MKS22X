import java.util.LinkedList;

public class Calculator{
	
	public static double eval(String s){
		LinkedList<Double> stack = new LinkedList<>();
		String[] stuff = s.split(" ");

		for (int i = 0; i < stuff.length; i++){
			if (stuff[i].equals("+") || 
				stuff[i].equals("-") || 
				stuff[i].equals("*") || 
				stuff[i].equals("/")
				){

				double second = stack.pop();
				double first = stack.pop();

				switch(stuff[i]){
					case "+" : 
						stack.push(first + second);
						break;
					case "-" : 
						stack.push(first - second);
						break;
					case "*" : 
						stack.push(first * second);
						break;
					case "/" : 
						stack.push(first / second);
						break;
				}
			}else{
				stack.push(Double.parseDouble(stuff[i]));
			}

		}

		return stack.pop();
	}


}