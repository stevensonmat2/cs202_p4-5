/*
Matt Stevenson
CS202 Program #4
5/29/2020

this is the first part of a program to allow users to create and find paid
services. this part is for business users who wish to create and edit
services they wish to provide.

currently, users can create either Delivery or Task services, edit their
service posts, and display all services. the Client object provides all
functionality for interacting with services.

 */
import java.io.IOException;

public class Main extends Utility {

    //main
    public static void main(String[] args) throws IOException {

        //create new Client object
        Client session = new Client();

        //read in saved objects from external file
        session.read_in();

        //open main menu
        session.main_menu();
    }
}
