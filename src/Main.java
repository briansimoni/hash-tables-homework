public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println(hashCode("hello"));
//        int helloHash = hashCode("hello");
//        System.out.println(compression(helloHash, 4000));
//        System.out.println(compression(hashCode("world"), 4000));

        SinglyLinkedList list = new SinglyLinkedList();
        list.addNode(1, "asdf");
        list.addNode(2, "farts");
        list.addNode(3, "three");
        System.out.println(list.getNode(1).getValue());
//        System.out.println(list.getFirst().getNext().getNext().getKey());
//        System.out.println(list.getFirst().getNext().getKey());
//        System.out.println(list.getFirst().getKey());
//        System.out.println(list.getFirst().getNext().getKey());


//        Node first = new Node(0, "String");
//        first.setNext(new Node(1, "two"));
//        System.out.println(first.getValue());
//        System.out.println(first.getNext().getValue());
//        first.getNext().setNext(new Node(2, "three"));
//        System.out.println(first.getNext().getNext().getValue());
    }


    static int hashCode(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << 5) | (h >>> 27);
            h += (int) s.charAt(i);
        }
        return h;
    }

    static int compression(int i, int N) {
        return i % N;
    }


}
