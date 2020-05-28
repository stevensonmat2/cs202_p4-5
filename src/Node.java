
//Node class; provides functionality to derived classes for constructing linked
//lists and trees
abstract class Node extends Utility {

    //references for tree and list construction
    private int height;
    private Node left;
    private Node right;
    private Node next;


    //constructor
    public Node() {
        this.next = null;
        this.left = null;
        this.right = null;
    }

    //returns object's height
    public int get_height() {

        return this.height;
    }


    //sets height of node
    public void set_height(int h) {

        this.height = h;
    }


    //sets Node's left
    public void set_left(Node set) {

        this.left = set;
    }


    //sets Node's right
    public void set_right(Node set) {

        this.right = set;
    }


    //returns Node's left
    public Node get_left() {

        return this.left;
    }


    //returns Node's right
    public Node get_right() {

        return this.right;
    }


    //sets Node's next to argument
    public void set_next(Node to_add) {

        this.next = to_add;
    }


    //returns Node's next
    public Node get_next() {

        return this.next;
    }
}
