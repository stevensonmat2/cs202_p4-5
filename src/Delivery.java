public class Delivery extends Service {

    private float max_weight;
    private float max_distance;
    private float cost_per_mile;


    //constructor; calls parent's constructor via super();
    public Delivery() {

        super();
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




}
