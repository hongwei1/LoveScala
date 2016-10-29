package day38.chapter2;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class InsertSortTest
{

	private InsertSort insertSort;

	@Before
	public void initialize()
	{
		insertSort = new InsertSort();
	}

	@Parameterized.Parameters
	public static Collection<int[][]> primeNumbers()
	{
		return Arrays.asList(new int[][][] { //
				{ { 1 }, { 1 }, { 1 } }, // Initialization: It is true prior to the ﬁrst iteration
											// of the loop.
				{ { 5, 2, 4, 6, 1, 3 }, { 6, 5, 4, 3, 2, 1 }, { 1 } } //
		});
	}

	@Parameter(0)
	public int[] fInput0;

	@Parameter(1)
	public int[] fInput1;

	@Parameter(2)
	public int[] fInput2;

	@Test
	public final void test()
	{

		int[] actuals = insertSort.insertSort(fInput0);

		Assert.assertArrayEquals(fInput1, actuals);
	}

	@Test
	public void testBinarySum()
	{

		int A[] = { 0, 1 };
		int B[] = { 1, 1 };
		int expected[] = { 1, 0, 1 };
		int actuals[] = InsertSort.binarySum(A, B);

		Assert.assertArrayEquals(expected, actuals);
	}

	@Test
	public void testSlectSort()
	{

		int A[] = { 1, 3, 2 };
		int expected[] = { 1, 2, 3 };
		int actuals[] = InsertSort.slectSort(A);

		Assert.assertArrayEquals(expected, actuals);
	}

}
