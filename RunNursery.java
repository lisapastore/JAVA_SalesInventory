package lpastorefinal;
//this class is done for you - you do not need to change anything


import java.util.*;

public class RunNursery {

	public static void main(String[] args) {

		// Setup the array lists for customer, sales, and inventory
		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<Sales> sales = new ArrayList<Sales>();
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
		MenuInfo mi = new MenuInfo();

		int choice = 0;

		// Continuing looping through the menu until the user exits
		while (choice != 10) {
			// Show the menu
			choice = showMenu();
			// data entry check....
			if ( (choice < 0) || (choice > 9) ) {
				System.out.println("Entry error.");
				choice = showMenu();
			}
			if (choice == 0) {
				mi.loadData(cust, sales, inv);
				System.out.println("Done!");
			}
			else if (choice == 1) {
				mi.printTotals(sales);
				mi.sumSales(sales, inv);
			}
			else if (choice == 2) {
				Inventory.invSort(inv);
				mi.printInventory(inv);
				mi.sumInventory(inv);
			}
			else if (choice == 3) {
				Customer.custSort(cust);
				mi.printCustomers(cust);
			}
			else if (choice == 4) {
				mi.addCustomer(cust);
				Customer.custSort(cust);
				System.out.println("\n Here is the current list of customers: \n");
				mi.printCustomers(cust);
			}
			else if (choice == 5) {
				mi.deleteCustomer(cust);
				System.out.println("\n Here is the current list of customers: \n");
				mi.printCustomers(cust);
			}
			else if (choice == 6)
				mi.searchByName(inv);
			else if (choice == 7) {
				System.out.println("Here are the current customers:");
				Customer.custSort(cust);
				mi.printCustomers(cust);
				mi.makeSale(inv, sales, cust);
				Inventory.invSort(inv);
			}
			else if (choice == 8) {
				mi.modifyInventory(inv);
				Inventory.invSort(inv);
			}
			else if (choice == 9) {
				System.out.println("Thanks for using my program!");
				System.exit(0);
			}
		}
	}

	public static int showMenu() {
		Scanner scan = new Scanner(System.in);
		int choice = -7;

		System.out.println("\n\nPlease choose from one of the following options:");

		System.out.println("    (0 to load all of the raw data)");
		// DONE FOR YOU but you need to fix the net sales cost

		System.out.println("1.  Print all sales sorted by dates and the total value");
		// each sales should have a sub-total (the one you fixed above)
		// and then
		// an overall total for all of the sales

		System.out.println("2.  Print all inventory items sorted by name and their total values");
		// should be sorted alphabetically by the inventory name

		System.out.println("3.  List all current customers sorted by name");
		// alphabetically by last and then first name
		
		System.out.println("4.  Add a customer");
		// make certain that they are unique. No duplicate first plus
		// last names

		System.out.println("5.  Delete a customer");
		// Indicate if they do not exist
		
		System.out.println("6.  Search for item by name or part name");
		// if I put in "maple", it should find all of the maples

		System.out.println("7.  Make a sale");
		// make certain to deduct the amount from inventory.
		// Make certain that there is enough in the inventory for the
		// sales
		// Make certain to add the sales to the sales list

		System.out.println("8.  Add or edit Inventory");
		// should be able to add to a current inventory item or add a
		// new item
		// should be able to edit only the two prices
		// a sub-menu would work well here.

		
		System.out.println("9. Exit");
		// should write out the files and close

		choice = scan.nextInt();

		return choice;

	}

}
