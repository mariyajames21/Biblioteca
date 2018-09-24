package biblioteca.controller.command;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.model.UserList;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public class AuthenticatorCommand implements Command {

    private static boolean isLoggedIn;
    private Command command;
    private UserList userList;

    public AuthenticatorCommand(Command command) {
        isLoggedIn = false;
        this.command = command;
        createDummyUsers();
    }

    private void createDummyUsers() {
        userList = new UserList(Arrays.asList(new User("123-4567","qwertyuiop"),
                new User("098-7654","password")));
    }

    @Override
    public void perform(Library library, User user, InputDriver inputDriver, OutputDriver outputDriver) {
        if (!isLoggedIn) {
            if (login(userList, outputDriver, inputDriver)) {
                return;
            }
            isLoggedIn =true;
        }
        this.command.perform(library, user, inputDriver, outputDriver);
    }

    private boolean login(UserList userList, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("You are not logged in. Please log in");
        outputDriver.print("Enter you user name");
        String userNumber = inputDriver.readString();
        outputDriver.print("Enter Password");
        String password = inputDriver.readString();
        User user = new User(userNumber, password);
        if (!userList.containsUser(user)) {
            outputDriver.print("Incorrect usernumber or password");
            return true;
        }
        return false;
    }


}
