import java.util.*;

public class FrontierStack implements Frontier{

	private Stack<Location> L = new Stack<>();

	public Location next(){
		return L.pop();
	}
	
	public void add(Location n){
		L.push(n);
	}
	
	public boolean hasNext(){
		return L.size() != 0;
	}
	
}