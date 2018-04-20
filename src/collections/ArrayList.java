package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class ArrayList<T> implements List<T> {
	
	@SuppressWarnings("unchecked")
	private T[] elements = (T[]) new Object[1];
	private int size;

	@Override
	public void add(T elem) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		elements[size] = elem;
		++size;
	}

	@Override
	public T get(int i) {
		return (i < 0 || i >= size) ? null : elements[i];
	}

	@Override
	public boolean remove(T elem) {
		return removeAt(indexOf(elem));
	}

	private int indexOf(T elem) {
		int i = 0;
		while (i < size && !elements[i].equals(elem))
			++i;
		return i;
	}

	private boolean removeAt(int index) {
		if (index < 0 || index >= size)
			return false;
		--size;
		System.arraycopy(elements, index + 1, elements, index, size - index);
		elements[size] = null;
		return true;
	}

	@Override
	public boolean contains(Object obj) {
		for (T elem : elements)
			if (elem.equals(obj))
				return true;
		return false;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int curPos = 0;

			@Override
			public boolean hasNext() {
				return curPos < size;
			}

			@Override
			public T next() {
				return elements[curPos++];
			}
		};
	}

}
