
public class Node {

    private Object key;
    private Object value;
    private Node next = null;


    Node(Object key, Object value) {
        this.value = value;
        this.key = key;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }


}
