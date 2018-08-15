package JavaBase.JavaConcurent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.toMillis(1);
	}

	@Override
	public int compareTo(Delayed o) {
		return this.compareTo(o);
	}
}
