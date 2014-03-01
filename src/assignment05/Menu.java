package assignment05;

import java.util.ArrayList;

public class Menu extends MenuAbstraction {
    public void accept(Visitor visitor) {
        for (MenuAbstraction abs : menuParts) {
            abs.accept(visitor);
        }
    }
	private ArrayList<MenuAbstraction> menuParts = new ArrayList<MenuAbstraction>();
	public Menu(String name, String description) {
		super(name, description);
	}
	
	public MenuAbstraction get(int index) {
		return menuParts.get(index);
	}
	public boolean add(MenuAbstraction e) {
		return menuParts.add(e);
	}
	public boolean remove(Object o) {
		return menuParts.remove(o);
	}
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
		for (MenuAbstraction abs : menuParts) {
			abs.print();
		}
	}
}