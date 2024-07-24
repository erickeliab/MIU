import java.util.HashMap;
import java.util.Map;

public class ShoppingCartDAO {
    private Map<String, ShoppingCart> shoppingCartMap;

    public ShoppingCartDAO() {
        shoppingCartMap = new HashMap<>();
    }

    public void saveCart(ShoppingCart cart) {
        shoppingCartMap.put(cart.getCartId(), cart);
    }

    public ShoppingCart findCartById(String cartId) {
        return shoppingCartMap.get(cartId);
    }

    public void deleteCart(String cartId) {
        shoppingCartMap.remove(cartId);
    }
}
