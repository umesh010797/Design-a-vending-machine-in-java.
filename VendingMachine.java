import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Integer> itemPrices;
    private Map<String, Integer> itemStocks;
    private Map<Integer, String> coins;
    private int currentBalance;

    public VendingMachine() {
        // Initialize item prices and stocks
        itemPrices = new HashMap<>();
        itemPrices.put("Coke", 25);
        itemPrices.put("Pepsi", 35);
        itemPrices.put("Soda", 45);

        itemStocks = new HashMap<>();
        itemStocks.put("Coke", 5);
        itemStocks.put("Pepsi", 5);
        itemStocks.put("Soda", 5);

        // Initialize coins
        coins = new HashMap<>();
        coins.put(1, "PENNY");
        coins.put(5, "NICKLE");
        coins.put(10, "DIME");
        coins.put(25, "QUARTER");

        currentBalance = 0;
    }

    public void displayItems() {
        System.out.println("Welcome to Vending Machine");
        System.out.println("-------------------------------------");
        System.out.println("SrNo\tIn_Stock\tItems\t\tPrice");
        System.out.println("-------------------------------------");

        int index = 1;
        for (Map.Entry<String, Integer> entry : itemStocks.entrySet()) {
            String item = entry.getKey();
            int stock = entry.getValue();
            int price = itemPrices.get(item);

            System.out.println(index + "\t" + stock + "\t\t" + item + "\t\t" + price);
            index++;
        }

        System.out.println("-------------------------------------");
    }

    public void selectItem(int itemNumber) {
        String selectedItem = null;
        int itemPrice = 0;

        int index = 1;
        for (Map.Entry<String, Integer> entry : itemStocks.entrySet()) {
            if (index == itemNumber) {
                selectedItem = entry.getKey();
                itemPrice = itemPrices.get(selectedItem);
                break;
            }
            index++;
        }

        if (selectedItem != null) {
            System.out.println("Price: " + itemPrice);

            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------------------");
            System.out.println("SrNo\tCoin\t\tValue");
            System.out.println("-------------------------------------");
            index = 1;
            for (Map.Entry<Integer, String> entry : coins.entrySet()) {
                int coinValue = entry.getKey();
                String coinName = entry.getValue();
                System.out.println(index + "\t" + coinName + "\t\t" + coinValue);
                index++;
            }
            System.out.println("-------------------------------------");

            System.out.println("Select coins by SrNo separated by (,):");
            String input = scanner.nextLine();

            int paidAmount = 0;
            String[] coinSelections = input.split(",");
            for (String coinSelection : coinSelections) {
                int coinNumber = Integer.parseInt(coinSelection.trim());
                if (coinNumber >= 1 && coinNumber <= coins.size()) {
                    int coinValue = (int) coins.keySet().toArray()[coinNumber - 1];
                    paidAmount += coinValue;
                }
            }

            if (paidAmount >= itemPrice) {
                int change = paidAmount - itemPrice;
                if (change > 0) {
                    System.out.println("Change:");
                    calculateChange(change);
                }
                System.out.println("Collect your Item, Thank you!!!");
                itemStocks.put(selectedItem, itemStocks.get(selectedItem) - 1);
            } else {
                int remaining = itemPrice - paidAmount;
                System.out.println("Price not fully paid, remaining: " + remaining);
            }
        }
    }

    private void calculateChange(int amount) {
        Map<Integer, Integer> coinCounts = new HashMap<>();
        for (int coinValue : coins.keySet()) {
            int count = amount / coinValue;
            if (count > 0) {
                coinCounts.put(coinValue, count);
                amount %= coinValue;
            }
        }

        for (Map.Entry<Integer, Integer> entry : coinCounts.entrySet()) {
            int coinValue = entry.getKey();
            int count = entry.getValue();
            String coinName = coins.get(coinValue);
            System.out.println(coinName + " - " + coinValue * count);
        }
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            vendingMachine.displayItems();
            System.out.println("Select Item by SrNo:");
            int itemNumber = Integer.parseInt(scanner.nextLine());

            vendingMachine.selectItem(itemNumber);

            System.out.println("Enter 'exit' or Press Enter to start again!!!");
            input = scanner.nextLine();
        } while (!input.equalsIgnoreCase("exit"));
    }
}
