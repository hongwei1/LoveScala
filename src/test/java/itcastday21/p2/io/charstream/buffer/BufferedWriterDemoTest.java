package itcastday21.p2.io.charstream.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import day11.MyException;

public class BufferedWriterDemoTest
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

	@Test
	public final void test() throws MyException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/1.txt";
		String newPath = "/Users/zhanghongwei/Desktop/2.txt";

		// 1 read value from file
		try (Reader fReader = new FileReader(orignalPath); Writer fWriter = new FileWriter(newPath, true);)
		{
			char[] cbuf = new char[1024];
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

	@Test
	public final void test2() throws MyException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/2.txt";
		String newPath = "/Users/zhanghongwei/Desktop/3.txt";

		// 1 read value from file
		try (Reader fReader = new FileReader(orignalPath);
				FileWriter fWriter = new FileWriter(newPath, true);
				BufferedReader burd = new BufferedReader(fReader, 1024 * 1024);
				BufferedWriter bufw = new BufferedWriter(fWriter, 1024 * 1024);)
		{
			char[] cbuf = new char[1024];
			for (int read = 0; read != -1; read = burd.read(cbuf))
			{
				bufw.write(cbuf, 0, read);
			}
			bufw.flush();
		}
		catch (IOException e)
		{
			throw new MyException("the file path :" + orignalPath + "is wrong !", e);
		}
	}

	@Test
	public final void test3() throws MyException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/2.txt";
		String newPath = "/Users/zhanghongwei/Desktop/3.txt";

		// 1 read value from file
		try (InputStream fReader = new FileInputStream(orignalPath);
				OutputStream fWriter = new FileOutputStream(newPath);
				BufferedInputStream burd = new BufferedInputStream(fReader, 1024 * 1024);
				BufferedOutputStream bufw = new BufferedOutputStream(fWriter, 1024 * 1024);)
		{
			byte[] cbuf = new byte[1024];
			for (int read = 0; read != -1; read = burd.read(cbuf))
			{
				bufw.write(cbuf, 0, read);
			}
			bufw.flush();
		}
		catch (IOException e)
		{
			throw new MyException("the file path :" + orignalPath + "is wrong !", e);
		}
	}

	@Test
	public final void test4() throws MyException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/2.txt";
		String newPath = "/Users/zhanghongwei/Desktop/3.txt";

		// 1 read value from file
		try (InputStream fReader = new FileInputStream(orignalPath); OutputStream fWriter = new FileOutputStream(newPath);)
		{
			byte[] cbuf = new byte[1024];
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

	@Test
	public final void test5() throws MyException
	{
		String orignalPath = "/Users/zhanghongwei/Desktop/1.txt";
		String newPath = "/Users/zhanghongwei/Desktop/2.txt";

		char[] cbuf = new char[1024];
		try (Reader reader = new FileReader(orignalPath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				Writer writer = new FileWriter(newPath);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);)
		{
			for (int read = 0; read != -1; read = bufferedReader.read(cbuf))
			{
				bufferedWriter.write(cbuf, 0, read);
			}
			bufferedWriter.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
