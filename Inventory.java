
package lpastorefinal;
// This class is almost done for you...you only need to complete the compareTo() method

import java.text.NumberFormat;
import java.util.ArrayList;


public abstract class Inventory implements Comparable<Inventory> {
	
	
	protected double cost;
	protected int invNum;
	protected String itemName;
	protected int numInStock;
	protected double salesPrice;
	
	protected static int nextNum = 1000; // the program will calc the inventory #
	
	private NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// full constructor is below
	public Inventory(double c, String i, int nIS, double p)
	{
		cost = c;
		itemName = i;
		numInStock = nIS;
		salesPrice = p;
		
		invNum = nextNum;
		nextNum++;
	}
	
	// empty constructor is below
	public Inventory()
	{
		invNum = nextNum;
		nextNum++;
	}
	
	public String toString()
	{
		double totalValue = cost * numInStock;
		
		return  numInStock + " of " + itemName + " (#" + invNum 
			+ ") Cost to the Nursery: " + currency.format(cost) + "/item. Sales price to the customer: " + 
		currency.format(salesPrice) + "/item. \n      Our value of this inventory item: "
			+ currency.format(totalValue); 
	}
	
	// *** potentially rename this to be   toStringOneItemInInven   *******
	public String toStringCust() {
		return  itemName + " (#"+ invNum + ") " +
				currency.format(cost) + " is the cost to the nursery for each of these item(s). ";
				 
	}
	
	
	public static void invSort(ArrayList<Inventory> iv)
	   {
		// outer loop (backward)
		for (int out=iv.size()-1;out>1;out--)
	        // inner loop (forward)
			for (int in=0;in<out;in++)
			{
				Inventory first = iv.get(in);
				Inventory second = iv.get(in+1);
				String name1 = first.getItemName();
				String name2 = second.getItemName();
				if (name2.compareTo(name1) < 0)   // out of ascending order?
				{
					iv.set(in,second); // if yes, then swap them
				    iv.set(in+1,first);
				}
			} // end inner loop
	      
	   } // end outer loop
	
	public int compareTo(Inventory inv){
		/// this method compares the inventory item's name between
		// successive items in the Array/ArrayList
	
		if (inv.getItemName().compareTo(this.getItemName()) >0 )
		//if (inv.getItemName().equalsIgnoreCase(this.getItemName()) == true )
				return 1;
		else if (inv.getItemName().compareTo(this.getItemName()) <0 )
		//	else if (inv.getItemName().startsWith(this.getItemName()) == true )
				return -1;
		else
				return 0;
	}
	
	public double getCost() {
		return cost;
	}

	
	public void setCost(double cost) {
		this.cost = cost;
	}

	
	public int getInvNum() {
		return invNum;
	}

	
	public void setInvNum(int invNum) {
		this.invNum = invNum;
	}

	
	public String getItemName() {
		return itemName;
	}

	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	public int getNumInStock() {
		return numInStock;
	}

	
	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	
	public double getSalesPrice() {
		return salesPrice;
	}

	
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

}
