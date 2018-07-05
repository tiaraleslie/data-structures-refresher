package ds;

public class BasicStack<X> implements Stack<X> {
	private X [] data;
	private int stackPointer;
	
	public BasicStack() {
		data = (X[]) new Object[1000];
		stackPointer = 0;
		
	}
	
	@Override
	public void push (X newItem) {
		data[stackPointer++] = newItem;
	}
	
	@Override
	public X pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("No more items on the Stack!");
		}	
		return data[--stackPointer];
	}
	
	@Override
	public boolean contains (X Item) {
		boolean found = false;
		for (int i = 0; i < stackPointer; i++) {
			if (data[i].equals(Item)) {
				found = true;
				break;
			}
		}
		return found;
	}
		
	/**
	 * @param item
	 * @return
	 */
	@Override
	public X access (X item) {
		while (stackPointer > 0) {
			X tempItem = pop();
			if(item.equals(tempItem)) {
				return tempItem;
			}
		}
		// If the item doesn't exist, throw an exception
		throw new IllegalArgumentException("Could not find "+item+" on the stack.");
		
	}
	
	/**
	 * @return
	 */
	@Override
	public int size() {
		return stackPointer;
	}
}

