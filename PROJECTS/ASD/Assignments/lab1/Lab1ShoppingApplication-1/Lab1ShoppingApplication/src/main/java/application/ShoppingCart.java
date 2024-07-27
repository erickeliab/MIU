package application;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ShoppingCart {
    private int cartId;
    private List<Cartitem> cartlist = new LinkedList<Cartitem>();
    private double totalPrice = 0;

    public ShoppingCart(int cartId) {
        this.cartId = cartId;
    }

    public void addToCart(Book product, int quantity) {
        boolean found = false;
        // first check if product is already in the shoppingcart
        Iterator<Cartitem> iter = cartlist.iterator();
        while (iter.hasNext()) {
            Cartitem cartitem = iter.next();
            Book prod = cartitem.getProduct();
            if (prod.getProductNumber() == product.getProductNumber()) {
                cartitem.setQuantity(cartitem.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            cartlist.add(new Cartitem(product, quantity));
        }
        computeTotalPrice();
    }

    public void computeTotalPrice() {
        totalPrice = 0;
        Iterator<Cartitem> iter = cartlist.iterator();
        while (iter.hasNext()) {
            Cartitem cartitem = iter.next();
            totalPrice = totalPrice + (cartitem.getQuantity() * cartitem.getProduct().getPrice());
        }
    }

    public void removeFromCart(int productNumber, int quantity) {
        Iterator<Cartitem> iter = cartlist.iterator();
        while (iter.hasNext()) {
            Cartitem cartitem = iter.next();
            Book product = cartitem.getProduct();
            if (product.getProductNumber() == productNumber) {
                if (cartitem.getQuantity() <= quantity) {
                    iter.remove();
                    computeTotalPrice();
                    break;
                } else {
                    cartitem.setQuantity(cartitem.getQuantity() - quantity);
                }
            }
        }
    }

    public void changeQuantity(int productNumber, int quantity) {
        Iterator<Cartitem> iter = cartlist.iterator();
        while (iter.hasNext()) {
            Cartitem cartitem = iter.next();
            Book product = cartitem.getProduct();
            if (product.getProductNumber() == productNumber) {
                cartitem.setQuantity(quantity);
            }
        }
    }


    public void setCartlist(List<Cartitem> cart) {
        this.cartlist = cart;
    }

    public List<Cartitem> getCartlist() {
        return cartlist;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", cartlist=" + cartlist +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
