package com.company.demo.controller;


import com.company.demo.entity.Cart;
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;
import com.company.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cart")
public class CartController
{
    @Autowired
    private CartService cartService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<?> createCart(@RequestBody Cart cart) {
        System.out.println(cart);
        Cart createdCart = this.cartService.createCartItem(cart);
        return ResponseEntity.status(201).body(createdCart);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/remove/{cartId}")
    public ResponseEntity<?> removeCart(@PathVariable String cartId) throws EntityNotFoundException {
        String message=this.cartService.removeCartItem(cartId);
        return ResponseEntity.status(200).body(message);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/all/{customerId}")
    public ResponseEntity<?> allCartItems(@PathVariable String customerId) throws NoEntitiesException, EntityNotFoundException {
        List<Cart> cartItems =this.cartService.readCartItemsByCustomer(customerId);
        return ResponseEntity.status(200).body(cartItems);
    }


}
