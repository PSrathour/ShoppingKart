package com.shopping.mycart.util;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("pdtUtil")
public class ProductUtil {
    public static Map map = new HashMap<String, Double>();
    static {
        map.put("Banana", 40.0);
        map.put("Orange", 50.0);
        map.put("Lemons", 60.0);
        map.put("Peaches", 70.0);
    }

    public double getPriceByProduct(String productName ,int quantity) {
        if (null != map.get(productName))
            return (double) map.get(productName)*quantity;
        else return 0;
    }

}
