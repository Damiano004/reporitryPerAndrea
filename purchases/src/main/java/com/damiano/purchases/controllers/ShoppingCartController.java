package com.damiano.purchases.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damiano.purchases.models.ShoppingCart;
import com.damiano.purchases.models.DTOs.ShoppingCartDTO;
import com.damiano.purchases.services.ShoppingCartService;

@RestController
@RequestMapping("api/shoppingCarts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService scService){
        shoppingCartService = scService;
    }

    @GetMapping("")
    public List<ShoppingCartDTO> getAllCarts(){
        return shoppingCartService.getShoppingCarts();
    }

    @GetMapping("/{id}")
    public ShoppingCartDTO getCartById(@PathVariable String id){
        return shoppingCartService.getShoppingCartById(id);
    }

    @PostMapping("")
    public ShoppingCartDTO createShoppingCart(@RequestBody ShoppingCart shCart){
        return shoppingCartService.createShoppingCart(shCart);
    }
}
