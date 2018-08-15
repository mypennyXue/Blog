package JavaBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockExample {
	private Lock lock = new ReentrantLock();

	public void func() {
		lock.lock();
		try {
			for (int i=0; i< 10;i++) {
				System.out.println(i + " ");
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		lockExample lockExample = new lockExample();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(() -> {lockExample.func();});
		executorService.execute(()->lockExample.func());
	}
}
