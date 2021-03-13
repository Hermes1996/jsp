package list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 添加类的一句话简单描述。
 *
 * @author 丁光辉
 * @version 1.0
 * @since Bessky V100R001C00
 */
public class listUtils
{

	public static void main(String[] args)
	{
		List list = Stream.of("a", "b","c","d","e","f").collect(Collectors.toList());
		if (list.size() >= 5)
		{
			list= list.subList(0, 5);
		}
		System.out.println(list);
	}
}
