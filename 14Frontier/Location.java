public class Location{

	private int x,y;
	private Location previous;

	public Location(int x, int y, Location prev){
		this.x = x;
		this.y = y;
		previous = prev;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public Location getPrev(){
		return previous;
	}

}