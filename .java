package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int[] fullingMachine = {400, 540, 120, 9, 550};
        option(fullingMachine);

    }

    public static void information(int[] fullingMachine) {

        System.out.println("The coffee machine has: ");
        System.out.println(fullingMachine[0] +  " ml of water");
        System.out.println(fullingMachine[1] + " ml of milk");
        System.out.println(fullingMachine[2] + " g of coffee beans");
        System.out.println(fullingMachine[3] + " disposable cups");
        System.out.println("$" + fullingMachine[4] + " of money");
        option(fullingMachine);
    }
    public static void option(int[] fullingMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "buy" -> buy(fullingMachine);
            case "fill" -> fill(fullingMachine);
            case "take" -> take(fullingMachine);
            case "remaining" -> information(fullingMachine);
            case "exit" -> exit();
        }

    }
    public static void buy(int[] fullingMachine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> makeEspresso(fullingMachine);
            case "2" -> makeLatte(fullingMachine);
            case "3" -> makeCappuccino(fullingMachine);
            case "back" -> option(fullingMachine);
        }
    }
    public static void fill(int[] fullingMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        fullingMachine[0] = fullingMachine[0] + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        fullingMachine[1] = fullingMachine[1] + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        fullingMachine[2] = fullingMachine[2] + scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        fullingMachine[3] = fullingMachine[3] + scanner.nextInt();
        option(fullingMachine);
    }
    public static void take(int[] fullingMachine) {

        System.out.println("I gave you $" + fullingMachine[4]);
        fullingMachine[4] = 0;
        option(fullingMachine);
    }
    public static void makeEspresso(int[] fullingMachine) {
        int water = 250;
        int milk = 0;
        int coffee = 16;
        int cups = 1;
        int cost = 4;
        countPortion(fullingMachine, water, milk, coffee, cups, cost);
        option(fullingMachine);
    }
    public static void makeLatte(int[] fullingMachine) {
        int water = 350;
        int milk = 75;
        int coffee = 20;
        int cups = 1;
        int cost = 7;
        countPortion(fullingMachine, water, milk, coffee, cups, cost);
        option(fullingMachine);
    }
    public static void makeCappuccino(int[] fullingMachine) {
        int water = 200;
        int milk = 100;
        int coffee = 12;
        int cups = 1;
        int cost = 6;
        countPortion(fullingMachine, water, milk, coffee, cups, cost);
        option(fullingMachine);
    }
    public static void exit() {
        System.exit(0);
    }
    public static void countPortion(int[] fullingMachine, int water, int milk, int coffee, int cups, int cost) {
        if (fullingMachine[0] - water >= 0) {
            if (fullingMachine[1] - milk >= 0) {
                if (fullingMachine[2] - coffee >= 0) {
                    if (fullingMachine[3] - cups >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        fullingMachine[0] = fullingMachine[0] - water;
                        fullingMachine[1] = fullingMachine[1] - milk;
                        fullingMachine[2] = fullingMachine[2] - coffee;
                        fullingMachine[3] = fullingMachine[3] - cups;
                        fullingMachine[4] = fullingMachine[4] + cost;
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                } else {
                    System.out.println("Sorry, not enough coffee beans!");
                }
            } else {
                System.out.println("Sorry, not enough milk!");
            }
        } else {
            System.out.println("Sorry, not enough water!");
        }
    }
}
