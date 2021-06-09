package snippet;

import java.util.Arrays;

public class Snippet
{
	public static void main(String[] args)
	{
		//			StringBuffer s3 = new StringBuffer("Value1");
		//			String s2 = "Value2";
		//			for (int i = 0; i < 100000; ++i) {
		//			s3.append(s2);
		//		}
		//		String s3 = "Value1";
		//		String s2 = "Value2";
		//		for (int i = 0; i < 100000; ++i)
		//		{
		//			s3 = s3 + s2;
		//		}
		//		System.out.println(s2);
		int result = computerSimpleInterest(-1, 4, 12);
		System.out.println(result);
		tokenize("ac;bd;def;e", ";");
	}


	private static int computerSimpleInterest(int principal, float interest, int years)
	{
		assert (principal > 0);
		return 100;
	}


	private static void tokenize(String string, String regex)
	{
		String[] tokens = string.split(regex);
		System.out.println(Arrays.toString(tokens));
	}
}
