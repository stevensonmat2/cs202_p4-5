public class Array_List extends Utility {

    private Link_List[] array;


    public Array_List() {

        array = null;
    }


    public Array_List(int size) {

        array = new Link_List[size];
    }


    protected int hasher(String to_hash)  {

        int hash = 1;

        char [] hashing = to_hash.toCharArray();

        for (int i=0; i < hashing.length; ++i) {

           hash *= hashing[i];
        }

        return hash /= this.array.length;


    }


//    public boolean add(Node to_add) {
//
//
//    }

}
    
//    public void build() {
//
//        System.out.println("how many people: ");
//        int len = input.nextInt();
//        input.nextLine();
//
//        this.array = new Node[len];
//        read_in();
//
//    }
    
//
//    public void display() {
//
//        for (Node node : array) {
//
//            if (node == null) {
//                return;
//            }
//            node.display();
//        }
//    }
//
//
//    public boolean find(String to_find) {
//
//        for (Node node : array) {
//
//            if (node.compare(to_find)) {
//
//                node.display();
//
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//
//    private void read_in() {
//
//        String reply;
//
//        for (int i=0; i < array.length; ++i) {
//
//            array[i] = new Node();
//            array[i].build();
//
//            if (i+1 != array.length) {
//
//                System.out.println("add another? y or n: ");
//                reply = input.nextLine();
//
//                if (reply.equalsIgnoreCase("n")) {
//                    i = array.length;
//                }
//            }
//
//            else System.out.println("max number added");
//        }
//
//        System.out.println("new array created: ");
//
//        display();
//    }
//}
