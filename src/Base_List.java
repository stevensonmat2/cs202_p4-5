abstract public class Base_List extends Utility {

    protected String name;


    public Base_List() {

        name = null;
    }


    abstract void build();
    abstract  void display();
    abstract boolean find(String to_find);

}
