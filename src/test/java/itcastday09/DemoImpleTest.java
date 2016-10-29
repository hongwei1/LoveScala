package itcastday09;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import day0910.DemoImple;

public class DemoImpleTest
{

	DemoImple demoImple = new DemoImple();

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
	@Ignore
	public final void testShow1()
	{
	}

	@Test
	@Ignore
	public final void testShow2()
	{
	}

	@Test
	public final void testShow()
	{
		this.demoImple.show();

	}

}
