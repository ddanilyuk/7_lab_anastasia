import com.sun.istack.internal.NotNull;

import java.util.*;


public class MyVegetableList implements List<Vegetable> {
    private Node head;
    private Node tail;

    private int size;

    static void separator(String title) {
        System.out.println("\n========" + title + "========");
    }

    MyVegetableList() {
        size = 0;
    }


    MyVegetableList(Vegetable vegetable) {
        this();
        add(vegetable);
    }


    MyVegetableList(Collection<Vegetable> collection) {
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
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        if (this.head.getData().equals(o)) {
            return true;
        }

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
        Node next = head;
        Object[] arr = new Object[this.size()];
        int i = 0;

        while (next != null) {
            arr[i] = next.getData();
            next = next.getNext();
            ++i;
        }
        return arr;
    }


    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        if (!(a instanceof MyVegetableList[])) throw new ArrayStoreException();
        if (this.size() > a.length) {
            return (T1[]) this.toArray();
        }

        int i = 0;
        for (Object obj : this.toArray()) {
            a[i] = (T1) obj;
            ++i;
        }
        return a;
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
            node.setPrevious(tail);
            tail = node;
        }
        size++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (!this.contains(o)) {
            System.out.println("Already not in collection");
            return false;
        }
        Node current = head;
        if (current.getData().equals(o)) {
            head = current.getNext();
            size -= 1;
            return true;
        }
        Node previous = null;
        while (current != null) {
            if (current.getData().equals(o)) {
                previous.setNext(current.getNext());
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() > size()) {
            return false;
        }
        for (Object obj : c) {
            if (!this.contains(obj)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        for (Vegetable vegetable : c) {
            this.add(vegetable);
        }
        return true;
    }


    //    @Override
//    public boolean addAll(int index, Collection<? extends Vegetable> c) {
//        return false;
//    }
    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Vegetable> c) throws IllegalArgumentException {
        if (index > this.size()) {
            throw new IllegalArgumentException();
        }

        Node from = head;
        for (int i = 0; i < index; ++i) {
            System.out.println(i);
            from = from.getNext();
        }
        System.out.println("1breakpoint");
        Node temp = tail;
        tail = from.getPrevious();

        System.out.println("2breakpoint");
        this.addAll(c);

        System.out.println("3breakpoint");
        tail.setNext(temp);
        temp.setPrevious(tail);

        System.out.println("4breakpoint");
        tail = temp;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object obj : c) {
            this.remove(obj);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object obj : this) {
            if (!c.contains(obj)) {
                System.out.println(obj);
                this.remove(obj);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public Vegetable get(int index) throws IndexOutOfBoundsException {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        Node which = head;
        for (int i = 0; i < index; ++i) {
            which = which.getNext();
        }

        return (Vegetable) which.getData();
    }

    @Override
    public Vegetable set(int index, Vegetable element)
            throws IndexOutOfBoundsException {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == this.size()) {
            this.add(element);
            return (Vegetable) tail.getPrevious().getData();
        }
        if (index == 0) {
            Node oldHead = head;
            head = new Node();
            head.setData(element);
            this.head.setNext(oldHead);
            oldHead.setPrevious(this.head);
            size += 1;
            return (Vegetable) this.head.getData();
        }

        Node from = this.head;
        for (int i = 1; i < index; ++i) {
            from = from.getNext();
        }

        Node temp = tail;
        Node next = from.getNext();
        tail = from;
        this.add(element);

        tail.setNext(next);
        if (next != null)
            next.setPrevious(tail);
        tail = temp;

        return (Vegetable) from.getData();
    }

    @Override
    public void add(int index, Vegetable element) throws IndexOutOfBoundsException {
        this.set(index + 1, element);
    }

    @Override
    public Vegetable remove(int index) {
        Vegetable which = this.get(index);
        this.remove(which);
        return which;
    }

    @Override
    public int indexOf(Object o) {
        Node node = head;
        for (int i = 0; i < this.size(); ++i) {
            if (node.getData().equals(o)) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node node = tail;
        for (int i = this.size() - 1; i >= 0; --i) {
            if (node.getData().equals(o)) {
                return i;
            }
            node = node.getPrevious();
        }
        return -1;
    }

    @Override
    public ListIterator<Vegetable> listIterator() {
        return (ListIterator<Vegetable>) this.iterator();
    }

    @Override
    public ListIterator<Vegetable> listIterator(int index) {
        if (index < 0 || index > this.size())
            throw new IndexOutOfBoundsException();
        ListIterator<Vegetable> listIterator = this.listIterator();
        for (int i = 0; i < index; ++i) listIterator.next();
        return listIterator;
    }

    @Override
    public List<Vegetable> subList(int fromIndex, int toIndex) {
        return null;
    }

//    @Override
//    public List<Vegetable> subList(int fromIndex, int toIndex)
//            throws IndexOutOfBoundsException {
//        if (fromIndex > toIndex && toIndex > this.size() && fromIndex < 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        int size = toIndex - fromIndex;
//        List<Vegetable> sublist = new MyVegetableList();
//
//        Node forHead = head;
//        for (int i = 0; i < fromIndex; ++i) forHead = forHead.getNext();
//
//        Node forTail = tail;
//        for (int i = this.size() - 1; i > this.size() - fromIndex - size; --i)  forTail = forTail.getPrevious();
//
//        head = forHead;
//        tail = forTail;
//        head.setPrevious(null);
//        tail.setNext(null);
//        this.size = size;
//
//        return sublist;
//    }
}
