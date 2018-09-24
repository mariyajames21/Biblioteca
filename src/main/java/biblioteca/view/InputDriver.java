package biblioteca.view;

import java.util.Scanner;

public class InputDriver {
    private final Scanner input;

    public InputDriver() {
        this.input =  new Scanner(System.in);
    }

    public int readMenuChoice(){
        return Integer.parseInt(input.nextLine());
    }

    public String readString() {
        return input.nextLine();
    }

}
