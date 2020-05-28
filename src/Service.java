abstract public class Service extends Node {

    protected String name;
    protected  String provider;
    protected String service_type;
    protected float base_cost;

    //GET RID OF provider, ADD PROVIDER FIELD

    //constructor
    public Service() {
        name = null;
        provider = null;
        service_type = null;
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


    //sets base cost to argument
    public boolean set_cost(float cost) {

        this.base_cost = cost;

        return true;
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

        return this.name.compareTo(compare) == 0;
    }


    //returns true calling object's name value is same as argument's
    public boolean match(Service compare) {

        return this.name.compareTo(compare.name) == 0;
    }


    //returns difference of calling object's name value and argument's;
    //positive numbers mean argument is ordered before calling object;
    //negative means argument is ordered after calling object
    public int compare(Service comparison) {

        return this.name.compareToIgnoreCase(comparison.name);
    }
}
