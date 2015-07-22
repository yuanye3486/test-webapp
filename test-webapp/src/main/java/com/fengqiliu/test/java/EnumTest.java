package com.fengqiliu.test.java;

import java.util.ArrayList;
import java.util.List;

public class EnumTest {

	static enum MonitorType{

		DB_TOTAL_RECORD("1","总数据量监控"),
		SITE_RECORD("2","ZHANDIAN监控");
		
		String value;
		String code;

		MonitorType(String code, String value) {
			this.code = code;
			this.value = value;
		}
		
		static String getValue(String code){
			
			if(DB_TOTAL_RECORD.code.equals(code)){
				return DB_TOTAL_RECORD.value;
			}else if(SITE_RECORD.code.equals(code)){
				return SITE_RECORD.value;
			}else{
				return "";
			}
		}
		
		static List<MonitorType> list(){
			List<MonitorType> list = new ArrayList<MonitorType>();
			list.add(DB_TOTAL_RECORD);
			list.add(SITE_RECORD);
			return list;
		}
	}
	
	public static void main(String[] args) {
				System.out.println(MonitorType.getValue("1"));
				System.out.println(MonitorType.DB_TOTAL_RECORD.code);
				List<MonitorType> list = EnumTest.MonitorType.list();
				System.out.println(list.size());
				for(MonitorType mt : list){
					System.out.println(mt.code+","+mt.value);
				}
	}

}
