package com.company.demo.service;

import com.company.demo.entity.Cart;
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;

import java.util.List;

public interface CartService
{
    public List<Cart> readCartItemsByCustomer(String customerId) throws NoEntitiesException, EntityNotFoundException;
    public Cart createCartItem(Cart cart);
    public String removeCartItem(String cartId) throws EntityNotFoundException;
}
