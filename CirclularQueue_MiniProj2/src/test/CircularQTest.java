package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import application.CircularQueue;
import application.FixedSizeQueueInterface;

public class CircularQTest {
	
	FixedSizeQueueInterface<Integer> queue;
	
	/**
	 * Make a queue with good arguments
	 * <p>Authored by Alex Spradlin, Sean Holden
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		
		queue = new CircularQueue<Integer>(5);
	}
	
	/**
	 * Pass in a wrong argument to the constructor
	 * <p>Authored by Alex Spradlin, Sean Holden, Chris Silvano
	 * @throws Exception
	 */
	@Test (expected=Exception.class)
	public void testConstructorBadInput() throws Exception{
		
		queue = new CircularQueue<Integer>(0);
	}
	
	/**
	 * Add 1 item to a 1 length queue, this also covers offer()
	 * <p>Authored by Alex Spradlin
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		
		queue = new CircularQueue<Integer>(1);
		assertEquals(true, queue.add(0));
		
		//operation unsuccessful, will return false
		assertEquals(false, queue.add(2));
	}
	
	/**
	 * Add items to a queue, clear the queue, then test
	 * that an exception will be thrown since queue is empty
	 * <p>Authored by Alex Spradlin, Chris Silvano
	 * @throws Exception
	 */
	@Test (expected=Exception.class)
	public void testElement() throws Exception {
		
		queue = new CircularQueue<Integer>(2);
		queue.add(1);
		queue.add(2);
		assertEquals((Integer)1, queue.element());
		
		queue.clear();
		
		//throw the exception since queue is empty
		queue.element();
	}
	
	/**
	 * Test peek operation when queue is empty or contains items
	 * <p>Authored by Alex Spradlin
	 * @throws Exception
	 */
	@Test
	public void testPeek() throws Exception {
		
		queue = new CircularQueue<Integer>(2);
		
		//test when it's empty
		assertEquals(null, queue.peek());
		
		//test when it's not empty
		queue.add(2);
		queue.add(4);
		assertEquals((Integer)2, queue.peek());
	}
	
	/**
	 * Test the poll (dequeue) method for the queue
	 * <p>Authored by Alex Spradlin, Chris Silvano
	 * @throws Exception
	 */
	@Test 
	public void testPoll() throws Exception {
		
		//ensure poll returns null on empty queue
		queue = new CircularQueue<Integer>(3);
		assertEquals(null, queue.poll());
		
		//add items to queue
		queue.add(4);
		queue.add(3);
		
		//check items as they are polled from queue
		assertEquals((Integer)4, queue.poll());
		assertEquals((Integer)3, queue.poll());
	}
	
	/**
	 * Test the remove (dequeue) method for the queue
	 * <p>Authored by Chris Silvano
	 * @throws Exception
	 */
	@Test
	public void testRemoveNoException() throws Exception{
	
		queue = new CircularQueue<Integer>(3);
		
		//add items to queue
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		//check items as they are removed from queue
		assertEquals((Integer)1, queue.remove());
		assertEquals((Integer)2, queue.remove());
		assertEquals((Integer)3, queue.remove());
	}
	
	/**
	 * Test the remove (dequeue) method for the queue when
	 * the queue is currently empty - an exception should occur
	 * <p>Authored by Chris Silvano
	 * @throws Exception
	 */
	@Test (expected=Exception.class)
	public void testRemoveWithException() throws Exception{
	
		queue = new CircularQueue<Integer>(3);
		
		//add no items to queue
		//attempt remove operation, an exception is expected
		assertEquals((Integer)1, queue.remove());
	}
	
	/**
	 * Test to ensure that isEmpty returns correct value
	 * <p>Authored by Alex Spradlin, Sean Holden
	 * @throws Exception
	 */
	@Test
	public void testIsEmpty() throws Exception {
		
		//queue should be empty at this point
		queue = new CircularQueue<Integer>(2);
		assertEquals(true, queue.isEmpty());
		
		//queue should not be empty at this point
		queue.add(5);
		assertEquals(false, queue.isEmpty());
	}
	
	/**
	 * Check that size() method returns correct queue size
	 * <p>Authored by Alex Spradlin
	 * @throws Exception
	 */
	@Test
	public void testSize() throws Exception {
		
		queue = new CircularQueue<Integer>(3);
		
		assertEquals(0, queue.size());
	}
	
	/**
	 * Check that elements returned in array match what was in the queue
	 * <p>Authored by Chris Silvano
	 * @throws Exception
	 */
	@Test 
	public void testToArray() throws Exception {
		
		//create queue and add elements
		queue = new CircularQueue<Integer>(3);
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		//check that elements in array match queue items
		assertEquals(1, queue.toArray()[0]);
		assertEquals(2, queue.toArray()[1]);
		assertEquals(3, queue.toArray()[2]);
		
	}
	
	/**
	 * Check that queue capacity is correct amount
	 * <p>Authored by Alex Spradlin, Sean Holden
	 * @throws Exception
	 */
	@Test
	public void testGetQueueCapacity() throws Exception {
		
		queue = new CircularQueue<Integer>(2);
		assertEquals(2, queue.getQueueCapacity());
	}
	
	/**
	 * Check that the remaining space in a queue is correct
	 * <p>Authored by Alex Spradlin, Sean Holden
	 * @throws Exception
	 */
	@Test
	public void testGetRemainingQueueSpace() throws Exception {
		
		queue = new CircularQueue<Integer>(2);
		assertEquals(2, queue.getRemainingQueueSpace());
	}
	
	/**
	 * Check that the queue returns a full message at the right time
	 * <p>Authored by Alex Spradlin, Sean Holden
	 * @throws Exception
	 */
	@Test
	public void testIsQueueFull() throws Exception {
		
		//test for a true answer
		queue = new CircularQueue<Integer>(1);
		queue.add(5);
		assertEquals(true, queue.isQueueFull());
		
		//test for a false answer
		queue = new CircularQueue<Integer>(1);
		assertEquals(false, queue.isQueueFull());
	}
	
}
