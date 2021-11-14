package com.shopping.mycart.controller;

import com.shopping.mycart.exception.ProductNotfoundException;
import com.shopping.mycart.product.Products;
import com.shopping.mycart.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController {
@Autowired
PriceService priceService;
    @PostMapping("/getBasketItemsPrice")
    public double calculateBasketItems(@RequestBody List<Products> products){
       double paymentAmount;
        paymentAmount=priceService.totalPrice(products);
        if(paymentAmount== 0.0)
            throw new ProductNotfoundException();
          return paymentAmount;
    }

}
