
package lpastorefinal;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;



public class MenuInfo {
	Scanner scan = new Scanner(System.in); // will need this later to collect data
	

	public void loadData(ArrayList<Customer> cust, ArrayList<Sales> sales, ArrayList<Inventory> inv) {
		// Some customer data
		cust.add(new Customer("Wolff", "Diane", "Retail", 0));
		cust.add(new Customer("Mouse", "Mickey", "Retail", 0));
		cust.add(new Customer("Duck", "Donald", "Wholesale", 15));
		cust.add(new Customer("Miller", "Mike", "Wholesale", 10));

		// Some inventory data
		inv.add(new BulkProducts(0.10, "Soil", 50000, 0.25, 100000));
		inv.add(new BulkProducts(0.30, "Mulch", 5000, 0.60, 10000));
		inv.add(new Perennials(1.75, "Lilies", 75, 4.99, "white"));
		inv.add(new Perennials(5.99, "KnockOut Rose", 500, 10.99, "purple"));
		inv.add(new Perennials(12.99, "KnockOut Rose", 500, 19.99, "yellow"));
		inv.add(new Trees(16.00, "Eastern White Pine", 300, 29.50, true));
		inv.add(new Trees(35.00, "Sugar Maple", 90, 65.00, false));
		inv.add(new Trees(120.00, "Japanese Maple", 25, 165.00, false));
		inv.add(new Trees(82.00, "Norway Maple", 12, 165.00, false));
		inv.add(new Trees(20.00, "Virginia Pine", 30, 45.00, true));

		// Some sales data
		sales.add(new Sales(cust.get(1), LocalDate.of(2020, 3, 25), inv.get(3), 40));
		sales.add(new Sales(cust.get(0), LocalDate.now(), inv.get(5), 25));
		sales.add(new Sales(cust.get(1), LocalDate.of(2020, 1, 27), inv.get(5), 20));
		sales.add(new Sales(cust.get(2), LocalDate.of(2020, 4, 24), inv.get(1), 45));

	}

	public void printTotals(ArrayList<Sales> s) {
		Collections.sort(s); // sort by date of the sale, this method is in Sales.java
		// print out all of the sales information
		for (Sales sales : s)
			System.out.println(sales.toString());
	}

	public void printInventory(ArrayList<Inventory> iv) {
		// sorting by the inventory name (NOT code) is done by a method in Inventory.java
		// print out all of the inventory information
		for (Inventory inv : iv)
			System.out.println(inv.toString());
	}

	public void printCustomers(ArrayList<Customer> c) {
		// sorting by customer name is done in a separate method below
		// print out all of the customer information
				for (Customer cust : c)
					System.out.println(cust.toString());
	}

	public static void custSort(ArrayList<Customer> c)
	   {
		// outer loop (backward direction)
		for (int out=c.size()-1;out>1;out--)
	        // inner loop (forward direction)
			for (int in=0;in<out;in++)
			{
				Customer first = c.get(in);
				Customer second = c.get(in+1);
				String name1 = first.getLast()+first.getFirst();
				String name2 = second.getLast()+second.getFirst();
				if (name2.compareTo(name1)<1)   // out of order?
				{
					c.set(in,second); // if yes, then swap them
				    c.set(in+1,first);
				}
	
			} // end inner loop
	      
	   } // end outer loop
	
	public void addCustomer(ArrayList<Customer> cust) {
		// first ask the user to input each data item
		System.out.println("What is the last name of the new customer?");
		String nameLast = scan.nextLine();
		
		System.out.println("What is the first name of the new customer?");
		String nameFirst = scan.nextLine();
							
		System.out.println("Is this person a Wholesale or Retail customer?");
		String type = scan.nextLine();
		// data validation check
			if ( (type.equalsIgnoreCase("retail") == false) && (type.equalsIgnoreCase("wholesale") == false) )
			{
				System.out.println("Entry error. Re-enter (Wholesale or Retail)");
				type = scan.nextLine();
			}
		
		System.out.println("Enter the customer discount. Enter 5 for a 5% discount. Enter zero for no discount.");
		int disc = scan.nextInt();
		// next line needed for the scanner problem
		scan.nextLine();
		
			// data validation check
			if (disc < 0) {
				System.out.println("Entry error. Re-enter the discount for this customer:");
				disc = scan.nextInt();
			}
		
			// now check to see if this new entry is unique to the database
			boolean repeat = false;
			// outer loop (backward)
			for (int out=cust.size()-1;out>1;out--)
		        // inner loop (forward)
				for (int in=0;in<out;in++)
				{
					Customer first = cust.get(in);
					String name1 = first.getLast()+first.getFirst();
					String name2 = nameLast + nameFirst;
					if ( (name1.compareTo(name2) == 0) &&
					     (name1.compareTo(name2) == 0)  ){
						System.out.println("That customer is already in the database.");
						repeat = true;
					}
					 
				} // end inner loop
		
		// now add this new customer to the ArrayList
			// create an instance calling the full constructor
			Customer newCust = new Customer(nameLast, nameFirst, type, disc);
						
			//add the customer instance to the ArrayList if it is not already there
			if (repeat == false)
				cust.add(newCust);
	
	}

// *** I'm not sure I've ever used this method below ***********
	public boolean equalsLastName(Customer c, String name)
    {
         if (c.getLast().equals(name) == true)
             return true;
         else
             return false;
     }
	
