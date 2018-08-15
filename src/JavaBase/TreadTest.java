package JavaBase;

public class TreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				pong();
			}
		};
		t.start();
//		Thread.sleep(1000);
		System.out.print("ping");
	}

	static void pong() {
		System.out.print("pong");
	}
}
