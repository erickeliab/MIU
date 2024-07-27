package application;

import application.Book;


public class Cartitem {
    private int quantity;
    private Book product;
    
    public Cartitem() {
    }
 
    public Cartitem(Book product, int quantity) {
       this.product=product;
       this.quantity=quantity;
    }
   
    public void setProduct(Book product) {
        this.product = product;
    }

    public Book getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Cartitem{" +
                "quantity =" + quantity +
                ", book =" + product +
                '}';
    }
}
