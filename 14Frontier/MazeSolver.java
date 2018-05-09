
public class MazeSolver{
	private Maze maze;
	private Frontier frontier;

	public MazeSolver(String mazeText){
		maze = new Maze(mazeText);
	}

	//Default to BFS
	public boolean solve(){
		return solve(0);
	}

	//mode: required to allow for alternate solve modes.
	//0: BFS
	//1: DFS
	public boolean solve(int mode){
    	//initialize your frontier
    	//while there is stuff in the frontier:
	    //  get the next location
    	//  process the location to find the locations (use the maze to do this)
	    //  check if any locations are the end, if you found the end just return true!
    	//  add all the locations to the frontier
    	//when there are no more values in the frontier return false
		if (mode == 0){
			frontier = new FrontierQueue();
		}else{
			frontier = new FrontierStack();
		}
		frontier.add(maze.getStart());

		while (frontier.hasNext()){
			Location temp = frontier.next();
			if (temp == maze.getEnd()){
				return true;
			}
			Location[] neighbors = maze.getNeighbors(temp);
			for (int i = 0; i < neighbors.length; i++){
				frontier.add(neighbors[i]);
			}
		}


		return false;
	}

	public String toString(){
		return maze.toString();
	}

}