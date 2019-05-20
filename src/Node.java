public class Node {
    private Node next;
    private Node previous;
    private Vegetable data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Vegetable getData() {
        return data;
    }

    public void setData(Vegetable data) {
        this.data = data;
    }
}
