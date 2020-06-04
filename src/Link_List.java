/*
Matt Stevenson
CS202 Program #4
5/29/2020

this file contains the Link List class. this class provides all functionality
to manage linked lists of Service objects.
 */

import java.io.BufferedWriter;
import java.io.IOException;



public class Link_List extends Node {

    //head of linked list
    private Service head;


    //constructor
    public Link_List() {
        this.head = null;
    }


    //wrapper; adds argument object to list
    public boolean add(Service to_add) {

        //variable to hold new Service object
        Service temp;

        //check type of argument object and create new copy
        if (to_add.type_check("delivery")) {

            temp = new Delivery((Delivery)to_add);
        }

        else temp = new Task((Task)to_add);

        //if list is empty, set new object as head of list
        if (this.head == null) {

            this.head = temp;

            return true;
        }

        //if new object comes before head, insert at head of list
        if (this.head.compare_provider(temp) > 0) {

            temp.set_next(this.head);
            this.head = temp;

            return true;
        }

        //else, call recursive function to insert argument into list and set
        //head to downcasted return value
        this.head = add(this.head, temp);

        return true;
    }


    //recursively finds insertion point for argument
    //and returns updated list
    protected Service add(Service head, Service to_add) {

        //if at last Service, insert at end of list or unwind
        if (head.get_next() == null) {

            //if argument comes after current Service or is a match
            if (head.compare_provider(to_add) <= 0) {

                //insert after current
                head.set_next(to_add);
            }

            return head;
        }

        //traverse to end of list and reconnect as stack unwinds;
        //downcasting return of head's next
        head.set_next(add((Service)head.get_next(), to_add));

        //after recursive call, compare argument to current
        if (head.compare_provider(to_add) < 0) {

            //if current comes before argument, insert argument between current
            //and current's next
            to_add.set_next(head.get_next());
            head.set_next(to_add);
        }

        return head;
    }


    //wrapper; returns Service object from list if its fields match the
    // argument Strings, otherwise returns null
    public Service match(String name, String provider) {

        //if list is empty, return null
        if (this.head == null) {

            return null;
        }

        //if first item in list does not match name, return null
        if (!this.head.match(name)) {

            return null;
        }

        //return result of recursive  function
        return match(name, provider, this.head);
    }


    //recursive function traverses list and checks each object for a match
    //against arguments; returns the object if it matches, else null
    protected Service match(String name, String provider, Service head) {

        //if end of list, return null
        if (head == null) {

            return null;
        }

        //if object's fields match arguments, return object
        if (head.match(name, provider)) {

            return head;
        }

        //recursively traverse
        return match(name, provider, (Service)head.get_next());
    }


    //compares head object with argument
    public int compare(Service comparison) {

        return this.head.compare(comparison);
    }


    //compares head object with argument
    public int compare(String comparison) {

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


    //wrapper; if list is empty, returns false; otherwise, calls
    //recursive function to traverse list and call each object's display
    public boolean display_type(String type) {

        //if list empty, return false
        if (this.head == null) {

            return false;
        }

        //return value of recursive function
        return display_type(type, this.head);
    }


    //recursively traverses list and calls each object display function;
    //returns true when end of list reached
    protected boolean display_type(String type, Service head) {

        //return true when end of list reached
        if (head == null) {

            return true;
        }

        //call object's display

        if (head.type_check(type)) {

            head.display();
            System.out.println();
        }

        //traverse to next object in list
        return display_type(type, (Service) head.get_next());
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

        if (head.get_next() != null) {

            writer.newLine();
        }

        //traverse to next object
        write_csv(writer, (Service)head.get_next());
    }
}
