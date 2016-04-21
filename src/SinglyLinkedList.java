/**
 * Created by maxxadmin on 4/20/16.
 */
public class SinglyLinkedList {

    private Node first;
    private Node head;
    private int size;


    SinglyLinkedList() {
        this.first = new Node(0, null);
        this.size = 0;
    }

    void addNode(int key, Object value){
        if(this.size == 0) {
            this.first.setKey(key);
            this.first.setValue(value);

            this.head = this.first;
            this.size++;

        } else {
            Node node = new Node(key, value);
            this.head.setNext(node);
            this.head = node;
            this.size++;
        }
    }

    void removeNode(){

    }

    Node getNode(int key) {
        Node x = this.first;
        while ((x.getKey() != key) && (x.getNext() != null)) {
            x = x.getNext();
        }
        return x;
    }

    int getSize() {
        return this.size;
    }

}
