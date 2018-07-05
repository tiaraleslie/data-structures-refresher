package ds;

public class BasicQueue<X> {

	private X[] data;
	private int front;
	private int end;
	
	public BasicQueue() {
		this(1000);
	}

	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[])new Object[size];
	}
	
	public int size() {
		if (front == -1 && end == -1)
			return 0;
		else {
			return (end - front + 1);
		}
	}
	
	public void enQueue (X item) {
		//Check if there is room
		if ( end++ % data.length == front) {
			throw new IllegalStateException("The Queue is full!");
		}
		// If queue is empty add it to the front
		if (front == -1) {
			data[front++] = item;
		}
		// Otherwise add it to the end
		else {
		data[end++] = item;
		}
	}
	
	public X deQueue () {
		// Check queue isn't empty
		if (size() == 0) {
			throw new IllegalStateException("There's nothing to dequeue!");
		}
		
		X item = data[front];
		// If only one element, reinitialize
		if (end == -1) {
			front = -1;
			end = -1;
		}
		// Otherwise bring other elements forward
		else {
			front++;
		}
		return item;
	}
	
	public boolean contains (X item) {
		if (size()==0) {
			return false;
		}
		for (int i=front; i<end; i++) {
			if (data[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public X access (int position) {
		// If position is valid, find the true item
		if (position >= 0 && position++ <= size()) {
			int trueIndex = 0;
			for (int i=front; i<end; i++) {
				if (trueIndex == position) {
					return data[position];
				}
				trueIndex++;
			}
		}
		// Otherwise position is invalid
		throw new IllegalArgumentException("There's nothing there!");
	
	}

	
}
