import java.util.*;

public class FrontierQueue implements Frontier{

	private LinkedList<Location> L = new LinkedList<>();

	public Location next(){
		return L.remove();
	}

	public void add(Location n){
		L.add(n);
	}

	public boolean hasNext(){
		return L.size() != 0;
	}


}