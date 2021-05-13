package com.cg.entity;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cg.pojo.MDeal;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MDealTest {
	@SuppressWarnings("deprecation")
	@Test
	public void getTest() {

		LocalDate d1 = null;
		MDeal d = new MDeal(101, d1, 35000.00, 200, "abc");
		assertEquals(d.getDealId(), 101);
		assertEquals(d.getDealDate(), d1);
		assertEquals(d.getDealCost(), 35000.00, 0);
		assertEquals(d.getPropid(), 200);
		assertEquals(d.getUserid(), "abc");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void setTest() {
		MDeal d = new MDeal();
		LocalDate d1 = null;
		d.setDealId(101);
		d.setDealDate(d1);
		d.setDealCost(35000.00);
		d.setPropid(200);
		d.setUserid("abc");

		assertEquals(d.getDealId(), 101);
		assertEquals(d.getDealDate(), d1);
		assertEquals(d.getDealCost(), 35000.00, 0);
		assertEquals(d.getPropid(), 200);
		assertEquals(d.getUserid(), "abc");
	}
}
