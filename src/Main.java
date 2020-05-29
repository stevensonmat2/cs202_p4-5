import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Utility {

    public static void main(String[] args) throws IOException {

        Client session = new Client();

        session.read_in();
        session.menu();

    }
}
