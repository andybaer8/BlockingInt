//Author: Andy Baer
package cmsc433.p2;

public class BlockingInt {

/*This class is a thread-safe structure for a counter between 0 
 * and a specified capacity.
 */
	
	private int value;
	private final int capacity;
	
	/*Without any parameters, the struct starts with value=0 and
	maximum capacity*/
	public BlockingInt() {
	value = 0;
	capacity = Integer.MAX_VALUE;
	}
	
	//With 1 argument, it sets the capacity and starts the value at 0
	public BlockingInt(int capacityIn) {
		value = 0;
		capacity = capacityIn
	}
	
	//With 2 arguments, caller can specify both the capacity and starting value
	public BlockingInt(int capacityIn, int valueIn) {
		value = valueIn;
		this.capacity = capacityIn;
	}
	
	public synchronized void increment() throws InterruptedException {
		while (value >= capacity) {
			wait();
		}
		value++;
		notifyAll();
	}
	
	public synchronized void decrement() throws InterruptedException {
		while (value <= 0) {
			wait();
		}
		value--;
		notifyAll();
	}
	
	public synchronized int getValue() {
		return value;
	}
}
