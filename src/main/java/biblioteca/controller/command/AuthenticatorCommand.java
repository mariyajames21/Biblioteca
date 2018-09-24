package biblioteca.controller.command;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class AuthenticatorCommand implements Command {

    private Command command;

    public AuthenticatorCommand(Command command) {
        this.command = command;
    }



    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        if (!library.isLoggedIn()) {
            if (login(library, outputDriver, inputDriver)) {
                return;
            }
        }
        this.command.perform(library, inputDriver, outputDriver);
    }

    private boolean login(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("You are not logged in. Please log in");
        outputDriver.print("Enter you usernumber");
        String userNumber = inputDriver.readString();
        outputDriver.print("Enter Password");
        String password = inputDriver.readString();
        User user = new User(userNumber, password);
        if(!library.login(user)){
            outputDriver.print("Incorrect usernumber or password");
        }
        return false;
    }


}
