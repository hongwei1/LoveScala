package itcastday15.p1.string.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.MyTools;

/**
 * @author zhanghongwei
 *
 */
public class StringTestTest
{

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * 1，给定一个字符串数组。按照字典顺序进行从小到大的排序。 {"nba","abc","cba","zz","qq","haha"}
	 */
	@Test
	public final void testRank()
	{
		String[] target = { "z", "a", "d", "h", "aa", "b" };

		MyTools.myPrint(target);

		// first make it as array, yes it is .no need.
		// rank --bubble
		// for (int i = 0; i < target.length - 1; i++)
		// {
		// for (int j = i; j < target.length; j++)
		// {
		// if (target[j].compareTo(target[i]) > 0)
		// {
		// String temp = target[i];
		// target[i] = target[j];
		// target[j] = temp;
		// }
		// }
		// }
		// rank -selected
		StringBuilder tempValue = new StringBuilder();
		for (int i = 0; i < target.length; i++)
		{
			int tempIndex = i;
			tempValue.setLength(0);
			tempValue = new StringBuilder(target[i]);
			for (int j = i; j < target.length; j++)
			{
				if (String.valueOf(tempValue).compareTo(target[j]) < 0)
				{
					tempIndex = j;
					tempValue.setLength(0);
					tempValue = tempValue.append(target[j]);
				}
			}
			target[tempIndex] = target[i];
			target[i] = String.valueOf(tempValue);

		}
	}

	/**
	 * 2，一个子串在整串中出现的次数。 "abddabeeadffab"
	 */
	@Test
	public final void testCounts()
	{
		String target = "aba";
		String subString = "ab";
		int count = 0;
		int indexOf = 0;
		// 1 indexof know the first ad position
		while (true)
		{
			indexOf = target.indexOf(subString, count + indexOf);
			if (indexOf < 0)
			{
				System.out.println(count);
				break;
			}
			count++;
		}

		// 2 set next unitl the last count it.
	}

	/**
	 * 3，两个字符串中最大相同的子串。
	 */
	@Test
	public final void testMaxSameSubstring()
	{
		String target = "11";
		String subString = "bcd";

		// -- from end: ->bcd bc b
		// -- from start: ->bcd cd d

		String longString = target;
		String targitString = null;
		// 1 who is bigger ? bigger one is the key
		final int longStringLength = subString.length();

		if (target.length() < longStringLength)
		{
			longString = subString;
		}
		// 2 "contains" the string all value
		int beginIndex = 0;
		int endIndex = longStringLength;
		while (true)
		{
			if (beginIndex >= longStringLength || endIndex <= 0)
			{
				System.out.println(targitString);
				break;
			}
			String substringFromStart = subString.substring(beginIndex, longStringLength);
			if (longString.contains(substringFromStart))
			{
				targitString = substringFromStart;

				break;
			}
			String substringFromEnd = subString.substring(0, endIndex);
			if (longString.contains(substringFromEnd))
			{
				targitString = substringFromEnd;
				break;
			}
			beginIndex++;
			endIndex--;
			targitString = "";
			System.out.println(targitString);
		}

		System.out.println();
	}

	/**
	 * * 4，模拟一个trim功能一致的方法。
	 */
	@Test
	public final void testMyTrim()
	{
		String target = "	a b   ";
		String expected = "   a b   ";

		while (true)
		{
			if (target.indexOf(" ") != 0)
			{
				break;
			}
			target = target.substring(1);
		}

		while (true)
		{
			if (target.lastIndexOf(" ") != target.length() - 1)
			{
				break;
			}
			target = target.substring(0, target.length() - 1);
		}

		Assert.assertEquals(target, expected.trim());
	}

}
