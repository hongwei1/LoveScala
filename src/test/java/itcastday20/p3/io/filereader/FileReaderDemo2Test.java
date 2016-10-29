package itcastday20.p3.io.filereader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.MyTools;

public class FileReaderDemo2Test
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
	public final void test() throws IOException
	{
		FileReader fr = new FileReader(MyTools.PATH);

		/*
		 * 使用read(char[])读取文本文件数据。
		 *
		 * 先创建字符数组。
		 */
		char[] buf = new char[1024];

		int len = 0;
		int i = 0;
		while ((len = fr.read(buf)) != -1)
		{
			System.out.print(new String(buf, 0, len));
			// i++;
		}
		// System.out.println(i);
	}

	@Test
	public final void test2() throws IOException
	{
		int i = 0;
		Reader reader = new FileReader(MyTools.PATH);
		char[] cbuf = new char[1024 * 1024 * 10];
		int len = reader.read(cbuf, 0, reader.read(cbuf));
		while (len != -1)
		{
			// System.out.print(cbuf);
			len = reader.read(cbuf);
			i++;
		}
		System.out.println(i);
	}

}
