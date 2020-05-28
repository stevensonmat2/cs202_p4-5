public class Task extends Service {

    private String type;
    private String pay_type;


    //constructor; calls parent's constructor via super();
    public Task() {

        super();
    }


    //constructor with arguments; calls parent's constructor with arguments
    public Task(String type, String p_type,
                    float base, String name, String provider) {

        super(base, name, provider, "task");
        this.type = type;
        this.pay_type = p_type;
    }


    //outputs all fields of object and calls parent display via super
    public void display() {

        super.display();

        System.out.println("type of payment: " + this.pay_type);
        System.out.println("type of work: " + this.type);
    }


    //updates base cost and cost per mile fields with arguments
    public void set_cost(float base, String pay_type) {

        this.base_cost = base;
        this.pay_type = pay_type;
    }
}
