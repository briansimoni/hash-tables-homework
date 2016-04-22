
public class HashTable {

    private int size;
    private SinglyLinkedList[] bucketlist;

    HashTable(int size) {
        this.bucketlist = new SinglyLinkedList[size];
        this.size = size;
    }

    public void insert(Object obj) {
        int hashCode = hashCode((String)obj);
        int index = (compression(hashCode, this.size));
        if(this.bucketlist[index] == null) {
            this.bucketlist[index] = new SinglyLinkedList();
        }
        this.bucketlist[index].addNode(obj);
    }

    public Object getObject(Object key) {
        int hashCode = hashCode((String)key);
        int index = (compression(hashCode, this.size));
        return this.bucketlist[index].getNode(key).getValue();
    }


    private int hashCode(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << 5) | (h >>> 27);
            h += (int) s.charAt(i);
        }
        return h;
    }

    private int compression(int i, int N) {
        return i % N;
    }

}
