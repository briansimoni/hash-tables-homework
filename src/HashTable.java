
public class HashTable {

    private int size;
    private int totalCollisions;
    private int maxCollisions = 0;
    private SinglyLinkedList[] bucketlist;

    HashTable(int size) {
        this.bucketlist = new SinglyLinkedList[size];
        this.size = size;
    }

    public void insert(Object key, Object value) {

        int hashCode = hashCode((String)key);
        int index = (compression(hashCode, this.size));
        if (index < 0 ) index = index * -1;

        if(this.bucketlist[index] == null) {
            this.bucketlist[index] = new SinglyLinkedList();
            this.bucketlist[index].addNode(key, value);
        } else {
            this.bucketlist[index].addNode(key, value);

            // collision tracking
            this.totalCollisions++;
            if(this.bucketlist[index].getSize() > this.maxCollisions) {
                this.maxCollisions = this.bucketlist[index].getSize();
            }
        }
    }

    public Object getObject(Object key) {

        int hashCode = hashCode((String)key);
        int index = (compression(hashCode, this.size));
        if (index < 0 ) index = index * -1;

        if( this.bucketlist[index] != null && this.bucketlist[index].getNode(key) != null ) {
            return this.bucketlist[index].getNode(key).getValue();
        } else {
            return null;
        }
    }

    public int getTotalCollisions(){
        return this.totalCollisions;
    }

    public int getMaxCollisions(){
        return this.maxCollisions;
    }

    public int getSize(){
        return this.size;
    }

    public void printSizeOfBuckets(){
        for(int i = 0; i < this.bucketlist.length; i ++ ) {
            if (this.bucketlist[i] != null) {
                System.out.println(this.bucketlist[i].getSize());
            } else {
                System.out.println("null");
            }
        }
    }


    // hashCode function from:
    // Data Structures and Algorithms in Java, 6th edition
    // Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
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
