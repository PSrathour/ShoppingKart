package com.shopping.mycart;

import com.shopping.mycart.service.PriceService;
import com.shopping.mycart.util.ProductUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class ShoppingApplicationTests {
	@Autowired
	PriceService priceService;
	@MockBean
	ProductUtil productUtil;
	@Test
	void contextLoads() {
	}
	@Test
	public void testCalculatePriceTest() {

	ArrayList al=new ArrayList();
		al.add("Mango");
		al.add("Orange");
		al.add("Papaya");
		when(productUtil.getPriceByProduct(Mockito.anyString(),Mockito.anyInt())).thenCallRealMethod();
		double price = priceService.totalPrice(al);
		assertEquals(50,price);
	}

	@Test
	public void testSumTotalIfNotFoundTest() {
		ArrayList al=new ArrayList();
		al.add("AA");
		al.add("BB");
		al.add("CC");
		when(productUtil.getPriceByProduct(Mockito.anyString(),Mockito.anyInt())).thenCallRealMethod();
		double price = priceService.totalPrice(al);
		assertEquals(0.0,price);
	}
}
