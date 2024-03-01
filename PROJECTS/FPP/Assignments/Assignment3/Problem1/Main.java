
public class Main {
    public static void main(String[] args) {


        Customer c1 = new Customer("Erick","Benedict","123K");
        c1.setBillingAddress("NorthSt","Fairfield","Iowa","3456");
        c1.setShippingAddress("South","Cedar Rapids","Iowa","3458");

        Customer c2 = new Customer("Jesca","Emmanuel","723F");
        c2.setBillingAddress("South Side","Chicago","Illinois","2433");
        c2.setShippingAddress("HoverSt","Chicago","Illinois","2438");


        Customer c3 = new Customer("Cara","Johnson","925Y");
        c3.setBillingAddress("Kings","Chicago","Illinois","2403");
        c3.setShippingAddress("Bervely","Chicago","Illinois","9438");


        Customer[] customers = {c1,c2,c3};

        for (Customer customer: customers) {

            if (customer.getBillingAddress().getCity().equals("Chicago")) {
                System.out.println(customer.toString());
            }
        }

        }
    }