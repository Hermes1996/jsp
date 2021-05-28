import org.apache.commons.lang3.BooleanUtils;

class test {
	public static void main(String[] args)
	{
		if(!BooleanUtils.isTrue(null))
		{
			System.out.println(1);
		}
	}
}