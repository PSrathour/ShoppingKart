package com.shopping.mycart.service;


import com.shopping.mycart.product.Products;
import com.shopping.mycart.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriceService {

@Autowired
ProductUtil productUtil;
double sum,total;
    public double totalPrice(List<Products> al) {
        sum = 0.0;
        total  = 0.0;
        al.stream().forEach(pdt->{
            total = productUtil.getPriceByProduct(pdt.getProductName(),pdt.getPrductQuantity());
            sum = sum + total;
        });
        return sum;
    }
}
