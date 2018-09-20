package biblioteca.view;

import java.util.Scanner;

public class InputDriver {
    public int getMenuChoice(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
