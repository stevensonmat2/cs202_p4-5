import java.io.FileNotFoundException;

public class Main extends Utility {

    public static void main(String[] args) throws FileNotFoundException {

        Client session = new Client();

        session.read_in();
        session.menu();

    }
}
