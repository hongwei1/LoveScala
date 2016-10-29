package algorithms;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class A12BaseConvertTest
{
	@Test
	public final void testBinaryToDecimal()
	{

		// 1 prepare data :110->5
		String inputValue = "111";
		int expected = 7;

		// 2 run app
		int actual = A11BaseConvert.BinaryToDecimal(inputValue);

		// 3 compare result
		Assert.assertEquals(expected, actual);
	}

	@Test
	public final void testDecimalToBinary()
	{
		// 1 prepare data
		String inputValue = "6";
		Object[] expecteds = new Object[100];
		Arrays.fill(expecteds, 0);
		expecteds[0] = 1;
		expecteds[1] = 1;
		expecteds[2] = 0;

		Object[] actuals = A11BaseConvert.DecimalToBinary(inputValue);
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
