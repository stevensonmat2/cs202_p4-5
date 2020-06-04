/*
Matt Stevenson
CS202 Program #4
5/29/2020

this file contains the Client class. this class provides the main user
interface for working with Service objects. it has a Tree object for saving
and retrieving Service objects.

 */
import java.io.*;
import java.util.Scanner;

public class Client extends Utility {

    //an AVL tree member for storing Service objects
    private Tree services;


    //constructor
    public Client() {

        this.services = new Tree();
    }


    //top level menu; prompts user to select business menu or customer menu
    public void main_menu() throws IOException {

        int reply;

        //output menu options until user exits
        do {

            System.out.println("Welcome");
            System.out.println();
            System.out.println("select a role: ");
            System.out.println();
            System.out.println("(1) business (add service)");
            System.out.println("(2) customer (search for services)");
            System.out.println();
            System.out.print("enter command: ");

            reply = input.nextInt();
            input.nextLine();
            System.out.println();

            //call method based on user input
            switch (reply) {

                //add a new Service
                case (1) -> b_menu();

                //display all services
                case (2) -> c_menu();

            }

        } while (reply != 0);//loop until user enters '0'
    }


    //main menu; provides user interface to work with functions of Client class
    public void b_menu() throws IOException {

        //stores user input
        int reply;

        //output menu options until user exits
        do {

            System.out.println();
            System.out.println("choose a command: ");
            System.out.println();
            System.out.println("(1) add service");
            System.out.println("(2) display services");
            System.out.println("(3) write to file");
            System.out.println("(4) edit service's cost");
            System.out.println("(0) exit");
            System.out.println();
            System.out.print("enter command: ");

            reply = input.nextInt();
            input.nextLine();
            System.out.println();

            //call method based on user input
            switch (reply) {

                //add a new Service
                case (1) -> add();

                //display all services
                case (2) -> display_all();

                //save Services in tree to file
                case (3) -> read_out();

                //edit the costs of a Service object
                case (4) -> edit_cost();
            }

        } while (reply != 0);//loop until user enters '0'
    }



    public void c_menu() throws IOException {

        //stores user input
        int reply;

        //output menu options until user exits
        do {

            System.out.println();
            System.out.println("choose a command: ");
            System.out.println();
            System.out.println("(1) display all Delivery services");
            System.out.println("(2) display all Task services");
            System.out.println("(3) filtered search");
            System.out.println("(4) display recent filtered searches");
            System.out.println("(0) exit");
            System.out.println();
            System.out.print("enter command: ");

            reply = input.nextInt();
            input.nextLine();
            System.out.println();

            //call method based on user input
            switch (reply) {

                //add a new Service
                case (1) -> display_type(reply);

                //display all services
                case (2) -> display_type(reply);

                //save Services in tree to file
                case (3) -> read_out();

                //edit the costs of a Service object
                case (4) -> edit_cost();
            }

        } while (reply != 0);//loop until user enters '0'
    }

    //SEARCH BY NAME/PROVIDER, TYPE, AND
    //search options menu
    public void search() {

        int reply;

        do {

            System.out.println();
            System.out.println("choose a command: ");
            System.out.println();
            System.out.println("(1) display all Delivery");
            System.out.println("(2) display all Task");
            System.out.println("(3) filtered search");
            System.out.println("(4) display recent searches");
            System.out.println("(0) exit");
            System.out.println();
            System.out.print("enter command: ");

            reply = input.nextInt();
            input.nextLine();
            System.out.println();

            //call method based on user input
            switch (reply) {

                //add a new Service
                case (1) -> display_type(reply);

                //display all services
                case (2) -> display_type(reply);

                //save Services in tree to file
//                case (3) -> read_out();

                //edit the costs of a Service object
//                case (4) -> edit_cost();
            }

        } while (reply != 0);//loop until user enters '0'
    }


    //displays all Delivery objects in tree
    public void display_type(int type) {

        String match;

        if (type == 1) {

            match = "delivery";
        }

        else match = "task";

        if (!this.services.display_match(match)) {

            System.out.println("no Services to display");
        }
    }


    //displays all Task objects in tree


    //BUSINESS USER FUNCTIONS

