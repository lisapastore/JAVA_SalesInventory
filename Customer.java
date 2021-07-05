
package lpastorefinal;

import java.util.ArrayList;


//this class is done for you except the compareTo() method

public class Customer implements Comparable<Customer> {
	
	
	private int custNum;	
	private int discountPercent;	
	private String first;	
	private String last;	
	private String type;
	
	public static int nextNum = 100;
	
	
	public Customer()
	{
		custNum = nextNum;
		nextNum++;
	}
	
	
	public Customer(String l, String f, String t, int percent)
	{
		last = l;
		first = f;
		type = t;
		discountPercent = percent;
		custNum = nextNum;
		nextNum++;
	}
	
	
	public String toString()
	{
		double discountDecimal = discountPercent / 100.00;
		
		return first + " " + last + " (#" + custNum + "/" + type + ") Discount:"  + discountDecimal + "."; 
	}
	
	public static void custSort(ArrayList<Customer> c)
	   {
		// outer loop (backward)
		for (int out=c.size()-1;out>1;out--)
	        // inner loop (forward)
			for (int in=0;in<out;in++)
			{
				Customer first = c.get(in);
				Customer second = c.get(in+1);
				String name1 = first.getLast()+first.getFirst();
				String name2=second.getLast()+second.getFirst();
				if (name2.compareTo(name1) < 0)   // out of ascending order?
				{
					c.set(in,second); // if yes, then swap them
				    c.set(in+1,first);
				}
			} // end inner loop
	      
	   } // end outer loop
	

	public int compareTo(Customer cust){
		/// this method compares the customer's name between
		// successive customer entries in the Array/ArrayList
	
		// start outer loop to check the LAST name
		if (cust.getLast().compareTo(this.getLast()) >0)
		//if (inv.getItemName().equalsIgnoreCase(this.getItemName()) == true )
				return 1;
		else if (cust.getLast().compareTo(this.getLast()) <0)
		//	else if (inv.getItemName().startsWith(this.getItemName()) == true )
				return -1;
		
		// ** need to add code below to check the customer FIRST names if the LAST names are identical
		else if (cust.getLast().compareTo(this.getLast()) == 0) 
		
		{		// run this inner loop if the last names are identical
				if 	(cust.getFirst().compareTo(this.getFirst()) == 0) 
					return 0;
				else if (cust.getFirst().compareTo(this.getFirst()) >0)
					return 1;
				else if (cust.getFirst().compareTo(this.getFirst()) <0)
					return -1;
			}	
		return 0; // end outer loop
	}
	
	public int getCustNum() {
		return custNum;
	}

	
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

	
	public int getDiscountPercent() {
		return discountPercent;
	}

	
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public boolean equalsLastName(Customer c, String name)
    {
         if (c.getLast().equals(name) == true)
             return true;
         else
             return false;
     }
	
	public String getFirst() {
		return first;
	}

	
	public void setFirst(String first) {
		this.first = first;
	}

	
	public String getLast() {
		return last;
	}

	
	public void setLast(String last) {
		this.last = last;
	}

	
	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}
	
}
