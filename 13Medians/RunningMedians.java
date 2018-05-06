public class RunningMedians{
	
	private MyHeap<Integer> maxHeap, minHeap;
	private Double median;

	public RunningMedians(){
		maxHeap = new MyHeap<Double>();
		minHeap = new MyHeap<Double>(false);
	}

	public void add(Double value){
		if (maxHeap.size() == 0 && minHeap.size() == 0){
			maxHeap.add(value);
			median = value;
		}else{
			if (value <= median){
				maxHeap.add(value);
			}else{
				minHeap.add(value);
			}
		}
		if (minHeap.size() == maxHeap.size()){
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		}else if ( Math.abs( minHeap.size() - maxHeap.size() ) == 1){
			if (minHeap.size() > maxHeap.size()){
				median = minHeap.peek();
			}else{
				median = maxHeap.peek();
			}
		}else{
			if (minHeap.size() > maxHeap.size()){
				maxHeap.add(minHeap.remove());
			}else{
				minHeap.add(maxHeap.remove());
			}
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		}
	}

	public Double getMedian(){
		return median;
	}

	public int size(){
		return minHeap.size() + maxHeap.size() + 1;
	}


}