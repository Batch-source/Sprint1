package com.cg.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.pojo.MProperty;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MPropertyTest {
	@Test
	public void getTest() {
		MProperty property = new MProperty(123, "flat", "rent", 4500.45, 670.65, "hyd", "komaplly", "jayabheri", true,
				"561");
		assertEquals(property.getPropId(), 123);
		assertEquals(property.getConfiguration(), "flat");
		assertEquals(property.getOfferType(), "rent");
		assertEquals(property.getOfferCost(), 4500.45, 0);
		assertEquals(property.getAreaSqft(), 670.65, 0);
		assertEquals(property.getCity(), "hyd");
		assertEquals(property.getAddress(), "komaplly");
		assertEquals(property.getStreet(), "jayabheri");
		assertEquals(property.isStatus(), true);
		assertEquals(property.getBroid(), "561");

	}

	@Test
	public void setTest() {
		MProperty property = new MProperty();
		property.setPropId(123);
		property.setConfiguration("flat");
		property.setOfferType("rent");
		property.setOfferCost(4500.45);
		property.setAreaSqft(670.65);
		property.setCity("hyd");
		property.setAddress("kompally");
		property.setStreet("jayabheri");
		property.setStatus(true);
		property.setBroid("561");

		assertEquals(property.getPropId(), 123);
		assertEquals(property.getConfiguration(), "flat");
		assertEquals(property.getOfferType(), "rent");
		assertEquals(property.getOfferCost(), 4500.45, 0);
		assertEquals(property.getAreaSqft(), 670.65, 0);
		assertEquals(property.getCity(), "hyd");
		assertEquals(property.getAddress(), "kompally");
		assertEquals(property.getStreet(), "jayabheri");
		assertEquals(property.isStatus(), true);
		assertEquals(property.getBroid(), "561");

	}
}
