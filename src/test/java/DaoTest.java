

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.dao.DrinkDelightDaoImpl;
import com.cg.main.ProductStock;

public class DaoTest {
	private static DrinkDelightDaoImpl test;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new DrinkDelightDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void doesProductOrderIdExistsTest() {
		boolean val = test.doesProductOrderIdExists("BS");
		assertTrue(val);
	}
	
	@Test
	public void updateProductStockTest() {
		boolean val = test.updateProductStock(new ProductStock());
		assertTrue(val);
	}
	@Test
	public void validateExpiryDateTest() {
		boolean val = test.doesProductOrderIdExists("MJ");
		assertTrue(val);
	}
	@Test
	public void getMapTest() {
		HashMap<String, ProductStock> list = test.getMap();
		assertNotNull(list);
		
	}
	@Test
	public void updateStatusTest() {
		boolean val = test.updateStatus("GJ","Dispatched");
		assertTrue(val);
	}

}
