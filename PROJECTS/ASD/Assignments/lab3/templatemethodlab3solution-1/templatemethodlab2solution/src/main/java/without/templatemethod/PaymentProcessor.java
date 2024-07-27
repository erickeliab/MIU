package without.templatemethod;

public class PaymentProcessor {

	protected void proccessPayment(double amount, String currency, String paymentType, Customer customer,
			VisaCard visaCard, String paypalAddress) {
		double dollarAmount = amount;

		if (currency.contentEquals("EUR")) { // European Euro
			dollarAmount = amount * 1.1;
			System.out.println("Convert "+amount+" "+currency+" to US dollars");

		}
		if (currency.contentEquals("INR")) { // Indian Rupee
			dollarAmount = amount * 0.014;
			System.out.println("Convert "+amount+" "+currency+" to US dollars");

		}

		if (paymentType.equals("visa")) {
			boolean validation = validateVisaCard(visaCard);
			if (validation) {
				// logic to perform payment visa card
				System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
						+ " and amount $" + dollarAmount);

				// logic to notify customer
				System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
						+ " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
			}
		} else if (paymentType.equals("paypal")) {

			boolean validation = validatePaypal(paypalAddress);
			if (validation) {
				// logic to perform paypal payment
				System.out.println("Perform payment with paypal address "+paypalAddress+" and amount $"+dollarAmount);		

				// logic to notify customer
				System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about paypal payment to address "+paypalAddress);		
			}

		}

	}
	
	private boolean validateVisaCard(VisaCard visaCard) {
		// logic to validate visa card
		System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
        return true;
	}

	private boolean validatePaypal(String paypalAddress) {
		// logic to validate paypal address
		System.out.println("Validate paypal address "+paypalAddress);
		return true;
	}
}
