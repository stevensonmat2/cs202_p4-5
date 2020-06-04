public class Array_List extends Utility {



    private Link_List[] array;


    //constructor
    public Array_List() {

        array = null;
    }


    public Array_List(int size) {

        array = new Link_List[size];
    }


    //creates and returns hash value based on String argument
    protected int hasher(String to_hash)  {

        //start hash at 1 for multiplication
        int hash = 1;

        //convert String argument to array of characters for iteration
        char [] hashing = to_hash.toCharArray();

        //multiply each character's value by the previous character's
        for (int i=0; i < hashing.length; ++i) {

           hash *= hashing[i];
        }

        //return the modulus of the product by the array's length
        return hash % this.array.length;
    }


    //adds argument list to member array if array is not full
    public boolean add(Service to_add) {

        int i = hasher(to_add.hashable_id());

        //check index matching hash value; if empty, add new link list
        if (array[i] == null) {

            array[i] = new Link_List();
        }

        //insert Service object to link list
        array[i].add(to_add);

        return true;
    }


    //traverses array of lists and calls each list's display function
    public void display_all() {

        int i = 0;

        display_all(i);
    }


    //recursively traverses array and calls each list's display function
    private void display_all(int i) {

        //if index is beyond bounds of array, exit
        if (i >= this.array.length) {

            return;
        }

        //if current index has a list, call its display function
        if (this.array[i] != null) {

            this.array[i].display();
        }

        //increment index value
        ++i;

        //recursively traverse
        display_all(i);
    }

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
