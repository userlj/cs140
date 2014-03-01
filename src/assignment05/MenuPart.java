package assignment05;

public class MenuPart extends MenuAbstraction {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	private boolean vegetarian;
	double price;
	public MenuPart(String name, String description, boolean vegetarian, double price) {
		super(name, description);
		this.vegetarian = vegetarian;
		this.price = price;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void print() {
		System.out.print("\t" + getName());
		if (isVegetarian())	
			System.out.print("(v)");
		System.out.println(", " + getPrice());
		System.out.println("\t--" + getDescription());
	}
}
