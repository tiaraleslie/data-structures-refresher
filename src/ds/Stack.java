package ds;

public interface Stack<X> {

	/**
	 * Add an item to the Stack
	 * @param newItem
	 */
	void push(X newItem);

	/**
	 * Return the most recent item
	 * @return
	 */
	X pop();

	/**
	 * Does a particular item exist?
	 * @param Item
	 * @return
	 */
	boolean contains(X Item);

	/**
	 * Get a particular item from the Stack
	 * @param item
	 * @return
	 */
	X access(X item);

	/**
	 * The size of the Stack
	 * @return
	 */
	int size();

}