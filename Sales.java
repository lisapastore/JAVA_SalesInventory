
package lpastorefinal;

// this class is done for you except the compareTo() code
import java.text.NumberFormat;
import java.time.LocalDate;


public class Sales implements Comparable<Sales> {
	
	private Customer cust;
	private LocalDate dateSold;
	private Inventory inv;
	private int numBought;
	private int salesNum;

	private static int nextNum = 1000; // used to set the inventory code
	
	
	public Sales() // empty constructor
	{
		salesNum = nextNum;
		nextNum++;
		
	}
	
	// full constructor drawing from 2 other classes
	public Sales(Customer c, LocalDate date, Inventory in, int num)
	{
		cust = c;
		dateSold = date;
		inv = in;
		numBought = num;
		salesNum = nextNum;
		nextNum++;
	}
	
	
	public String toString() // to print out the information
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String s = "Sales #: " + salesNum +"  " + inv.toStringCust() + "  " + cust.toString() + " bought " + 
		numBought +" on " +dateSold + ". \n   Total Purchase Cost to Customer: " + nf.format(netCost()) ;
		return s;
	}

	// method to calculate the cost less any discount to the customer
	public double netCost() {
		double saleAmount = numBought * inv.salesPrice * (1 - cust.getDiscountPercent() / 100.0);
		String rw = "retail";
		String rw2 = "Retail";
		if ( ((cust.getType().equals(rw) == true ) || (cust.getType().equals(rw2) == true ))
				&& 
			(saleAmount > 200)  )
			saleAmount = saleAmount * .95; // 5% discount for purchases over $200 to retail customers
//		return numBought * inv.salesPrice * (1 - cust.getDiscountPercent() / 100.0);
		return saleAmount;
	}
	
	public int compareTo(Sales s) {
	
		/// this method compares the dates of the sales between
		// successive sale records in the Array/ArrayList
		if (s.getDateSold().compareTo(this.getDateSold()) >0 )
				return 1;
		
		else if (s.getDateSold().compareTo(this.getDateSold()) <0 )
				return -1;
			else
				return 0;
		
	}
	
	// getters and setters
	public Customer getCust() {
		return cust;
	}

	
	public void setCust(Customer cust) {
		this.cust = cust;
	}

	
	public LocalDate getDateSold() {
		return dateSold;
	}

	
	public void setDateSold(LocalDate dateSold) {
		this.dateSold = dateSold;
	}

	public Inventory getInv() {
		return inv;
	}

	
	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	
	public int getNumBought() {
		return numBought;
	}

	
	public void setNumBought(int numBought) {
		this.numBought = numBought;
	}

}
