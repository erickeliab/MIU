package camera;

public class CarOwner {
	private String name;
	private double unpaidTicketsBalance;

	public CarOwner(String name, double unpaidTicketsBalance) {
		super();
		this.name = name;
		this.unpaidTicketsBalance = unpaidTicketsBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnpaidTicketsBalance() {
		return unpaidTicketsBalance;
	}

	public void setUnpaidTicketsBalance(double unpaidTicketsBalance) {
		this.unpaidTicketsBalance = unpaidTicketsBalance;
	}

	@Override
	public String toString() {
		return "CarOwner name=" + name + ", unpaidTicketsBalance=" + unpaidTicketsBalance;
	}

}
