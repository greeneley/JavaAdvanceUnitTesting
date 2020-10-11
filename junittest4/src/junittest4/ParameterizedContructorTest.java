package junittest4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import appPara.Fibonacci;

@RunWith(value = Parameterized.class)
public class ParameterizedContructorTest {

	private int number;
	private int expected;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, //
				{ 1, 1 }, //
				{ 2, 1 }, //
				{ 3, 2 }, //
				{ 4, 3 }, //
				{ 5, 5 } ////
		});
	}

	public ParameterizedContructorTest(int number, int expected) {
		this.number = number;
		this.expected = expected;
	}

	@Test
	public void test_Fibonacci() {
		assertEquals(expected, Fibonacci.compute(number));
	}

}
