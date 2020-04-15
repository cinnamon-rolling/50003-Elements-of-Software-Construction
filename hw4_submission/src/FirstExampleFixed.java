import java.util.Vector;

public class FirstExampleFixed {
	public static Object getLast(Vector list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			return list.get(lastIndex);
		}
	}

	public static void deleteLast(Vector list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			list.remove(lastIndex);
		}
	}

	public static boolean contains(Vector list, Object obj) {
		synchronized (list) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(obj)) {
					return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args){
		// create vector array
		Vector<String> vector = new Vector<String>();
		vector.addElement("1");
		vector.addElement("2");
		vector.addElement("3");
		vector.addElement("4");

		// print initial vector array
		System.out.println("Initial vector is: " + vector);

		// initial get last elem
		System.out.println("Last elem is: " + getLast(vector));

		// delete last elem
		deleteLast(vector);
		System.out.println("Vector after deletion is: " + vector);

		// get last elem
		System.out.println("Last elem is: " + getLast(vector));

		// "4" does not exist in vector array
		final String string4 = new String("4");
		System.out.println("Does 4 exist in vector array?\n" + contains(vector, string4));

		// "3" exists in vector array
		final String string2 = new String("3");
		System.out.println("Does 3 exist in vector array?\n" + contains(vector, string2));
	}
}
