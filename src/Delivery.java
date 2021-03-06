/*
Matt Stevenson
CS202 Program #4
5/29/2020

this file contains the Delivery class. it is derived from Service and contains
functions that overload base class functions and function that override base
class functions.

 */

public class Delivery extends Service {

    //unique members
    private float max_weight;
    private float max_distance;
    private float cost_per_mile;


    //constructor; calls parent's constructor via super();
    public Delivery() {

        super();
    }


    //copy constructor
    public Delivery(Delivery to_copy) {

        super(to_copy);

        this.max_weight = to_copy.max_weight;
        this.max_distance = to_copy.max_distance;
        this.cost_per_mile = to_copy.cost_per_mile;
    }


    //constructor with arguments; calls parent's constructor with arguments
    public Delivery(float weight, float distance, float cost_mile,
                    float base, String name, String provider) {

        //pass argument to parent constructor
        super(base, name, provider, "delivery");

        this.max_distance = distance;
        this.max_weight = weight;
        this.cost_per_mile = cost_mile;
    }


    //outputs all fields of object and calls parent display via super
    public void display() {

        super.display();

        System.out.println("cost per mile: " + this.cost_per_mile);
        System.out.println("max weight: " + this.max_weight);
        System.out.println("max distance: " + this.max_distance);
    }


    //updates base cost and cost per mile fields with arguments
    public void set_cost(float base, float cost_per_mile) {

        this.base_cost = base;
        this.cost_per_mile = cost_per_mile;
    }


    //returns a string of all field data concatenated with commas so object
    //can be saved in csv format to external file
    public String write_csv() {

        String csv = new String(this.service_type + "," + this.name + ","
                + this.provider + "," + this.base_cost + ","
                + this.max_weight + "," + this.max_distance + ","
                + this.cost_per_mile + ",");

        return csv;
    }

}
