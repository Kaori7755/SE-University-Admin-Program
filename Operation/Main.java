package Operation;
import Info.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ItemInList {
        GUI gui= new GUI(); //create gui object
        gui.start();
        gui.run();
        gui.end();
    }
}