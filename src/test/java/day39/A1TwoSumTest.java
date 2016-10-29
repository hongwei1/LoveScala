package day39;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class A1TwoSumTest
{

	private A1TwoSum a1TwoSum;

	@Before
	public void initialize()
	{
		a1TwoSum = new A1TwoSum();
	}

	@Parameterized.Parameters
	public static Collection<int[][]> primeNumbers()
	{
		return Arrays.asList(new int[][][] { //
				{ { 2, 7, 11, 15 }, { 9 }, { 0, 1 } }, //
				{ { 3, 2, 4 }, { 6 }, { 1, 2 } }

		});
	}

	@Parameter(0)
	public int[] fInput0;

	@Parameter(1)
	public int[] fInput1;

	@Parameter(2)
	public int[] fExpected;

	@Test
	public final void testTwoSum()
	{
		int[] actuals = a1TwoSum.twoSum(fInput0, fInput1[0]);

		Assert.assertArrayEquals(fExpected, actuals);
	}

}
