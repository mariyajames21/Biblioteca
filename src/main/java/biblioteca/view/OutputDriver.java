package biblioteca.view;

import java.util.List;

//class to drive the
public class OutputDriver {
    public void print(Object o) {
        System.out.println(o);
    }

    public void print(List<String> stringList) {

        for (String string : stringList) {
            System.out.println(string);
        }
    }

    public void printMenu() {
        System.out.println("Menu");
        System.out.println("1.List of Books");
    }
}
