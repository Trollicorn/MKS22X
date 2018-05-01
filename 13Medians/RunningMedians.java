public class RunningMedians{
	
	private MyHeap<Integer> maxHeap, minHeap;

	public RunningMedians(){
		maxHeap = new MyHeap<Integer>();
		minHeap = new MyHeap<Integer>(false);
	}
}