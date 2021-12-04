package service;

import dto.AddToCartDto;
import dto.CartDto;
import model.Cart;
import model.CartCost;
import org.jvnet.hk2.annotations.Service;
import repository.CartRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public void addToCart(AddToCartDto addToCartDto, int userId) {
        Cart cart =new Cart(AddToCartDto, userId);
        return cart;
    }

    public CartCost listCartItems(int userID) {
        List<Cart> cartList = cartRepository.findAllbyUserIdOrderByCreatedDateDesc(userID);
        List<CartDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList) {
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }

        double totalCost = 0;
        for (CartDto cartDto:cartItems) {
            totalCost += (cartDto.getProduct().getPrice()* cartDto.getQuantity());
        }
        CartCost cartCost = new CartCost(cartItems,totalCost);
        return cartCost;
    }

    public static CartDto getDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto((cart);
        return cartDto;
    }

    public void updateCartItem(AddToCartDto cartDto, int userId, Product product) {
        Cart cart = getAddToCartFromDto(cartDto, userId);
        cart.setQuantity(cartDto.getQuantity());
        cart.setUserid(userId);
        cart.setId(cartDto.getId());
        cart.setProductId(product.getId());
        cartRepository.save(cart);
    }

    public void deleteCartItem(int id, int userId) throws CartItemNotExistException {
        if (!cartRepository.existsById(id))
            throw new CartItemNotExistException("Cart id is invalid : " + id);
        cartRepository.deleteById(id);
    }
}
