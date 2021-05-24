import java.util.ArrayList;
import java.util.List;

public class MemLeakTest extends Thread
{
	private static int NUM_ARRS = 300;

	private static byte[][] STATIC_DATA = new byte[NUM_ARRS][];
	static
	{ // Initialize unchanging static data
		for (int i = 0; i < NUM_ARRS; i++)
			STATIC_DATA[i] = new byte[2000000];
	}

	private static final int NUM_THREADS = 20;

	public static void main(String args[])
	{
		MemLeakTest[] threads = new MemLeakTest[NUM_THREADS];
		for (int i = 0; i < NUM_THREADS; i++)
		{
			threads[i] = new MemLeakTest();
			threads[i].start();
		}
	}


	@Override
	public void run()
	{ // Each thread maintains its own "history" list
		List<HistoryRecord> history = new ArrayList<>();
		for (int count = 0;; count++)
		{
			history.add(new HistoryRecord(count));
			if (count % 10000 == 0)
				System.out.println("Thread " + this + ": count = " + count);
		}
	}

	static class HistoryRecord
	{
		int id;

		String eventName;

		HistoryRecord(int id)
		{
			this.id = id;
			this.eventName = "Foo xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + id;
		}
	}
}
