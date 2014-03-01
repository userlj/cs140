package assignment05;

public abstract class MenuAbstraction {  
	public abstract void accept(Visitor visitor);
	private String name;
	private String description;
	public MenuAbstraction(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
    public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

	public boolean add(MenuAbstraction menuAbstraction) {
        throw new UnsupportedOperationException();
    }
    public boolean remove(Object menuAbstraction) {
        throw new UnsupportedOperationException();
    }
    public MenuAbstraction get(int i) {
        throw new UnsupportedOperationException();
    }
 

    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
  
    public void print() {
        throw new UnsupportedOperationException();
    }
}