package biblioteca.controller.command;

public enum Printable {
    ALWAYS{
        @Override
        public boolean isPrintable() {
            return true;
        }
    },
    IFLOGGEDIN{
        @Override
        public boolean isPrintable() {
            return false;
        }
    };
    abstract public boolean isPrintable();
}
