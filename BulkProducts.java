
package lpastorefinal;


public class BulkProducts extends Inventory {
	
	//Add a field of weight that is an integer
	int weight;
	
	// full constructor calling the fields from the parent class
	public BulkProducts(double c, String i, int nI, double sP, int weight) {
		super(c, i, nI, sP);
		this.weight = weight;
	}
		
	// empty constructor
	public BulkProducts() {
		super();
	}

	
	public String toString ()
	{   //  print out the toString method from my super (ie the Inventory class)
		String ans = super.toString();	
		return ans + " The weight of this item is: " + weight + ".";  // add on the info for this class
	}
	
	
	//getters and setters
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	// no toString needed - we do not use this weight in our printout
}
