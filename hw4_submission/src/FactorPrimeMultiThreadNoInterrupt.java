import java.math.BigInteger;

public class FactorPrimeMultiThreadNoInterrupt {
	public static void main(String[] args) throws Exception{
		final int threadCount = 4;
		BigInteger[] result = new BigInteger[threadCount];
//		BigInteger n = new BigInteger("1127451830576035879");
		final BigInteger n = new BigInteger("412163");


		// create an array of threads
		final FactorNoInterrupt[] factorThread;
		factorThread = new FactorNoInterrupt[threadCount];

		// assign values to threads and start thread, invoke run()
		for (int i = 0; i < threadCount; i++) {
			factorThread[i] = new FactorNoInterrupt(n, i + 2, threadCount);
			factorThread[i].start();
			System.out.println(factorThread[i]);
		}

		// wait till thread is dead
		for  (int i = 0; i < threadCount; i++){
			factorThread[i].join();

		}
    }

static class FactorNoInterrupt extends Thread{
	private BigInteger n, start, step;
	private BigInteger result;

	public FactorNoInterrupt(final BigInteger n, final int start, final int step){
		this.n = n;
		this.start = BigInteger.valueOf(start);
		this.step = BigInteger.valueOf(step);
	}

	public void run(){
		System.out.println("Thread is running...");
		result = factor(n);
//		System.out.println("Result is: " + result);
	}

	//Precondition: n is a semi-prime number.
	//Postcondition: the returned value is a prime factor of n;
	public BigInteger factor(BigInteger n) {
//		BigInteger i = new BigInteger("2");
		BigInteger zero = new BigInteger("0");


		while (start.compareTo(n) < 0) {
			if (n.remainder(start).compareTo(zero) == 0) {
				System.out.println("Factor is " + start);
				return start;
			}

			start = start.add(step);
		}

		assert (false); //if this is reached, an error occurs.
		return null;
	}
	}
}
