package n3_haitest;

import org.junit.Assert;
import org.junit.Test;

import n3_hai.BankService;
import n3_hai.BankServicecImpl;
import n3_hai.CongDan;

public class BankIsVayTest {
	BankService bankService=new BankServicecImpl();
	@Test(expected = NullPointerException.class)
	public void findCongDanByIdNull() {
		CongDan result =	bankService.findCongDanByID(null);
		  Assert.assertEquals(result, null);
	}
}
