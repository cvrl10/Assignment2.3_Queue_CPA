import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Carl
 * @version 1.0
 * Assignment 2.3
 * @param <T>
 */
public class LinkedQueue<T> implements Iterable<T>
{
	private GenericLinkedList<T> queue;
	private GenericNode<T> head;
	private int count;
	
	/**
	 * Sets up an iterator for the traversal of this queue.
	 */
	private class LinkedQueueIterator implements Iterator<T>
	{
		private int current;
		
		/**
		 * Sets current to 0
		 */
		private LinkedQueueIterator()
		{
			current = 0;
		}//end empty-argument constructor
		
		/**
		 * @return true if this iterator as at least one more element to traverse.
		 */
		public boolean hasNext() 
		{
			return current < count;
		}//end hasNext
		
		/**
		 * @return the next element in the traversal if possible.
		 */
		public T next() 
		{
			if (!hasNext())
				throw new NoSuchElementException();
			GenericNode<T> temp = head;
			for (int i = 0; i < current; i++)
				temp = temp.getNextNode();
			current++;
			return temp.getData();
		}//end next
		
		/**
		 * removal is not supported for this iterator
		 * @throws UnsupportedOperationException
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}//end remove
	}//end private class
	
	/**
	 * Allocates the GenericLinkedList object
	 * sets count to 0
	 */
	public LinkedQueue()
	{
		queue = new GenericLinkedList<>();
		count = 0;
	}//end empty-argument constructor
	
	/**
	 * @param element, the element to add at the end of this queue
	 */
	public void enqueue(T element)
	{
		if (element == null)
			throw new IllegalArgumentException();
		GenericNode<T> node = new GenericNode<>();
		node.setData(element);
		queue.addNode(node);
		count++;
		if (count == 1)
			head = queue.getList();
	}//end enqueue
	
	/**
	 * @return the element at the front of this queue, if this queue is empty return null
	 */
	public T front()
	{
		if (isEmpty())
			return null;
		else
			return head.getData();
	}//end front
	
	/**
	 * @return the element at the front of this queue if it is not empty, or null if this queue is empty
	 */
	public T dequeue()
	{
		T result = null;
		if (!isEmpty())
		{
			result = front();
			head = head.getNextNode();
			count--;
			if (head == null)
				queue = new GenericLinkedList<T>();
		}
		return result;
	}//end dequeue
	
	/**
	 * @return an iterator for a traversal of this queue
	 */
	public Iterator<T> iterator() 
	{
		return new LinkedQueueIterator();
	}//end iterator
	
	/**
	 * @return the number of elements in this queue
	 */
	public int size()
	{
		return count;
	}//end size
	
	/**
	 * @return true if this queue has at least one element
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}//end isEmpty
}//end class