package n3_haitest;
import org.junit.Assert;
import org.junit.Test;

import n3_hai.BankService;
import n3_hai.BankServicecImpl;
import n3_hai.CongDan;

public class BankTestFindById {
	BankService bankService=new BankServicecImpl();
	@Test(expected = NullPointerException.class)
	public void findCongDanByIdNull() {
		CongDan result =	bankService.findCongDanByID(null);
		  Assert.assertEquals(result, null);
	}
	@Test
	public void findCongDanByIdNotFound() {
		Integer idNotFound=12312312;
		CongDan result =	bankService.findCongDanByID(idNotFound);
		  Assert.assertNotEquals(result, null);
	}
	@Test(expected = NumberFormatException.class)
	public void findCongDanByIdErrorFormat() {
		
	}
	@Test(expected = ArithmeticException.class)
	public void findCongDanByIdOverMax() {
		Integer idNotFound=Integer.parseInt("99999999999999999999999999");
		CongDan result =	bankService.findCongDanByID(idNotFound);
		  Assert.assertNotEquals(result, null);
		
	}
	@Test(expected = ArithmeticException.class)
	public void findCongDanByIdOK() {
		Integer idNotFound=Integer.parseInt("99999999999999999999999999");
		CongDan result =	bankService.findCongDanByID(idNotFound);
		  Assert.assertNotEquals(result, null);
		
	}
}
