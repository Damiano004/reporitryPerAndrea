package com.damiano.purchases.models.DTOs;

import java.util.List;

import com.damiano.purchases.models.CartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
    private List<CartItem> items;
    private UserDTO user;
}
