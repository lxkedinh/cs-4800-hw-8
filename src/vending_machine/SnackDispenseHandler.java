package vending_machine;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public void handleDispenseSnack(String snackName) {
        if (next != null) {
            next.handleDispenseSnack(snackName);
        }
    }
}
