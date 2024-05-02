package vending_machine;

public class CokeDispenseHandler extends SnackDispenseHandler {
    public CokeDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    @Override
    public void handleDispenseSnack(String snackName) {
        if (snackName.toLowerCase().equals("coke")) {
            VendingMachine.getInstance().dispenseSnack();
        }
    }
}
