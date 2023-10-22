package com.company.demo.serviceimpl;

import com.company.demo.entity.Cart;
import com.company.demo.entity.Customer;
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;
import com.company.demo.repository.CartRepository;
import com.company.demo.repository.CustomerRepository;
import com.company.demo.service.CartService;
import com.company.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerService customerService;
    @Override
    public List<Cart> readCartItemsByCustomer(String customerId) throws NoEntitiesException, EntityNotFoundException {
        Customer customer= this.customerService.readCustomerById(customerId);
        List<Cart> cartItems=cartRepository.findAllByCustomer(customer);
        if(!cartItems.isEmpty())
        {
            return cartItems;
        }

        throw  new NoEntitiesException("No items found in cart");
    }

    @Override
    public Cart createCartItem(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public String removeCartItem(String cartId) throws EntityNotFoundException {
        Cart cartItem=this.cartRepository.findById(cartId).orElseThrow(()->new EntityNotFoundException("No cart item found with id: " + cartId));
        this.cartRepository.delete(cartItem);
        return "Cart item removed successfully for cart ID : "+cartId;
    }
}
