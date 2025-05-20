package com.damiano.purchases.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "shoppingCarts")
public class ShoppingCart {
    @Id
    private String id;
    @NonNull
    private String userId;
    private List<CartItem> items;
}
