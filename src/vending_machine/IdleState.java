package vending_machine;

public class IdleState implements StateOfVendingMachine {
    @Override
    public void idle(VendingMachine machine) {
        machine.selectSnack();
        machine.waitForMoney();
    }

    @Override
    public void waitForMoney(VendingMachine machine) {
        machine.setState(new WaitForMoneyState());
        machine.insertMoney();
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        machine.setState(new DispenseSnackState());
    }
}
