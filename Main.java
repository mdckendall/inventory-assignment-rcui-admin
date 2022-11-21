import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  public String itemName, serialNum;
	public int value;
}

class Main {
	public static void main(String[] args) {
    ArrayList<Inventory> inventory = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		boolean inventoryLoop = true;

		do{
			System.out.println("Press 1 to add an item.");
			System.out.println("Press 2 to delete an item.");
			System.out.println("Press 3 to update an item.");
			System.out.println("Press 4 to show all the items.");
			System.out.println("Press 5 to quit the program.");

			int userChoice = input.nextInt();
      input.nextLine();
			switch (userChoice) {
				case 1:
					Inventory itemAdd = new Inventory();
          System.out.println("Enter the name: ");
          itemAdd.itemName = input.nextLine();
          System.out.println("Enter the serial number: ");
          itemAdd.serialNum = input.nextLine();
          System.out.println("Enter the value in dollars (whole number): ");
          itemAdd.value = input.nextInt();
          inventory.add(itemAdd);
					break;
        case 2:
          input.nextLine();
          System.out.println("Enter the serial number of the item to delete: ");
          String removeItemSN = input.nextLine();
          inventory.removeIf(i -> i.serialNum.equals(removeItemSN));
			    break;
        case 3:
          input.nextLine();
          System.out.println("Enter the serial number of the item to change: ");
          String changeItemSN = input.nextLine();
          inventory.forEach(f -> {
                            if(f.serialNum.equals(changeItemSN)) {
                              System.out.println("Enter the new name: ");
                              f.itemName = input.nextLine();
                              System.out.println("Enter the new value in dollars (whole number)");
                              f.value = input.nextInt();
                            }
                              });
          break;
        case 4:
          inventory.forEach(f -> {
            System.out.println(f.itemName + "," + f.serialNum + "," + f.value);
          });
          break;
        case 5:
          inventoryLoop = false;
          break;
			}  
		}while(inventoryLoop);
    input.close();
	}
}