
public class MazeSolver{
	private Maze maze;
	private Frontier frontier;
	private boolean animate = true;

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
		}else if (mode == 1){
			frontier = new FrontierStack();
		}else{
			frontier = new FrontierPriorityQueue();
		}
		frontier.add(maze.getStart());

		while (frontier.hasNext()){
			if (animate){
				System.out.println(maze.toStringColor());
			}

			Location temp = frontier.next();
			if (temp.getX() == maze.getEnd().getX() && temp.getY() == maze.getEnd().getY()){
				maze.set(temp.getX(), temp.getY(), 'E');
				temp = temp.getPrev();
				while (temp.getPrev() != null){
					maze.set(temp.getX(), temp.getY(), '@');
					temp = temp.getPrev();
				}
				maze.set(temp.getX(), temp.getY(), 'S');
				System.out.println(maze.toStringColor());
				return true;
			}
			Location[] neighbors = maze.getNeighbors(temp);
			for (int i = 0; i < neighbors.length; i++){
				frontier.add(neighbors[i]);
			}

		}


		return false;
	}

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {

        }
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


	public String toString(){
		return maze.toString();
	}

	public static void main(String[] args){
		MazeSolver yeet = new MazeSolver("data3.dat");
		yeet.solve(2);
	}

}