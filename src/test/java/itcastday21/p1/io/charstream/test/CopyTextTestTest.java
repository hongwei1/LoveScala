package itcastday21.p1.io.charstream.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import day11.MyException;

public class CopyTextTestTest
{

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

	/**
	 * copy 1.txt from MyTools.PATH to "/Users/zhanghongwei/Desktop"
	 *
	 * @throws MyException
	 * @throws IOException
	 *
	 */
	@Test
	public final void testCopyTextTest() throws MyException, IOException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/1.txt";
		String newPath = "/Users/zhanghongwei/Desktop/2.txt";

		// 1 read value from file
		Reader fReader = new FileReader(orignalPath);
		FileWriter fWriter = new FileWriter(newPath, true);

		char[] cbuf = new char[1024 * 1024];
		for (int read = 0; read != -1; read = fReader.read(cbuf))
		{
			fWriter.write(cbuf, 0, read);
		}

		// }
		// catch (IOException e)
		// {
		// throw new MyException("the file path :" + orignalPath + "is wrong !", e);
		// }

	}

	@Test
	public final void testCopyTextTest2() throws MyException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/1.txt";
		String newPath = "/Users/zhanghongwei/Desktop/2.txt";

		// 1 read value from file
		try (Reader fReader = new FileReader(orignalPath); FileWriter fWriter = new FileWriter(newPath, true);)
		{
			char[] cbuf = new char[1024 * 1024];
			for (int read = 0; read != -1; read = fReader.read(cbuf))
			{
				fWriter.write(cbuf, 0, read);
			}

		}
		catch (IOException e)
		{
			throw new MyException("the file path :" + orignalPath + "is wrong !", e);
		}

	}

}
