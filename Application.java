
public final class Application
{
	public static void main(String[] args) 
	{
		String[] names = {"Bill", "Alice", "Bob"};
		LinkedQueue<String> vegeBurger = new LinkedQueue<>();
		
		//Adding Bill, Alice and Bob to the line.
		for (int i = 0; i < names.length; i++)
			addCustomer(vegeBurger, names[i]);
		
		//Serving a customer.
		serveCustomer(vegeBurger);
		
		//Jane arrives.
		addCustomer(vegeBurger, "Jane");
		//Hamad arrives.
		addCustomer(vegeBurger, "Hamad");
		
		System.out.println();
		System.out.println("Two customers are served");
		
		//Two customers are served.
		serveCustomer(vegeBurger);
		serveCustomer(vegeBurger);
		//Jim arrives.
		addCustomer(vegeBurger, "Jim");
		
		//Serving two more customers
		System.out.println("Another customer is served");
		serveCustomer(vegeBurger);
		System.out.println("Another customer is served");
		serveCustomer(vegeBurger);
				
	}//end main
	
	/**
	 * adds an element at the end of a queue
	 * @param <T>
	 * @param line the object representing the queue
	 * @param element, the element to enqueue
	 */
	private static<T> void addCustomer(LinkedQueue<T> line, T element)
	{
		line.enqueue(element);
		System.out.println(element+" is added to the end of the queue.");
		printQueue(line);
	}//end addCustomer
	
	/**
	 * prints the element(s) in this queue.
	 * @param line, the object representing the queue to print.
	 */
	private static void printQueue(LinkedQueue<?> line)
	{
		System.out.print("The queue contains the following people: ");
		for (Object obj : line)
			System.out.print(obj+" ");
		System.out.println();
	}//end printQueue
	
	/**
	 * serves a customer at front of this queue if possible and prints the remaining customer(s) in the queue if possible.
	 * @param line, the object representing the queue.
	 */
	private static void serveCustomer(LinkedQueue<?> line)
	{
		if (line.isEmpty())
			return;
		System.out.println(line.dequeue()+" is served.");
		if (line.isEmpty())
			System.out.print("There are no more customers left in the queue");
		else
			printQueue(line);
	}//end serveCustomer
}//end class