package com.pblgllgs.orderresourceserver;
/*
 *
 * @author pblgl
 * Created on 07-02-2024
 *
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @GetMapping
    public List<OrderRest> getOrders(){
        OrderRest order1 = new OrderRest("1", "A123", "user1", 2, OrderStatus.NEW);
        OrderRest order2 = new OrderRest("2", "B456", "user2", 3, OrderStatus.APPROVED);
        OrderRest order3 = new OrderRest("3", "C789", "user3", 1, OrderStatus.APPROVED);
        OrderRest order4 = new OrderRest("4", "D012", "user4", 4, OrderStatus.REJECTED);
        OrderRest order5 = new OrderRest("5", "E345", "user5", 5, OrderStatus.REJECTED);
        return Arrays.asList(order1,order2,order3,order4,order5);
    }
}
