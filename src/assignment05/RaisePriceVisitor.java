package assignment05;

public class RaisePriceVisitor implements Visitor {
	private double amount;
	public RaisePriceVisitor(double amount) {
		super();
		this.amount = amount;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MenuPart part) {
		// TODO Auto-generated method stub
		double price = part.getPrice();
		price += price*amount/100;
		price = (Math.round(100*price))/100.0;
		part.setPrice(price);
	}

	@Override
	public void visit(MenuAbstraction abstraction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Menu menu) {
		// TODO Auto-generated method stub
		
	}
	

}
