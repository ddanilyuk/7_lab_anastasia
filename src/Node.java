public class Node {
    private Node next;
    //private Node previous;
    private Vegetable data;

//    public Node(Vegetable vegetable) {
//        this.data = vegetable;
//    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    public Vegetable getData() {
        return data;
    }

    public void setData(Vegetable data) {
        this.data = data;
    }
}