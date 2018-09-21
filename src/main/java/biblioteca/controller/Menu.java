package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {

    EXIT("Exit from application"){
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.print("Quiting...");
        }
    },

    LIST_OF_BOOKS("List of books") {
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.printAsColumns(library.getBooks());
        }
    }    ,
    CHECKOUT_BOOKS("Checkout books")    {
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            inputDriver.readString();
            library.checkOut(inputDriver.readString());
        }
    };

    private String displayString;

    Menu(String displayString) {
        this.displayString = displayString;
    }

    public String display(){
        return this.ordinal()+"."+displayString;
    }

    public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver){}
}
