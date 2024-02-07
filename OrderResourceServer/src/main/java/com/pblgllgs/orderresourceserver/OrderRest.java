package com.pblgllgs.orderresourceserver;
/*
 *
 * @author pblgl
 * Created on 07-02-2024
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRest {

    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private OrderStatus orderStatus;
}
