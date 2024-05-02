package vending_machine;

public class DispenseSnackState implements StateOfVendingMachine {
    @Override
    public void idle(VendingMachine machine) {
        machine.setState(new IdleState());
    }

    @Override
    public void waitForMoney(VendingMachine machine) {

    }

    @Override
    public void dispenseSnack(VendingMachine machine) {

    }
}
