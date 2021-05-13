package com.cg.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.pojo.PropertyCriteria;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyCriteriaTest {
	@Test
	public void getTest() {
		PropertyCriteria prop = new PropertyCriteria("xyz", "shop", "Hyd", 1.0, 100000.00);
		assertEquals(prop.getCity(), "Hyd");
		assertEquals(prop.getConfiguration(), "xyz");
		assertEquals(prop.getMinCost(), 1.0, 0);
		assertEquals(prop.getMaxCost(), 100000.00, 0);
		assertEquals(prop.getOfferType(), "shop");
	}

	@Test
	public void setTest() {
		PropertyCriteria prop = new PropertyCriteria();
		prop.setCity("Hyd");
		prop.setConfig("xyz");
		prop.setMinCost(1);
		prop.setMaxCost(100000);
		prop.setOffer("shop");

		assertEquals(prop.getCity(), "Hyd");
		assertEquals(prop.getConfiguration(), "xyz");
		assertEquals(prop.getMinCost(), 1.0, 0);
		assertEquals(prop.getMaxCost(), 100000.00, 0);
		assertEquals(prop.getOfferType(), "shop");
	}

}
