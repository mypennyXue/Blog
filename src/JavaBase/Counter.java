package JavaBase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	public static AtomicInteger num =  new AtomicInteger(0) ;

	static CountDownLatch countDownLatch = new CountDownLatch(30);

	public static void main(String[] args) throws InterruptedException {

		//同时启动1000个线程，去进行i++计算，看看实际结果

		for (int i = 0; i < 30; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j< 10000;j++) {
						num.incrementAndGet();
					}
					countDownLatch.countDown();
				}
			}.start();
		}

		//这里每次运行的值都有可能不同,可能为1000
		countDownLatch.await();
		System.out.println(num);
	}
}
