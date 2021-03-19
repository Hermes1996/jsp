package common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CommonUtils
{
	/**
	 * html转码
	 *
	 *
	 * @param input
	 * @return
	 * @return String
	 */
	public static String html(String input)
	{
		String encode = input;
		try
		{
			encode = URLEncoder.encode(input, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
		}

		return encode;
	}
}
