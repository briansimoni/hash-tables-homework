/**
 * Created by maxxadmin on 4/20/16.
 */
public class Node {

    private int key;
    private Object value;
    private Node next = null;


    Node(int key, Object value) {
        this.value = value;
        this.key = key;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }


}
