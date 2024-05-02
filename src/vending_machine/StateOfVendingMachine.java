package vending_machine;

public interface StateOfVendingMachine {
    void idle(VendingMachine machine);
    void waitForMoney(VendingMachine machine);
    void dispenseSnack(VendingMachine machine);
}
