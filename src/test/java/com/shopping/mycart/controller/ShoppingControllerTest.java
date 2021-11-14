package com.shopping.mycart.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.mycart.exception.ProductExceptionController;
import com.shopping.mycart.product.Products;
import com.shopping.mycart.service.PriceService;
import com.shopping.mycart.util.ProductUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ShoppingController.class, PriceService.class, ProductExceptionController.class, ProductUtil.class})
@WebMvcTest
class ShoppingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    PriceService priceService;


    @Autowired
    private WebApplicationContext webApp;

    ObjectMapper om=new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc= MockMvcBuilders.webAppContextSetup(webApp).build();
    }

    @Test
    void calculateBasketItems() throws Exception {
        ArrayList <Products>al=new ArrayList();
        Products pdt1=new Products(5,"Banana");
        Products pdt2=new Products(5,"Orange");
        Products pdt3=new Products(5,"Lemons");
        al.add(pdt1);
        al.add(pdt2);
        al.add(pdt3);

        //calling Mock Service
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/getBasketItemsPrice")
                        .content(om.writeValueAsString(al))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

    }
}