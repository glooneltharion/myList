public interface MyList<E>{
    void add(E e);
    int size();
    boolean isEmpty();
    int indexOf(Object o);
    boolean contains(Object o);
    E remove(int index);
    void remove(Object o);
    void clear();
    E get(int index);
    void set(int index, E element);
}
