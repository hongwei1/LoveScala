package commontools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Algorithm03AccumulationTest
{

	final long SUM_MAX_NUM = 1000000000l;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{

	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public final void testMain()
	{
		// 累加思想-normal 。
		long sum = 0;
		for (long i = 1; i <= SUM_MAX_NUM; i++)
		{
			sum = sum + i;
		}
		System.out.println("sum=" + sum);

	}

	@Test
	public final void testMain1()
	{
		// 累加思想-2,高斯想的
		long sum1 = 0;
		sum1 = SUM_MAX_NUM * (SUM_MAX_NUM + 1) / 2;
		System.out.println("sum1 = " + sum1);
	}

}
