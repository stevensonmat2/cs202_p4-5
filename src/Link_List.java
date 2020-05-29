import java.io.BufferedWriter;
import java.io.IOException;

//ADD RETRIEVE; SUPPORT TWO STRINGS
public class Link_List extends Node {

    private Service head;


    public Link_List() {
        this.head = null;
    }


    //wrapper; adds argument object to list
    public boolean add(Service to_add) {

        //if list is empty, set argument as head of list
        if (this.head == null) {

            this.head = to_add;

            return true;
        }

        //if argument comes before head, insert argument at head of list
        if (this.head.less_than(to_add)) {

            to_add.set_next(this.head);
            this.head = to_add;

            return true;
        }

        //else, call recursive function to insert argument into list and set
        //head to downcasted return value
        this.head = add((Service) this.head, to_add);

        return true;
    }

    //FIX SO FUNCTION CHECKS FIELD OTHER THAN NAME; IMPLEMENT NEW
    //COMPARE FUNCTION IN SERVICE
    //recursively finds insertion point for argument
    //and returns updated list
    protected Service add(Service head, Service to_add) {

        //if at last Service, insert at end of list or unwind
        if (head.get_next() == null) {

            //if argument comes after current Service or is a match
            if (to_add.greater_than(head) || to_add.match(head)) {

                //insert after current
                head.set_next(to_add);
            }

            return head;
        }

        //traverse to end of list and reconnect as stack unwinds;
        //downcasting return of head's next
        head.set_next(add((Service)head.get_next(), to_add));

        //after recursive call, compare argument to current
        if (head.greater_than(to_add)) {

            //if current comes before argument, insert argument between current
            //and current's next
            to_add.set_next(head.get_next());
            head.set_next(to_add);
        }

        return head;
    }


    //wrapper; removes Service matching argument from list
    public boolean remove(String rem) {

        //boolean passed to recursive argument; stores success or fail of
        //recursive removal
        boolean[] removed = {false};

        //if list empty, exit with fail
        if (this.head == null) {

            return false;
        }

        //if first item in list matches, remove and exit
        if (this.head.match(rem)) {

            //downcast return of head's next
            this.head = (Service) this.head.get_next();

            return true;
        }

        //else, call recursive function to remove matching object and set head
        //to return value
        this.head = remove(this.head, rem, removed);

        //return boolean as modified by recursive function to indicate success
        //or failure of removal
        return removed[0];
    }


    //recursively searches list for match; if found, removes match from list
    protected Service remove(Service head, String rem, boolean[] removed) {

        //if end of list, check for match
        if (head.get_next() == null) {

            //if match, remove, set boolean to true, and return null
            if (head.match(rem)) {

                removed[0] = true;
                return null;
            }

            //else return current
            return head;
        }

        //traverse to end of list and reconnect as stack unwinds
        head.set_next(remove((Service) head.get_next(), rem, removed));

        //if match, remove, set boolean to true and return current's next
        if (head.match(rem)) {

            removed[0] = true;
            return (Service) head.get_next();
        }

        //else return current
        return head;
    }


    //compares head object with argument
    public int compare(Service comparison) {

        return this.head.compare(comparison);
    }


    //wrapper; if list is empty, returns false; otherwise, calls
    //recursive function to traverse list and call each object's display
    public boolean display() {

        //if list empty, return false
        if (this.head == null) {

            return false;
        }

        //return value of recursive function
        return display(this.head);
    }


    //recursively traverses list and calls each object display function;
    //returns true when end of list reached
    protected boolean display(Service head) {

        //return true when end of list reached
        if (head == null) {

            return true;
        }

        //call object's display
        head.display();
        System.out.println();

        //traverse to next object in list
        return display((Service) head.get_next());
    }


    //wrapper; call recursive function to write data for all objects in list
    //to external file
    public void write_csv(BufferedWriter writer) throws IOException {

        //exit if head is null
        if (this.head == null) {

            return;
        }

        //call recursive function
        write_csv(writer, this.head);
    }


    //recursive function traverses linked list and passes the return value of
    //each object's write to csv file to the writer object's write function
    protected void write_csv(BufferedWriter writer, Service head) throws IOException {

        //if head is null, unwind
        if (head == null) {

            return;
        }

        //call writer's write function and pass in each object's write to csv
        //return value
        writer.write(head.write_csv());
        writer.newLine();

        //traverse to next object
        write_csv(writer, (Service)head.get_next());
    }
}