    //prompts user for info to create new Service object and inserts into
    //Client's tree member
    public void add() {

        //variables to hold user input; used to create Service object
        int type;
        float weight;
        float distance;
        float cost_mile;
        float base;
        String name;
        String provider;
        String category;
        String pay_type;
        Service temp = null;

        do {//prompt user for type of Service until valid input given

            System.out.println("what type of service?");
            System.out.println();
            System.out.print("(1) Delivery or (2) Task: ");
            type = input.nextInt();
            System.out.println();
            input.nextLine();

        } while (type < 1 || type > 2);

        //prompt user for member data common to all derived classes
        System.out.print("service name: ");
        name = input.nextLine();
        System.out.println();

        System.out.print("service provider name: ");
        provider = input.nextLine();
        System.out.println();

        System.out.print("base cost: ");
        base = input.nextFloat();
        System.out.println();
        input.nextLine();

        //prompt user for derived class specific data
        switch (type) {

            case (1) -> {
                System.out.print("maximum delivery weight (lbs): ");
                weight = input.nextFloat();
                System.out.println();
                input.nextLine();

                System.out.print("maximum delivery distance (miles): ");
                distance = input.nextFloat();
                System.out.println();
                input.nextLine();

                System.out.print("cost per mile: ");
                cost_mile = input.nextFloat();
                System.out.println();
                input.nextLine();

                //create new Delivery object with user input
                temp = new Delivery(weight, distance, cost_mile, base,
                        name, provider);
            }

            case (2) -> {
                System.out.print("category (repair, moving, etc): ");
                category = input.nextLine();
                System.out.println();

                System.out.print("pay type (hourly, flat rate, etc.): ");
                pay_type = input.nextLine();
                System.out.println();
                input.nextLine();

                //create new Task object with user input
                temp = new Task(category, pay_type, base, name, provider);
            }
        }

        //add new Service to tree
        this.services.insert(temp);

        //display all objects
        this.services.display_all();
        System.out.println();
    }


    //allows user to edit a Service object's costs
    public void edit_cost() {

        //variables to hold identifiers
        String name;
        String provider;

        //variables to hold new values
        float new_base;
        float cost_mile;
        String pay_type;

        //prompt user for info to find object to eidt
        System.out.print("service name: ");
        name = input.nextLine();
        System.out.println();

        System.out.print("service provider name: ");
        provider = input.nextLine();
        System.out.println();

        //find match in tree and save returned object
        Service temp = this.services.match(name, provider);

        //if no match found, alert user and exit
        if (temp == null) {

            System.out.println("no match found");
            System.out.println();

            return;
        }

        //else, prompt for new base cost
        System.out.print("enter new base cost: ");
        new_base = input.nextFloat();
        input.nextLine();
        System.out.println();

        //if found object is delivery type:
        if (temp.type_check("delivery")) {

            //save temp as a Delivery object
            Delivery obj = (Delivery)temp;

            //prompt for Delivery specific member data
            System.out.print("enter new cost per mile: ");
            cost_mile = input.nextFloat();
            input.nextLine();
            System.out.println();

            //call found object's set cost function with new values
            //**overloads base class function
            obj.set_cost(new_base, cost_mile);
        }

        else {

            //save temp as a Task object
            Task obj = (Task)temp;

            //prompt user for Task specific member data
            System.out.print("enter new pay type (hourly, flat fee, etc.): ");
            pay_type = input.nextLine();
            System.out.println();

            //call found object's set cost function with new values
            //**overloads base class function
            obj.set_cost(new_base, pay_type);

        }

        System.out.println();
        System.out.println("*service updated*");
        System.out.println();
    }


    //calls Client's tree's display all function to display all object's data
    public void display_all() {

        if (!this.services.display_all()) {

            System.out.println("no services to display");
        }
    }


    //calls tree objects read out function
    public void read_out() throws IOException {

        if (!this.services.read_out()) {

            System.out.println("nothing to save");
            System.out.println();
        }
    }


    //reads in from external file and inserts new objects per each new line
    //in the file
    public void read_in() throws FileNotFoundException {

        //create file object with specified text file
        File text = new File("src/services.txt");

        //create Scanner instance to read from external file
        Scanner reader = new Scanner(text);

        //set delimiter for reading file
        reader.useDelimiter(",");

        //to hold lines from external file
        String line;

        //define all variables needed to store data from external file
//        int type;
        float weight;
        float distance;
        float cost_mile;
        float base;
        String name;
        String provider;
        String category;
        String pay_type;

        //variable to hold new Service object
        Service temp;

        //begin reading in lines from external file
        do {

            //check that there are more objects to read in
            while (reader.hasNext()) {

                //if first item in line is "delivery"
                if (reader.next().equalsIgnoreCase("delivery")) {

                    //read in line data to object field variables
                    name = reader.next();
                    provider = reader.next();
                    base = reader.nextFloat();
                    weight = reader.nextFloat();
                    distance = reader.nextFloat();
                    cost_mile = reader.nextFloat();

                    //create new object with read in values
                    temp = new Delivery(weight, distance, cost_mile, base, name, provider);
                }

                //otherwise line will be Task object
                else {

                    //read in line data to object field variables
                    name = reader.next();
                    provider = reader.next();
                    base = reader.nextFloat();
                    category = reader.next();
                    pay_type = reader.next();

                    //create new object with read in values
                    temp = new Task(category, pay_type, base, name, provider);
                }

                //insert object into Client's tree
                this.services.insert(temp);
            }

            //check for next line; if found, set line variable
            if (reader.hasNextLine()) {

                line = reader.nextLine();
            }

            else line = null;

        //continue until no new line is found in file
        } while (line != null);

        System.out.println();
        System.out.println("*services added from external file*");
        System.out.println();
    }
}

