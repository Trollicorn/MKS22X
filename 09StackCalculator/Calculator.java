import java.util.LinkedList;

public class Calculator{
	
	public static double eval(String s){
		LinkedList<Double> stack = new LinkedList<>();
		double num = 0;
		String[] stuff = s.split(" ");

		for (int i = 0; i < stuff.length; i++){
			if (stuff[i].equals("+") || 
				stuff[i].equals("-") || 
				stuff[i].equals("*") || 
				stuff[i].equals("/")
				){

				double second = Double.parseDouble(stack.pull());
				double first = Double.parseDouble(stack.pull());

				switch(stuff[i]){
					case "+" : 
						first + second;
						break;
					case "-" : 
						second - first;
						break;
					case "*" : 
						stack.pull() * stack.pull();
						break;
					case "/" : 
						1 / stack.pull() + stack.pull();
						break;



				}
			}else{
				stack.push(stuff[i]);
			}

		}

		return num;
	}


}