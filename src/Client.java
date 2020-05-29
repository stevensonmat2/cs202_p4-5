import java.io.*;
import java.util.Scanner;

public class Client extends Utility {

    private Tree services;
    private Array_List searches;


    //constructor
    public Client() {

        this.services = new Tree();
    }


    //main menu; provides user interface to work with functions of Client class
    public void menu() throws IOException {

        int reply;

        do {

            System.out.println("Welcome");
            System.out.println();
            System.out.println("choose a command: ");
            System.out.println();
            System.out.println("(1) add service");
            System.out.println("(2) display services");
            System.out.println("(3) display service");
            System.out.println("(4) edit service");
            System.out.println("(0) exit");
            System.out.println();
            System.out.print("enter command: ");

            reply = input.nextInt();
            System.out.println();

            switch (reply) {

                case (1):
                    //
                    add();
                    break;

                case (2):
                    //
                    display_all();
                    break;

                case (3):
                    //
                    read_out();
                    break;

                case (4):
                    //
//                    edit();
                    break;

                case (5):

                    break;

            }

        } while (reply != 0);
    }


    //prompts user for info to create new Service object and inserts into
    //Client's tree member
    public void add() {

        int type;
        float weight = 0;
        float distance = 0;
        float cost_mile = 0;
        float base = 0;
        String name;
        String provider = null;
        String category = null;
        String pay_type = null;
        Service temp = null;

        do {

            System.out.println("what type of service?");
            System.out.println();
            System.out.print("(1) Delivery or (2) Task: ");
            type = input.nextInt();
            System.out.println();
            input.nextLine();

        } while (type < 1 || type > 2);

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

                temp = new Task(category, pay_type, base, name, provider);
            }
        }

        this.services.insert(temp);

        this.services.display_all();
        System.out.println();
    }


    //allows user to edit a Service object
    public void edit() {

    String service;
    Service temp;

    System.out.print("enter name of service to edit: ");
    service = input.nextLine();

    //set temp to return value of Tree's function
//            temp = services.retrieve(service);
//
//            System.out.println("enter new name: ");
//            service = input.nextLine();
//            temp.set_name(service);
//        }
//
//        if (!services.add(temp)) {
//
//            System.out.println("insertion failed!");
//            System.out.println();
//
//        }
//
//        else {
//
//            System.out.println("service added!");
//            System.out.println();
    }


    //calls Client's tree's display all function to display all object's data
    public void display_all() {

        this.services.display_all();
    }



    public void read_out() throws IOException {

        this.services.read_out();
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

