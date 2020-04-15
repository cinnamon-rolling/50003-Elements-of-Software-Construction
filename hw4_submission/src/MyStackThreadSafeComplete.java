import java.util.Stack;

public class MyStackThreadSafeComplete {
	private final int maxSize;
	private long[] stackArray; //guarded by "this"
	private int top; //invariant: top < stackArray.length && top >= -1; guarded by "this"

	//pre-condition: s > 0
	//post-condition: maxSize == s && top == -1 && stackArray != null
	public MyStackThreadSafeComplete(int s) { //Do we need "synchronized" for the constructor?
		// satisfy precondition
		if (s<0){}
		maxSize = s;
	    stackArray = new long[maxSize];
	    top = -1;
	}
	 public synchronized void push(long j) {
			while (isFull()) {
				try {
					wait();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			stackArray[++top] = j;
			// notify other threads that top and stackArray property have changed
			notifyAll();
		}
	//pre-condition: top >= 0
	//post-condition: the top element is removed
	public synchronized long pop() {
		long toReturn;

		while (isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		toReturn = stackArray[top--];
		notifyAll();
	    return toReturn;
	}

	//pre-condition top >= 0
    //post-condition top and stackArray remain unchanged
    //use lock, condition and wait
    public synchronized long peek() {
        while (isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return stackArray[top];
        // does not need to call notify()
    }

	//pre-condition: true
	//post-condition: the elements are un-changed. the return value is true iff the stack is empty.
	public synchronized boolean isEmpty() {
		return (top == -1);
	}

	public synchronized boolean isFull() {
		return (top == maxSize -1);
	}

    }
