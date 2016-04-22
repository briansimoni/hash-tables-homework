
public class SinglyLinkedList {

    private Node first;
    private Node head;
    private int size;


    SinglyLinkedList() {
        this.first = new Node(0, null);
        this.size = 0;
    }

    void addNode(Object key, Object value){
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


    Node getNode(Object key) {
        Node x = this.first;
        while( !x.getKey().equals(key) && x.getNext() != null ) {
            x = x.getNext();
        }
        return x;
    }

    int getSize() {
        return this.size;
    }

}
