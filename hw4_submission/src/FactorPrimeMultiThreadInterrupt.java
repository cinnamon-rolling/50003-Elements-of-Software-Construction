import java.math.BigInteger;

public class FactorPrimeMultiThreadInterrupt {
    public static boolean found;

	public static void main(String[] args) throws Exception{
		final int threadCount = 4;
		BigInteger[] result = new BigInteger[threadCount];
//		BigInteger n = new BigInteger("1127451830576035879");
		final BigInteger n = new BigInteger("412163");


		// create an array of threads
		final FactorInterrupt[] factorThread;
		factorThread = new FactorInterrupt[threadCount];

		// assign values to threads and start thread, invoke run()
		for (int i = 0; i < threadCount; i++) {
			factorThread[i] = new FactorInterrupt(n, i + 2, threadCount);
			factorThread[i].start();
			System.out.println(factorThread[i]);
		}

		// busy wait
		while (!found){
			System.out.println("Busy wait...");
		}

		// kill thread that is not returning
		for  (int i = 0; i < threadCount; i++){
			if (factorThread[i].getResult() == null){
				factorThread[i].interrupt();
			}
			else {

				continue;
			}
			System.out.println(result[i]);

		}
    }

static class FactorInterrupt extends Thread{
	private BigInteger n, start, step;
	private BigInteger result;
	boolean found;

	public FactorInterrupt(final BigInteger n, final int start, final int step){
		this.n = n;
		this.start = BigInteger.valueOf(start);
		this.step = BigInteger.valueOf(step);
	}

	public BigInteger getResult() {
		return result;
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
				FactorPrimeMultiThreadInterrupt.found = true;
				result = start;
				return result;
			}
			if (this.isInterrupted()) {
				System.out.println("Interrupted");
				break;
			}

			start = start.add(step);
		}

		assert (false); //if this is reached, an error occurs.
		return null;
	}
	}
}
