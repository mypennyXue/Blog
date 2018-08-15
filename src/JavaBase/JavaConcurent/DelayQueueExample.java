package JavaBase.JavaConcurent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class DelayQueueExample {
	public static void main(String[] args) {
		DelayQueue queue = new DelayQueue();
		Delayed element = new DelayedElement();

		queue.put(element);
		try {
		Thread.sleep(1000);

			Delayed element2 = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
