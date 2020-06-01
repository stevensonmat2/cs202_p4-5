/*
Matt Stevenson
CS202 Program #4
5/29/2020

this file contains the abstract base class Service. this provides the common
functionality for derived classes Delivery and Task.

 */

abstract public class Service extends Node {
    protected String name;
    protected  String provider;
    protected String service_type;
    protected float base_cost;


    //constructor
    public Service() {
        name = null;
        provider = null;
        service_type = null;
    }


    //copy constructor
    public Service(Service to_copy) {

        this.name = to_copy.name;
        this.provider = to_copy.provider;
        this.service_type = to_copy.service_type;
        this.base_cost = to_copy.base_cost;
    }


    //constructor with arguments
    public Service(float base, String name, String provider, String type) {

        this.name = name;
        this.provider = provider;
        this.service_type = type;
        this.base_cost = base;
    }


    //outputs member data
    public void display() {

        System.out.println("title: " + this.name);
        System.out.println("provider: " + this.provider);
        System.out.println("base cost: " + this.base_cost);
    }


    //sets name field to argument
    public boolean set_name(String set) {

        this.name = set;

        return true;
    }


//    sets base cost to argument
    public void set_cost(float cost) {

        this.base_cost = cost;
    }


    //returns true if calling object's name value is less than argument's
    public boolean less_than(Service compare) {

        return this.name.compareTo(compare.name) < 0;
    }


    //returns true if calling object's name value is greater than argument's
    public boolean greater_than(Service compare) {

        return this.name.compareTo(compare.name) > 0;
    }


    //returns true calling object's name value is same as argument
    public boolean match(String compare) {

        String current_name = this.name.replaceAll("\\s","");
        String c_name = compare.replaceAll("\\s","");

        return current_name.equalsIgnoreCase(c_name);
    }


    //returns true if calling object's name and provider fields match arguments
    public boolean match (String a_name, String a_provider) {

        String current_name = this.name.replaceAll("\\s","");
        String current_prov = this.provider.replaceAll("\\s","");
        String c_name = a_name.replaceAll("\\s","");
        String c_provider = a_provider.replaceAll("\\s","");

        System.out.println("hello" + c_name);

        return current_name.equalsIgnoreCase(c_name) && current_prov.equalsIgnoreCase(c_provider);
    }


    //returns true calling object's name value is same as argument's
    public boolean match(Service compare) {

        return this.name.compareToIgnoreCase(compare.name) == 0;
    }


    //returns difference of calling object's name value and argument's;
    //positive numbers mean argument is ordered before calling object;
    //negative means argument is ordered after calling object
    public int compare(Service comparison) {

        return this.name.compareToIgnoreCase(comparison.name);
    }


    //returns difference of calling object's name value and argument's;
    //positive numbers mean argument is ordered before calling object;
    //negative means argument is ordered after calling object
    public int compare(String comparison) {

        return this.name.compareToIgnoreCase(comparison);
    }


    //compares object's provider with argument
    public int compare_provider(Service comparison) {

        return this.provider.compareToIgnoreCase(comparison.provider);
    }


    //compares argument to object's type and return true if matching
    public boolean type_check(String comparison) {

        return this.service_type.equalsIgnoreCase(comparison);
    }

    //returns a csv string of object's fields
    abstract String write_csv();
}
