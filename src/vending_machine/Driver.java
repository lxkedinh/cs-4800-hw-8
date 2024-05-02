package vending_machine;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendor = VendingMachine.getInstance();
        vendor.addSnack(new Snack("Coke", 1, 2));
        vendor.addSnack(new Snack("Pepsi", 0.75, 1));
        vendor.addSnack(new Snack("Cheetos", 1.25, 3));
        vendor.addSnack(new Snack("Doritos", 1.25, 2));
        vendor.addSnack(new Snack("KitKat", 1, 4));
        vendor.addSnack(new Snack("Snickers", 1.25, 2));

        vendor.idle();
    }
}