	public void deleteCustomer(ArrayList<Customer> c) {
		// now remove a customer
		// first ask the user to input each data item
				System.out.println("What is the last name of the customer to be deleted?");
				String nameLast = scan.nextLine();
				
				System.out.println("What is the first name of the customer to be deleted?");
				String nameFirst = scan.nextLine();
		
				boolean match = false; // need to set up this placeholder to know if customer not found
		// loop through to match the person to delete with the customer in the database
		for (int q=0; q < c.size(); q++) {
			Customer first = c.get(q);
			String name1 = first.getLast()+first.getFirst();
			String name2 = nameLast + nameFirst;
			if ( (name1.compareTo(name2) == 0) &&
			     (name1.compareTo(name2) == 0)  ) {
					  System.out.println(c.get(q).toString());
			     	  c.remove(q);
			     	  match = true;
			}
	      }
		if (match == false)
			System.out.println("That customer does not exist in the current database.");
	}

	
	public void makeSale(ArrayList<Inventory> inv, ArrayList<Sales> sales, ArrayList<Customer> cust) {
		System.out.println("Choose a customer number for this sale:");
		int cCode = scan.nextInt();
		
	
		// now i need to get the index of the customer who is ordering, will need this later in this method
		int cIndex = -99;
		for (int j = 0; j < cust.size(); j++) {  
			Customer cInstance = cust.get(j); // make a Customer instance as we loop through all customers
		
			if ( cCode == cInstance.getCustNum() ) // does the entered code match a customer?
				cIndex = j;
		}
		
		// need to verify the customer # exists in the database 
		if (cIndex == -99) { // this is only true if the cIndex value remains as initially set before checking the cust # 
			System.out.println("That customer is not in the database. Please choose another menu option.");
			return;
		}
		
		System.out.println("\nThe following nursery items are available to purchase:");
		for (int p = 0; p < inv.size(); p++) {   
			System.out.print((p + 1) + ".  ");
			System.out.println(inv.get(p).toString());
		}
		
		System.out.println("\nWhich item is being purchased? " +
					"Please enter the number from the list (starting with 1...).");
			int iCode = scan.nextInt();
				// data validation check
				if ( (iCode <= 0) || (iCode > inv.size()) ) { 
						System.out.println("Entry error. Please re-enter the item number:");
						iCode = scan.nextInt();
				}
				if ( (iCode <= 0) || (iCode > inv.size()) ) { 
					System.out.println("Entry error. Please choose from the menu again:");
					return; // end this method if there is another entry error
				}
				// now transform that iCode into the index by subtracting 1
				iCode = iCode - 1;
				
		System.out.println("What quantity of this item is being purchased?");
				int purchCount = scan.nextInt();
					// data validation check
					if (purchCount <= 0) {
							System.out.println("Entry error. Please re-enter the quantity:");
							purchCount = scan.nextInt();
					}
					if (purchCount <= 0) {
						System.out.println("Entry error. Please choose from the menu again:");
						return; // end this method if there is another entry error
				}
					// now check to make sure there is sufficient inventory for this purchase
				 if (purchCount > inv.get(iCode).getNumInStock() ) {
						System.out.println("Not enough in stock to complete that sale");
						System.out.println("Please redo the sale request");
						// end this method right here if the above is true
						return;
				 }
					// now remove the item quantity from the inventory that was just purchased
					// so subtract from the "numInStock" the "purchCount"
				 else if (purchCount <= inv.get(iCode).getNumInStock() ) {
						Inventory inven = inv.get(iCode);
						int newAmnt = inv.get(iCode).getNumInStock() - purchCount;
						inven.setNumInStock(newAmnt);
				 }
				 
				 // now collect the date of the sale
				 System.out.println("\nEnter the year of the purchase (4 digits):");
					int yy = scan.nextInt();
				System.out.println("\nEnter the month of the purchase (digits):");
					int mm = scan.nextInt();
					if ( (mm <= 0) || (mm > 12) ) {
						System.out.println("Entry error. Please re-enter the month:");
						mm = scan.nextInt();
				}
				System.out.println("\nEnter the day of the purchase (digits):");
					int dd = scan.nextInt();
					if ( (dd <= 0) || (dd>31) ) {
						System.out.println("Entry error. Please re-enter the day:");
						dd = scan.nextInt();
				}
				 LocalDate ld = LocalDate.of( yy , mm , dd );
				 
				 // now add the purchase to the Sales ArrayList 
				 Sales s1 = new Sales(cust.get(cIndex), ld, inv.get(iCode), purchCount);
				 sales.add(s1);
				 
				//  print out the purchase	
				System.out.println("Purchase details: \n" + sales.get(sales.size()-1).toString());
				
	}

