import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl<E> implements MyList<E>,Iterable<E> {
    private final static int DEFAULT_CAPACITY = 10;
    private Object[] myListData;
    private int size;

    public MyListImpl() {
        myListData = new Object[DEFAULT_CAPACITY];
        size = myListData.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(myListData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void add(E e) {
        int newCapacity = myListData.length + 1;
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = myListData[i];
        }
        newData[size++] = e;
        myListData = newData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(myListData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || myListData.length <= index) {
            throw new IndexOutOfBoundsException();
        }

        E oldValue = (E) myListData[index];

        size--;
        Object[] newData = new Object[size];
        for (int i = 0; i < index; i++) {
            newData[i] = myListData[i];
        }

        for (int i = index; i < newData.length; i++) {
            newData[i] = myListData[i + 1];
        }

        myListData = newData;
        return oldValue;
    }

    @Override
    public void remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
        }
    }

    @Override
    public void clear() {
        size = 0;
        if (myListData.length != DEFAULT_CAPACITY) {
            myListData = new Object[DEFAULT_CAPACITY];
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || myListData.length <= index) {
            throw new IndexOutOfBoundsException();
        }
        return (E) myListData[index];
    }

    @Override
    public void set(int index, E element) {
        if (index < 0 || myListData.length <= index) {
            throw new IndexOutOfBoundsException();
        }
        myListData[index] = element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentPosition = 0;
            @Override
            public boolean hasNext() {
                return currentPosition < size;
            }

            @Override
            public E next() {
                if (currentPosition >= size){
                    throw new NoSuchElementException();
                }
                return get(currentPosition++);
            }
        };
    }
}
