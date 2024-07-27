package with.templatemethod;

public class VisaPaymentProcessor extends PaymentProcessor{
	private VisaCard visaCard;
	private Customer customer;
	
	public VisaPaymentProcessor(VisaCard visaCard, Customer customer) {
		super();
		this.visaCard = visaCard;
		this.customer = customer;
	}

	@Override
	protected boolean validatePayment() {
		// logic to validate visa card
		System.out.println("Validate visa card with card number "+visaCard.getCreditCardNumber());
		return true;
	}

	@Override
	protected void performPayment(double dollarAmount) {
		// logic to perform payment visa card
		System.out.println("Perform payment with visa card with card number "+visaCard.getCreditCardNumber()+" and amount $"+dollarAmount);		
	}

	@Override
	protected void notifyCustomer() {
		// logic to notify customer
		System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about visa credit card payment with card number "+visaCard.getCreditCardNumber());		
	}

}
