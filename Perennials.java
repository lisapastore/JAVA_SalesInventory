
package lpastorefinal;


public class Perennials extends Plants {
	//one String field flowerColor which is the flower color
	String flowerColor;
	
	// full constructor calling the fields from the parent class
	public Perennials(double c, String i, int iNum, double sP, String flowerColor) {
		super(c, i, iNum, sP);
		this.flowerColor = flowerColor;
	}
	
	// empty constructor
	public Perennials() {
		super();
	}
	
	public String toString() {
		return super.toString() + " Color: " + flowerColor;
	}

	public String getFlowerColor() {
		return flowerColor;
	}

	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

}
