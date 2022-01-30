import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
    public static void main(String[] args) throws FileNotFoundException {
        Person jim = new Person(29, "Jimmmy");
        Person katy = new Person(12, "Kate");
        ArrayList<Person> people = new ArrayList<>();

        File csvFile = new File("People.csv");
        PrintWriter out = new PrintWriter(csvFile);

        people.add(jim);
        people.add(katy);

        for (Person person : people){
            out.printf(person.toString() + "\n");
        }

        out.close();
    }
}
