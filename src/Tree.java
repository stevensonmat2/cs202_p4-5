/*
Matt Stevenson
CS202 Program #4
5/29/2020

this file contains the Tree class. it is an AVL tree, and supports insertion,
search, display, and retrieval. this class can also write its object data
to an external file.

 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Tree extends Utility {

    private Link_List root;


    //calculates and returns updated height of argument
    public int update_height(Link_List node) {

        //integers to store left and right object's heights
        int left = 0;
        int right = 0;

        //check that argument's left is not null
        if (node.get_left() != null) {

            //set left to argument's left objects's height
            left = node.get_left().get_height();
        }

        //check that argument's right is not null
        if (node.get_right() != null) {

            //set right to argument's right object's height
            right = node.get_right().get_height();
        }

        //add 1 to largest number and return
        return 1 + max(left, right);
    }


    //returns balance factor of argument
    public int get_balance(Link_List check) {

        //integers to store left and right object's heights
        int right = 0;
        int left = 0;

        //exit if argument is null
        if (check == null) {

            return 0;
        }

        //check that argument's left is not null
        if (check.get_left() != null) {

            //set left to argument's left objects's height
            left = check.get_left().get_height();
        }

        //check that argument's right is not null
        if (check.get_right() != null) {

            //set right to argument's right object's height
            right = check.get_right().get_height();
        }

        //return difference of left's height and right's
        return left - right;
    }


    //right rotates subtree about argument object
    public Link_List right_rotate(Link_List root) {

//        System.out.println("rotate right");
//        System.out.println();

        //save root's left
        Link_List new_root = (Link_List)root.get_left();

        //save new root's right
        Link_List new_left = (Link_List)new_root.get_right();

        //set new root's left to old root
        new_root.set_right(root);

        //set old root's right to new root's old right
        root.set_left(new_left);

        //reset heights for new and old roots
        root.set_height(update_height(root));
        new_root.set_height(update_height(new_root));

        return new_root;
    }


    //left rotates subtree about argument object
    public Link_List left_rotate(Link_List root) {

//        System.out.println("rotate left");
//        System.out.println();

        //save root's right as new root
        Link_List new_root = (Link_List)root.get_right();

        //save new root's left
        Link_List new_right = (Link_List)new_root.get_left();

        //set new root's left to old root
        new_root.set_left(root);

        //set old root's right to new root's old left
        root.set_right(new_right);

        //reset heights for new and old roots
        root.set_height(update_height(root));
        new_root.set_height(update_height(new_root));

        return new_root;
    }


    //wrapper; calls recursive function to insert and balance if needed
    public void insert(Service to_add) {

        this.root = insert(this.root, to_add);
    }


    //recursively inserts a new object into the tree and balances tree
    public Link_List insert(Link_List root, Service to_add) {

        if (root == null) {

            //create new list object
            root = new Link_List();

            //update root's height
            root.set_height(1);//REPLACE WITH UPDATE HEIGHT

            //add Service object to list
            root.add(to_add);

            //return list object
            return root;
        }

        //if Service object has same name as root's head
        if (root.compare(to_add) == 0) {

            //add new Service object to list
            root.add(to_add);

            //return list object
            return root;
        }

        //else if Service object's name orders before the root's
        //head's name
        if (root.compare(to_add) > 0) {

            //traverse to root's left reference
            root.set_left(insert((Link_List)root.get_left(), to_add));
        }

        //otherwise, traverse to root's right reference
        else root.set_right(insert((Link_List)root.get_right(), to_add));

        //update root's height
        root.set_height(update_height(root));

        //get balance of root
        int balance = get_balance(root);

        //if tree is imbalanced to the left
        if (balance > 1) {

            //save root's left reference
            Link_List temp = (Link_List)root.get_left();

            //if temp exists, compare its head's name to new Service object's
            if (temp != null && temp.compare(to_add) > 0) {

                //if temp's head's name is ordered after new Service's name
                //rotate right about root and return new root
                return right_rotate(root);
            }

            //if temp exists, compare its head's name to new Service object's
            if (temp != null && temp.compare(to_add) < 0) {

                //if temp's head's name orders before new Service's name,
                //left rotate about root's left reference, then right
                //rotate about root and return new root
                root.set_left(left_rotate(temp));
                return right_rotate(root);
            }
        }

        //if tree is imbalanced to the right
        if (balance < -1) {

            //save root's right reference
            Link_List temp = (Link_List) root.get_right();

            //if temp exists, compare its head's name to new Service object's
            if (temp != null && temp.compare(to_add) < 0) {

                //if temp's head's name is ordered before new Service's name
                //left rotate about root and return new root
                return left_rotate(root);
            }

            //if temp exists, compare its head's name to new Service object's
            if (temp != null && temp.compare(to_add) > 0) {

                //if temp's head's name orders after new Service's name,
                //right rotate about root's right reference, then left
                //rotate about root and return new root
                root.set_right(right_rotate(temp));
                return left_rotate(root);
            }
        }

        //if tree is balanced, return root
        return root;
    }


    //wrapper; calls function to search tree for a list containing an object
    //that matches the argument strings; returns object if match, else null
    public Service match(String name, String provider) {

        //if tree is empty, return null
        if (this.root == null) {

            return null;
        }

        //return value of recursive search
        return match(name, provider, this.root);
    }


    //recursive function searches tree for list containing matching object;
    //returns matching object or null if none found
    protected Service match(String name, String provider, Link_List root) {

        //variable to store found object
        Service found = null;

        //if root is null, return null
        if (root == null) {

            return null;
        }

        //see if root contains matching object
        found = root.match(name, provider);

        //if root does not contain match:
        if (found == null) {

            //check name against root's objects to determine
            //left or right traversal
            if (root.compare(name) > 0) {

                //travers left
                found = match(name, provider, (Link_List)root.get_left());
            }

            //traverse right
            else found = match(name, provider, (Link_List)root.get_right());
        }

        //return found once a match is found or all nodes checked
        return found;
    }

    //wrapper; if tree not empty, calls recursive display function and
    //returns true; otherwise returns false
    public boolean display_all() {

        if (root == null) {

            return false;
        }

        //call recursive function
        return display_all(this.root);
    }


    public boolean display_match(String match) {

        if (root == null) {

            return false;
        }

        //call recursive function
        return display_match(match, this.root);
    }


    //traverses tree inorder and calls display function for each object in tree
    protected boolean display_match(String match, Link_List root) {

        //store return value of recursive calls
        boolean val;

        //unwind when null reference encountered
        if (root == null) {

            return true;
        }

        //traverse left
        val = display_match(match, (Link_List)root.get_left());

        //call display function once left-most object in branch encountered
        root.display_type(match);
//        System.out.println("height: " + root.get_height());
//        System.out.println();

        //traverse right
        val = display_match(match, (Link_List)root.get_right());

        //return value of recursive calls
        return val;
    }


    //traverses tree inorder and calls display function for each object in tree
    protected boolean display_all(Link_List root) {

        //store return value of recursive calls
        boolean val;

        //unwind when null reference encountered
        if (root == null) {

            return true;
        }

        //traverse left
        val = display_all((Link_List)root.get_left());

        //call display function once left-most object in branch encountered
        root.display();
        System.out.println("height: " + root.get_height());
        System.out.println();

        //traverse right
        val = display_all((Link_List)root.get_right());

        //return value of recursive calls
        return val;
    }


    //writes contents of tree to external file
    public boolean read_out() throws IOException {

        if (this.root == null) {

            return false;
        }

        //get file to write to
        File text = new File("src/services.txt");

        //create BufferedWriter object with file
        BufferedWriter writer = new BufferedWriter(new FileWriter(text));

        //call recursive function to write to file
        read_out(writer, this.root);

        //flush writer to save to disk
        writer.close();

        return true;
    }


    //recursive function to traverse tree inorder and write out object data to
    //external file
    public void read_out(BufferedWriter writer, Link_List root)
                                            throws IOException {
        //unwind if node is null
        if (root == null) {

            return;
        }

        //traverse all the way left
        read_out(writer, (Link_List)root.get_left());

        //call Link_List node object's write out function, passing in the writer
//        writer.newLine();
        root.write_csv(writer);

        //traverse all the way right
        read_out(writer, (Link_List)root.get_right());
    }
}




