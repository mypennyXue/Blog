package JavaBase.JavaConcurent;

import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable{

	protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
    	this.queue = queue;
	}



	@Override
	public void run() {
		try {
			queue.offer("1");
			Thread.sleep(1000);
			queue.offer("2");
			Thread.sleep(1000);
			queue.offer("3");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
