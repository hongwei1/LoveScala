package commontools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.MyTools;

public class MyToolsTest
{

	String[] stringArray = { "z", "a", "d", "h", "aa", "b" };
	Object[] objectArray = { 1, 2 };
	Integer[] integerArray = { 1, 2, 3 };
	char[] charArray = { 'a', 'b' };
	int[] intArray = { 5, 2, 1 };

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
	public final void testGetMax()
	{
		final int max = MyTools.getMax(this.intArray);
		Assert.assertEquals(5, max);
	}

	@Test
	public final void testSelectSort()
	{
		MyTools.selectSort(this.intArray);
		MyTools.myPrint(this.intArray);
	}

	@Test
	public final void testGetIndex()
	{
		final int actual = MyTools.getIndex(this.intArray, 2);
		Assert.assertEquals(1, actual);
	}

	@Test
	public final void testMyPrint()
	{
		MyTools.myPrint(this.stringArray);

		MyTools.myPrint(this.integerArray);

		MyTools.myPrint(this.charArray);

		MyTools.myPrint(this.intArray);

		MyTools.myPrint(this.objectArray);
	}

	@Test
	public final void testMyStringToFile()
	{
		MyTools.myStringToFile("src/test/resources/t.txt", "Hi,Hongwei", true);
	}

	@Test
	public final void testMyFileToString()
	{
		String myFileToString = MyTools.myFileToString("src/test/resources/t.txt");
		System.out.println(myFileToString);
	}

}
