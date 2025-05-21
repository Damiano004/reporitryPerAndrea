package com.damiano.purchases.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.damiano.purchases.models.ShoppingCart;
import com.damiano.purchases.models.DTOs.ShoppingCartDTO;
import com.damiano.purchases.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    private final UserService userService;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository sCRepo, UserService userService){
        shoppingCartRepository = sCRepo;
        this.userService = userService;
    }

    public List<ShoppingCartDTO> getShoppingCarts(){
        return shoppingCartRepository.findAll().stream()
            .map(sc ->
                new ShoppingCartDTO(
                    sc.getItems(),
                    this.userService.getUserById(sc.getUserId())
                    ))
                .toList();
    }

    public ShoppingCartDTO getShoppingCartById(String id){
        ShoppingCart sc = shoppingCartRepository.findById(id).orElse(null);
        if(sc == null){
            return null;
        }

        return new ShoppingCartDTO(sc.getItems(), this.userService.getUserById(sc.getUserId()));
    }

    public ShoppingCartDTO createShoppingCart(ShoppingCart sc){
        shoppingCartRepository.save(sc);
        return new ShoppingCartDTO(sc.getItems(),userService.getUserById(sc.getUserId()));
    }
}
