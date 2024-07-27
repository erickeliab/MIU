package with.templatemethod;

public abstract class PaymentProcessor {
	CurrencyConverter currencyConverter = new CurrencyConverter();

	protected void proccessPayment(double amount, String currency) {
		double dollarAmount = currencyConverter.convertToDollars(amount, currency);
		boolean validationResult = validatePayment();
		if (validationResult) {
			performPayment(dollarAmount);
			notifyCustomer();
		}
	}

	protected abstract boolean validatePayment();

	protected abstract void performPayment(double dollarAmount);

	protected abstract void notifyCustomer();

}
