
package lpastorefinal;


public class Trees extends Plants  {
	//one boolean field evergreen (indicates if it an evergreen or not)
	private boolean evergreen;

	// full constructor calling the fields from the parent class
	public Trees(double c, String i, int nI, double sP, boolean evergreen) {
		super(c, i, nI, sP);
		this.evergreen = evergreen;
	}
	
	// empty constructor
	public Trees() {
		super();
	}

	
	public String toString ()
	{   //  print out the toString method from my super (ie the Inventory class)
		String ans = super.toString();	
		if (evergreen = true)
			return ans + " This tree is an evergreen.";
		else 
			return ans + " This tree is NOT an evergreen.";  // add on the info for this class
	}

	public boolean isEvergreen() {
		return evergreen;
	}

	public void setEvergreen(boolean evergreen) {
		this.evergreen = evergreen;
	}

	//no toString needed	
}