	public void modifyInventory(ArrayList<Inventory> inv) {
		Scanner scan = new Scanner(System.in);
		int choice;

		System.out.println("Choose one");
		System.out.println("1. Add new inventory type");
		System.out.println("2. Edit existing inventory");
		System.out.print("Choice: ");
		choice = scan.nextInt();
		if (choice == 1) {
			// next line needed for the scanner problem
				scan.nextLine();
			addInventory(inv);
		} else if (choice == 2) {
			editInventory(inv);
		} else
			System.out.println("Not a valid entry");

	}

	public void sumInventory(ArrayList<Inventory> inv) {
		double sum = 0; // will need to loop through the array to calc/add the cost of all the inventory items
		 for(int i = 0; i < inv.size(); i++)  {    
			 sum = sum + (inv.get(i).getCost() * inv.get(i).getNumInStock() );
		 }
		 NumberFormat nf = NumberFormat.getCurrencyInstance();
		 System.out.println("\n The total value (investment by the Nursery) of the entire inventory is " 
		 	+ nf.format(sum) + "\n");
	}
	
	public void sumSales(ArrayList<Sales> s, ArrayList<Inventory> inv) {
		double sumCost = 0; // will need to loop through the array to calc/add the cost of all the sales
		double sumTotalSales = 0; // accumulator for the total sales to the customers

		for(int i = 0; i < s.size(); i++)  {    
			 sumCost = sumCost + (s.get(i).getInv().getCost() * s.get(i).getNumBought() );
			 sumTotalSales = sumTotalSales + (s.get(i).getInv().getSalesPrice() * s.get(i).getNumBought() );
		 }
		double sumGrossProfit = sumTotalSales - sumCost ;
		 NumberFormat nf = NumberFormat.getCurrencyInstance();
		 System.out.println("\n  The total for all sales is: " + nf.format(sumTotalSales) + "\r\n" +
		 		"  Total profits for all sales: " + nf.format(sumGrossProfit) + "\n");
	}
	

	
	private void addInventory(ArrayList<Inventory> invCurr) {
		// next line needed for the scanner problem
			scan.nextLine();
		// first ask the user to input each data item
			System.out.println("What is the name of the new inventory item?");
			String item = scan.nextLine();
				
			System.out.println("What is the cost to the Nursery for this item?");
			double cost = scan.nextDouble();
									
			System.out.println("What is the sales price of this item to the consumer?");
			double p = scan.nextDouble();
					
			System.out.println("Enter the quantity of this new item.");
			int nIS = scan.nextInt();
			// next line needed for the scanner problem
			scan.nextLine();
				
		// now we need to know what type of inventory item this is
			System.out.println("What type of item is this? Enter 1 if this is a tree, " 
					+ "Enter 2 if this is a perennial plant, Enter 3 if this is a bulk product.");
			int classific = scan.nextInt();
				// data validation check
				if ( (classific < 1) || (classific >3) ) {
					System.out.println("Entry error. Please re-enter the type of item this is:");
					classific = scan.nextInt();
				}
					// next line needed for the scanner problem
					scan.nextLine();
					
			if (classific == 1) { // collect extra info needed for this inventory item
				System.out.println("Is this an evergreen tree? (enter true or false)");
				boolean evergreen = scan.nextBoolean();
				// now add the new item to the Inventory ArrayList using the Trees constructor
				Inventory invNew = new Trees( cost,  item,  nIS,  p, evergreen);
				invCurr.add(invNew);
			}
			if (classific == 2) { // collect extra info needed for this inventory item
				System.out.println("What is the color of this perennial?");
				String color = scan.nextLine();
				// now add the new item to the Inventory ArrayList using the Perennials constructor
				Inventory invNew = new Perennials( cost,  item,  nIS,  p, color);
				invCurr.add(invNew);
			}
			if (classific == 3) { // collect extra info needed for this inventory item
				System.out.println("What is the weight of this product? (no decimal places)");
				int wght = scan.nextInt();
				// data validation check
				if (wght < 0) {
					System.out.println("Entry error. Re-enter the weight:");
					wght = scan.nextInt();
				}
				// now add the new item to the Inventory ArrayList using the BulkProducts constructor
				Inventory invNew = new BulkProducts( cost,  item,  nIS,  p, wght);
				invCurr.add(invNew);
			}
				
	}

