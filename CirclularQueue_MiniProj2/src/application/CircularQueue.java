package application;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
//THIS IS A COMMIT
/**
 * Beginning of class for implementing the circular queue.
 */
public class CircularQueue<E> implements FixedSizeQueueInterface<E> {
	private int capacity;
	private E dataArray[];
	private int head;
	private int tail;
	private int size;

	/**
	 * This constructor will instantiate a new circular queue of the size given
	 * as an attribute. 
	 * Updated condition, was maxQueueSize != 0, now maxQueueSize less than equal to 0. 
	 * Updated condition, removed +1 from setting the max capacity of the queue.
	 * <p>Authored by Alex Spradlin, Sean Holden
	 * @param maxQueueSize This is the capacity of the circular queue.
	 * @throws Exception An exception will be thrown if an invalid capacity is passed into the method.
	 */
	public CircularQueue(int maxQueueSize) throws Exception {
		super();
		if (maxQueueSize <= 0)
		{
			throw new Exception("Queue capacity invalid.");
		}
		this.capacity = maxQueueSize;
		clear();
	}
	
	/**
	 * Method that will call the offer() method and add items
	 * to the queue.
	 * 
	 * @return Boolean value, true for successful, false for unsuccessful
	 */
	@Override
	public boolean add(E arg0) {
		return offer(arg0);
	}

	/**
	 * Returns first item in the queue, or throw an exception if empty. 
	 * Updated condition, removed -1 from dataArray[tail].
	 * <p>Authored by Alex Spradlin
	 * @return First item in the queue
	 */
	@Override
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			return dataArray[tail];
		}
	}

	/**
	 * Add items to the queue and return a boolean value. 
	 * Updated condition, was this.dataArray[head + 1], now this.dataArray[head]. 
	 * Updated condition, was (head) % capacity, now (head + 1) % capacity.
	 * <p>Authored by Alex Spradlin
	 * @return Boolean value, true for successful, false for unsuccessful
	 */
	@Override
	public boolean offer(E arg0) {
		boolean retVal = false;
		if (this.size < this.capacity) { 
			this.dataArray[head] = arg0;
			head = (head + 1) % capacity;
			this.size++;
			retVal = true;
		}
		return retVal;
	}

	/**
	 * View the first item in the queue, without removing it. 
	 * Updated condition, was tail - 1, now tail.
	 * <p>Authored by Alex Spradlin
	 * @return First item in the queue
	 */
	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return dataArray[tail];
		}
	}

	/**
	 * Remove the first item in the queue; do not throw an exception
	 * if the queue is empty. 
	 * Updated conditions, were dataArray[tail-1], now dataArray[tail].
	 * <p>Authored by Alex Spradlin
	 * @return First item in the queue
	 */
	@Override
	public E poll() {
		E retVal = null;
		if (size == 0) {
			// DO nothing.
		} else {
			retVal = dataArray[tail];
			dataArray[tail] = null;
			tail = (tail + 1) % capacity;
			size--;
		}
		return retVal;

	}

	/**
	 * Remove the first item in the queue; however, throw an exception
	 * if the queue is empty. 
	 * Updated conditions, were dataArray[tail-1], now dataArray[tail]. 
	 * Updated condition, was (tail) % capacity, now (tail + 1) % capacity.
	 * <p>Authored by Chris Silvano
	 * @return First item in the queue
	 */
	@Override
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			E retVal = dataArray[tail];
			dataArray[tail] = null;
			tail = (tail + 1) % capacity;
			size--;
			
			return retVal;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * Empty queue of all contents.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		dataArray = ((E[]) new Object[capacity]);
		head = 0;
		tail = 0;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * Checks queue's contents and determines if queue is empty. 
	 * Updated condition, was this.size != 0, now this.size == 0.
	 * <p>Authored by Alex Spradlin
	 * @return Boolean value, true for empty, false for not empty
	 */
	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * Determine size of the queue.
	 * 
	 * @return Current size of the queue
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Take the current queue and transform it into an array.
	 * 
	 * @return Array of objects holding contents of the queue 
	 */
	@Override
	public Object[] toArray() {
		Object retVal[] = new Object[size];

		for (int index = 0; index < size; index++) {
			int myOffset = (head + index) % this.capacity;
			retVal[index] = this.dataArray[myOffset];
		}
		return retVal;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * Determine the queue's capacity.
	 * 
	 * @return Current queue capacity
	 */
	@Override
	public int getQueueCapacity() {
		return this.capacity;
	}

	/**
	 * Determine how many positions are still empty in the queue.
	 * 
	 * @return Current remaining queue space
	 */
	@Override
	public int getRemainingQueueSpace() {
		return this.capacity - this.size;
	}

	/**
	 * Determine if the queue is full.
	 * 
	 * @return Boolean value, true if queue is full, false if queue has space available
	 */
	@Override
	public boolean isQueueFull() {
		return (this.size >= this.capacity); 
	}

}
