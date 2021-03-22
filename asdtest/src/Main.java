
public class Main {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.addLast(10);
        skiplist.addLast(0);
        skiplist.addLast(0);
        skiplist.addLast(7);
        skiplist.addLast(0);
        skiplist.addLast(5);


        skiplist.print();


    }
}