package JavaBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
	public void func1() {
		synchronized (this) {
			for (int i= 0; i<10; i++) {
				System.out.print(i + " ");
			}
		}
	}

	public void func2() {
		synchronized (this) {
			for (int i= 0; i<10; i++) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		SynchronizedExample example1 = new SynchronizedExample();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(() ->{example1.func1();});
		executorService.execute(() ->{example1.func2();});
	}
}
