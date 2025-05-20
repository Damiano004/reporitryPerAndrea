package com.damiano.purchases.models.DTOs;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.damiano.purchases.models.CartItem;
import com.damiano.purchases.models.User;
import com.damiano.purchases.repositories.UserRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private List<CartItem> items;
    private double totalAmount;
    private Date orderDate;
    private String status;
    private User user;
    @Autowired
    private UserRepository userRepository;

    public OrderDTO(List<CartItem> items, double totalAmount, Date orderDate, String status, String userId) {
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
        this.user = userRepository.findById(userId).orElse(null);
    }


}
