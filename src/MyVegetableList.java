import java.util.*;


public class MyVegetableList implements List<Vegetable> {
    private Node head;
    private Node tail;

    private int size;

    public MyVegetableList() {
        size = 0;
    }

    public MyVegetableList(Vegetable vegetable) {
        this();
        add(vegetable);
    }

    public MyVegetableList(Collection<Vegetable> collection){
        this();
        this.addAll(collection);
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
    public boolean contains(Object o) throws NullPointerException {
        if (this.isEmpty()) { throw new NullPointerException(); }
        if (this.head.getData().equals(o)) { return true; }

        Node next = head.getNext();
        while (next != null) {
            if (next.getData().equals(o)) {
                return true;
            }
            next = next.getNext();
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<Vegetable>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Vegetable next() {
                Node result = currentNode;
                if (hasNext()) {
                    currentNode = currentNode.getNext();
                } else {
                    throw new NoSuchElementException();
                }
                return result.getData();
            }
        };
    }


    @Override
    public boolean add(Vegetable vegetable) {
        Node node = new Node();
        node.setData(vegetable);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object vegetable) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Vegetable> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public Vegetable get(int index) {
        return null;
    }

    @Override
    public Vegetable set(int index, Vegetable element) {
        return null;
    }

    @Override
    public void add(int index, Vegetable element) {

    }

    @Override
    public Vegetable remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Vegetable> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Vegetable> listIterator(int index) {
        return null;
    }

    @Override
    public List<Vegetable> subList(int fromIndex, int toIndex) {
        return null;
    }
}
