package vending_machine;

import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {
    private static VendingMachine machine;
    private StateOfVendingMachine state = new IdleState();
    private HashMap<String, Snack> snacks = new HashMap<>();
    private Snack selectedSnack;
    private double insertedMoney = 0;

    private VendingMachine() {}

    public static VendingMachine getInstance() {
        if (machine == null) {
            machine = new VendingMachine();
        }
        return machine;
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName().toLowerCase(), snack);
    }

    public void selectSnack() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            displaySnacks();
            System.out.println("Please enter the name of the snack to select:");
            String input = scan.nextLine().trim().toLowerCase();

            if (snacks.containsKey(input)) {
                selectedSnack = snacks.get(input);
                System.out.printf("You have selected \"%s\".\n", selectedSnack.getName());
                break;
            }

            System.out.println("You did not enter a valid snack name. Please try again.");
            System.out.println();
        }
    }

    public void removeSnack(String snackName) {
       snacks.remove(snackName);
    }

    public void displaySnacks() {
        for (Snack s : snacks.values()) {
            System.out.printf("- %s\n", s.getName());
        }
    }

    public void insertMoney() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter the amount of money to insert:");
            String input = scan.nextLine().trim().toLowerCase();

            try {
                this.insertedMoney += Double.parseDouble(input);

                if (this.insertedMoney < selectedSnack.getPrice()) {
                    double moneyLeftToInsert = selectedSnack.getPrice() - this.insertedMoney;
                    System.out.printf("You need to insert $%.2f more to afford your selected snack.\n", moneyLeftToInsert);
                    System.out.println("Please insert more money:");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("You did not enter a valid amount of money. Please try again.");
                System.out.println();
            }
        }
    }

    public void idle() {
        state.idle(this);
    }

    public void waitForMoney() {
        state.waitForMoney(this);
    }

    public void dispenseSnack() {
        state.dispenseSnack(this);
    }
}
