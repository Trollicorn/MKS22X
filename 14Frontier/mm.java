public class Maze{
	
	private Location start, end;
	private char[][] board;

	public Maze(String mazeText){

	}
	// '#' - wall
	// ' ' - open space
	// '?' - frontier space
	// '.' - visited space
	// 'E' - end space (do not replace this)
	// '@' - part of solution
	// 'S' - starting space (do not replace this)

	public String toString(){
		return "";
	}

	public String toStringColored(){
		return "";
	}
	
	//return a list of Locations that are:
 	// adjacent to n and  not visited
	// all the Locations in this list should have their previous set to n.
	public Location[] getNeighbors(Location n){
		return null;
	}

	public Location getStart(){
		return null;
	}

	public Location getEnd(){
		return null;
	}


}