package biblioteca.view;

import java.util.List;

//class to drive the
public class OutputDriver {
    public void print(Object o) {
        System.out.println(o);
    }

    public void print(List<String> stringList) {
        stringList.forEach(string->System.out.format("%-50s",string));
        System.out.println();
    }

    public void printAsColumns(List<List<String>> listOfStrings) {
        listOfStrings.forEach(this::print);
    }

    public void printHorizontalLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
