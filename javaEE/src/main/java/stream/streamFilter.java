package stream;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class streamFilter
{
	public static void main(String[] args)
	{
//		根据list里面一个对象，对象里面一个字段分组组成map
		List<LocationNumberRecord> LocationNumberRecords = new ArrayList<LocationNumberRecord>();
		Map<String, List<LocationNumberRecord>> locationNumberRecordMaps = new HashMap<String, List<LocationNumberRecord>>(16);
		LocationNumberRecords.add(new LocationNumberRecord().setSku("A").setRecordId("01"));
		LocationNumberRecords.add(new LocationNumberRecord().setSku("A").setRecordId("02"));
		LocationNumberRecords.add(new LocationNumberRecord().setSku("B").setRecordId("01"));
		locationNumberRecordMaps= LocationNumberRecords.stream()
				.collect(Collectors.groupingBy(LocationNumberRecord::getSku));
		System.out.println(locationNumberRecordMaps);
//      list里面对象的某字段过滤
		LocationNumberRecords= LocationNumberRecords.stream().filter(s -> s.getRecordId().contains("01"))
				.collect(Collectors.toList());
		System.out.println(LocationNumberRecords);
	}


}

@Accessors(chain = true)
@Data
class LocationNumberRecord
{
	private String sku;
	private String recordId;
}

