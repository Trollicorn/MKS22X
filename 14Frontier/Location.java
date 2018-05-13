public class Location implements Comparable<Location>{

	private int x,y;
	private Location previous;
	private int distance;

	public Location(int x, int y, Location prev, int dist){
		this.x = x;
		this.y = y;
		previous = prev;
		distance = dist;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getDistance(){
		return distance;
	}

	public Location getPrev(){
		return previous;
	}

	public int compareTo(Location other){
		return getDistance() - other.getDistance();
	}


}