	private void editInventory(ArrayList<Inventory> inv) {
		System.out.println("\nThe following nursery items are available to edit:");
		for (int p = 0; p < inv.size(); p++) {   
			System.out.print((p + 1) + ".  ");
			System.out.println(inv.get(p).toString());
		}
		
		System.out.println("\nWhich item listing is being altered? " +
					"Please enter the number from the list (starting with 1...).");
			int iCode = scan.nextInt();
				// data validation check
				if ( (iCode <= 0) || (iCode > inv.size()) ) { 
						System.out.println("Entry error. Please re-enter the item number:");
						iCode = scan.nextInt();
				}
				if ( (iCode <= 0) || (iCode > inv.size()) ) { 
					System.out.println("Entry error.");
					return; // end this method if there is another entry error
				}
				// now transform that iCode into the index by subtracting 1
				iCode = iCode - 1;

		// now we need to find out if the user wants to change the sales price or the amount in the inventory
			System.out.println("Choose one");
			System.out.println("1. Change the customer's price for this item");
			System.out.println("2. Increase the quantity of the existing inventory");
			System.out.print("Choice: ");
			int choice = scan.nextInt();
			if (choice == 1) {
				int index = iCode + 1;
				editPrices(inv, iCode);
			} else if (choice == 2) {
				int index = iCode + 1;
				addStock(inv, iCode);
			} else
				System.out.println("Not a valid entry");
	
	}

	private void addStock(ArrayList<Inventory> inv, int invIndex) {
//		System.out.println("Here is the index of the product: " + invIndex);
//		System.out.println("Here is the product: " + inv.get(invIndex));
		System.out.println("What quantity of this item is being added?");
		int add = scan.nextInt();
			// data validation check
			if (add <= 0) {
					System.out.println("Entry error. Please re-enter the quantity:");
					add = scan.nextInt();
			}
			Inventory inven = inv.get(invIndex); // make the inventory instance
			int newAmnt = inv.get(invIndex).getNumInStock() + add; // add the quantity
			inven.setNumInStock(newAmnt); // modify the inventory instance
			
	}

	private void editPrices(ArrayList<Inventory> inv, int invIndex) {
		System.out.println("What is the new sales price of this item?");
		double newPrice = scan.nextDouble();
			// data validation check
			if (newPrice <= 0) {
					System.out.println("Entry error. Please re-enter the price:");
					newPrice = scan.nextDouble();
			}
			
			Inventory inven = inv.get(invIndex); // make the inventory instance
//			double newAmnt = inv.get(invIndex).getSalesPrice() + newPrice; // add the quantity
//			inven.setNumInStock(newAmnt); // modify the inventory instance
			inven.setSalesPrice(newPrice); // modify the inventory instance
	}

	public void searchByName(ArrayList<Inventory> inv) {
		// next line needed for the scanner problem
		scan.nextLine();
		
		System.out.println("\nWhich item are you looking for? " +
				"Enter a word or words to search in the inventory:");
		String lookFor = scan.nextLine();
		// put this in lower case for the matching process
		lookFor = lookFor.toLowerCase();
		boolean match = false;
		
		// now we need to find out if there is any of that inventory in stock
		for (int q = 0; q < inv.size(); q++) {  
			Inventory invInstance = inv.get(q);
			
			// match the case of both items to compare
			String itemLowerCase = invInstance.getItemName().toLowerCase();
			if ( itemLowerCase.indexOf(lookFor) >= 0 ) {
				System.out.println("\nYes, that item is in stock. Here are the details.");
				System.out.println(inv.get(q).toString());
				match = true;
			}
			else if ( (invInstance.getItemName().indexOf(lookFor) < 0 ) &&
				(match = false) && ( (q-1) == inv.size()) )
				System.out.println("We don't have any of that item currently. " +
						"Check back another day!");
		}
	}

}