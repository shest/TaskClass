
public class ArrayInt {
	private int[] array;
	private Integer[] values;
	private int last;
	
	
	public ArrayInt(int size) {
		array = new int[size];
	}
	
	public ArrayInt(int[] array) {
		this.array = new int[array.length];
		copy(this.array, array);
	}
	
	public void addByIndex(int ind, Integer value) {
		checkBounds(ind);
//		if (last != values.length) {
//			for (int i = ind; i < last; i++) {
//				Integer tmp = values[i];
//				values[i + ]
//			}
//		}
		int[] tmp = new int[array.length + 1];
		for (int i = array.length; i > ind; i--) {
			tmp[array.length] = array[array.length - 1];
		}
		tmp[ind] = value;
		for (int i = 0; i < ind; i++) {
			tmp[i] = array[i];
		}
		array = tmp;
	}
	
	public void addLast(int value) {
//		if (last != values.length) {
//			values[last++] = value;
//		} else {
//			resize();
//			values[last++] = value;
//		}
		int[] tmp = new int[array.length + 1];
		copy(tmp, array);
		tmp[tmp.length - 1] = value;
		array = tmp;
	}
	

	public int get(int ind) {
		checkBounds(ind);
		return array[ind];
	}
	
	public void addLastUnique(int value) {
		if (!isUnique(value)) return;
		int[] tmp = new int[array.length + 1];
		copy(tmp, array);
		tmp[tmp.length - 1] = value;
		array = tmp;
	}
	
	public int size() {
		return array.length;
	}
	
	public int remove(int ind) {
		checkBounds(ind);
		int[] tmp = new int[array.length - 1];
		int value = array[ind];
		for (int i = 0; i < ind; i++) {
			tmp[i] = array[i];
		}
		for (int i = ind + 1; i < array.length; i++) {
			tmp[i - 1] = array[i];
		}
		array = tmp;
		return value;
	}
	
	private boolean isUnique(int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) return false;
		}
		return true;
	}
	
	private void checkBounds(int ind) {
		if (ind < 0 || ind >= array.length) throw new IndexOutOfBoundsException();
	}
	
	private void resize() {
		Integer[] tmp = new Integer[values.length * 2];
		values = copy(tmp, values);
	}
//	
//	private void trim() {
//		int[] tmp = new int[array.length / 4];
//	}
	
	private int[] copy(int[] tmp, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		return tmp;
	}
	private Integer[] copy(Integer[] tmp, Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		return tmp;
	}
	public static void main(String[] args) {
		int[] ia = {1, 2 ,3, 4, 5};
		ArrayInt arr = new ArrayInt(ia);
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		arr.addLast(new Integer(6));
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		System.out.println(arr.remove(2));
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

}
