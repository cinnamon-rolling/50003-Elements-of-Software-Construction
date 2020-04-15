import java.util.concurrent.atomic.AtomicInteger;

public class LockStaticVariablesFixed {
//	public static int saving = 5000;
//	public static int cash = 0;
    // saving + cash = 5000

    public static AtomicInteger saving = new AtomicInteger(5000);
    public static AtomicInteger cash = new AtomicInteger(0);

	public static void main(String args[]){
		int numberofThreads = 10;
		WD[] threads = new WD[numberofThreads];

		for (int i = 0; i < numberofThreads; i++) {
			threads[i] = new WD();
			threads[i].start();
		}

		try {
			for (int i = 0; i < numberofThreads; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("some thread is not finished");
		}

		System.out.print("The result is: " + LockStaticVariablesFixed.cash);
	}
}

class WD extends Thread {

    public WD(){
    }


    public void run () {
        synchronized (LockStaticVariablesFixed.saving) {
            if (LockStaticVariablesFixed.saving.intValue() >= 1000) {
                System.out.println("I am doing something.");
                LockStaticVariablesFixed.saving.addAndGet(-1000);
                LockStaticVariablesFixed.cash.addAndGet(1000);
            }
        }
    }
}

