public class RunningMedians{
	
	private MyHeap<Integer> maxHeap, minHeap;
	private int med;

	public RunningMedians(){
		maxHeap = new MyHeap<Integer>();
		minHeap = new MyHeap<Integer>(false);
	}

	public void add(int value){
		if (maxHeap.size() == 0 && minHeap.size() == 0){
			maxHeap.add(value);
			med = value;
		}else{
			if (value <= med){
				maxHeap.add(value);
			}else{
				minHeap.add(value);
			}
		}
		if (minHeap.size() == maxHeap.size()){
			med = (minHeap.peek() + maxHeap.peek()) / 2;
		}else if ( Math.abs( minHeap.size() - maxHeap.size() ) == 1){
			if (minHeap.size() > maxHeap.size()){
				med = minHeap.peek();
			}else{
				med = maxHeap.peek();
			}
		}else{
			if (minHeap.size() > maxHeap.size()){
				maxHeap.add(minHeap.remove());
			}else{
				minHeap.add(maxHeap.remove());
			}
			med = (minHeap.peek() + maxHeap.peek()) / 2;
		}
	}


}