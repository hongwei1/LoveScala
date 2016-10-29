package day38.chapter2;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest
{

	@Test
	public final void test()
	{
		int A[] = { 1, 3, 2, 4 };
		int expected[] = { 1, 2, 3, 4 };
		MergeSort.mergeSort(A, 0, A.length);
		Assert.assertArrayEquals(expected, A);
	}

}
