import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

/**
 * This is MySet, the implementation of a set interface.
 * @author pthakkar7
 * @param <T> The type of objects contained in this Set
 */
@SuppressWarnings("unchecked")
public class MySet<T> implements Set<T> {

    // The following statements have been provided to you.
    // Do not modify these statements.
    private T[] backingArray;
    private int numElements;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * Creates a new MySet that initializes the backingArray and numElements.
     */
    public MySet() {
        backingArray = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        numElements = 0;
    }

    @Override
    public boolean add(T t) {
        if (t == null) {
            return false;
        }
        for (T item : backingArray) {
            if (item != null && item.equals(t)) {
                return false;
            }
        }
        if (numElements < backingArray.length) {
            backingArray[numElements] = t;
            numElements++;
        } else {
            T[] temp = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                temp[i] = backingArray[i];
            }
            backingArray = temp;
            backingArray[numElements] = t;
            numElements++;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int added = 0;
        int check = 0;
        for (T collItem : c) {
            for (T item : backingArray) {
                if (item != null && item.equals(collItem)) {
                    check++;
                }
            }
            if (check == 0) {
                if (numElements < backingArray.length) {
                    backingArray[numElements] = collItem;
                    numElements++;
                } else {
                    T[] temp = (T[]) new Object[backingArray.length * 2];
                    for (int i = 0; i < backingArray.length; i++) {
                        temp[i] = backingArray[i];
                    }
                    backingArray = temp;
                    backingArray[numElements] = collItem;
                    numElements++;
                }
                added++;
            }
            check = 0;
        }
        if (added == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        backingArray = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        numElements = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (T item : backingArray) {
            if (o.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int check = 0;
        for (Object o : c) {
            if (this.contains(o)) {
                check++;
            }
            if (check == 0) {
                return false;
            }
            check = 0;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Set)) {
            return false;
        }
        Set obj = (Set) o;
        if (obj.size() != this.size()) {
            return false;
        }
        if (!(this.containsAll(obj))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int check = 0;
        int tempCount = 0;
        T[] temp = (T[]) new Object[backingArray.length];
        if (o == null) {
            return false;
        }
        for (T item : backingArray) {
            if (item != null && item.equals(o)) {
                item = null;
                numElements--;
                check++;
            }
            if (item != null) {
                temp[tempCount] = item;
                tempCount++;
            }
        }
        if (check > 0) {
            backingArray = temp;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int check = 0;
        for (Object o : c) {
            if (this.contains(o)) {
                this.remove(o);
                check++;
            }
        }
        if (check > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int check = 0;
        for (T item : backingArray) {
            if (!(c.contains(item))) {
                this.remove(item);
                check++;
            }
        }
        if (check > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public Object[] toArray() {
        T[] temp = (T[]) new Object[numElements];
        for (int i = 0; i < numElements; i++) {
            temp[i] = backingArray[i];
        }
        return temp;
    }

    // The methods below have been provided to you. You should not modify them.

    /**
     * Returns an iterator over the elements in this set.
     * You will need to know Iterable/Iterator for your exams, so take a look at
     * this implementation and the Javadocs
     * @return an iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < numElements;
        }
        public T next() {
            return backingArray[index++];
        }
        public void remove() {
            MySet.this.remove(backingArray[index - 1]);
            index--;
        }
    }

    /**
     * Returns a hash representation of the object, based on the hashCode of the
     * backing array
     * @return an integer hash of the set
     */
    public int hashCode() {
        return java.util.Arrays.hashCode(backingArray);
    }

    /**
     * Not implemented in this Set
     * @param a an array which specifies the runtime return type for toArray
     * @param <S> the return type of the array
     * @return null
     */
    @Override
    public <S> S[] toArray(S[] a) {
        return null;
    }


    /**
     * Returns the backing array directly.
     * This violates the set's encapsulation principle, but is necessary for
     * grading.
     * @return the backing array
     */
    public T[] getBackingArray() {
        return this.backingArray;
    }
}
