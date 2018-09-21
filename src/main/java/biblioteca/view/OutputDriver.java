package biblioteca.view;

import java.util.List;

//class to drive the
public class OutputDriver {
    public void print(Object o) {
        System.out.println(o);
    }

    public void print(List<String> stringList) {
        System.out.format("%-50s %-50s %-50s\n",stringList.get(0),stringList.get(1),stringList.get(2));
    }

    public void printAsColumns(List<List<String>> listOfStrings) {
        listOfStrings.forEach(this::print);
    }
}
