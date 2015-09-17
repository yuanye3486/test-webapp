package com.fengqiliu.test.java;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang3.StringUtils;

import com.fengqiliu.test.httpclient.HttpClientTest;
import com.fengqiliu.test.httpclient.HttpClientTest.Data;

public class FileTest {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");

	public static void main(String[] args) throws Exception {
		
		/*
			"3" 站点采集	site
      		"4" 类型数据采集	group
      		"5" URL采集	url
      		"2" 雷达采集	radar
      		"7" 发布采集时间差
			"6" 采集入库时间差
		 */
//		importToFalcon("52", "group", new File("C:\\Users\\Administrator\\Desktop\\redis-backup\\52-4.txt"));
		
//		filePropertiesTest();
		
		renameToTest();
	}
	

	private static void renameToTest() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\push.txt");
		File newFile = new File("C:\\Users\\Administrator\\Desktop\\push-01.txt");
		file.renameTo(newFile);
		file = newFile;
		System.out.println("old file = " + file.getAbsolutePath());
		System.out.println("new file = " + newFile.getAbsolutePath());
		System.out.println(file.equals(newFile));
	}





	public static void importToFalcon(String dataRepertoryId, String monitorType, File srcFile) throws Exception {
		String url = "http://192.168.73.128:1989/v1/push";
		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		String line;
		List<Data> bufferedList = new LinkedList<Data>();
		while ((line = br.readLine()) != null) {
			List<Data> list = getDataFromTextline(line, monitorType, dataRepertoryId);
			bufferedList.addAll(list);
			if(bufferedList.size() >= 10000){
				List<List<Data>> lists = splitDataList(bufferedList);
				for(List<Data> item : lists){
					HttpClientTest.post(url, item);
				}
				bufferedList.clear();
			}
		}
		
		List<List<Data>> lists = splitDataList(bufferedList);
		for(List<Data> item : lists){
			HttpClientTest.post(url, item);
		}
		
		br.close();
	}

	private static List<List<Data>> splitDataList(List<Data> dataList){
		List<List<Data>> list = new ArrayList<List<Data>>();
		final int pageSize = 500;
		if(dataList.size() <= pageSize){
			list.add(dataList);
		}
		int totalPage = dataList.size() % pageSize == 0 ? dataList.size() / pageSize : dataList.size() / pageSize + 1;
		for(int i = 0; i < totalPage; i++){
			if(dataList.size() % pageSize != 0 && i+1 == totalPage){
				list.add(dataList.subList(i*pageSize, dataList.size()));
			}else{
				list.add(dataList.subList(i*pageSize, (i+1)*pageSize));	
			}
		}
		return list;
	}
	
	private static List<Data> getDataFromTextline(String textLine, String monitorType, String dataRepertoryId) throws Exception {
		List<Data> list = new LinkedList<Data>();
		String[] kv = textLine.split(">>>");
		String targetName = kv[0];
		if(StringUtils.isEmpty(targetName)){
			return list;
		}
		
		String[] statItems = kv[1].split("#");
		for (String item : statItems) {
			// H:2015042111;25:0
			String[] fv = item.split(";");
			String[] date = fv[0].split(":");
			String dateStr = date[1];
			Date statTime = sdf.parse(dateStr);
			long timeStamp = statTime.getTime() / 1000;
			String interval = date[0];
			long amount = Long.valueOf(fv[1].split(":")[0]);

			IntervalType intervalType = getIntervalType(interval, statTime);
			String metric = "dcm." + monitorType + intervalType.getTypeName();
			String tags = "dataRepertoryId=" + dataRepertoryId + ",targetName=" + targetName;
			Data data = new Data(metric, "loc-windows", tags, amount, timeStamp, intervalType.getTypeValue(), Data.GAUGE);
			list.add(data);
		}
		return list;
	}

	private static IntervalType getIntervalType(String interval, Date statTime) throws Exception {
		switch (interval) {
		case "H":
			return new IntervalType(".1hour", 3600);
		case "D":
			return new IntervalType(".1day", 3600*24);
		case "M":
			Calendar cal = Calendar.getInstance();
			cal.setTime(statTime);
			return new IntervalType(".1month", 3600*24*cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		default:
			throw new Exception("不支持的intervalType类型！intervalType=" + interval);
		}
	}
	
//	private static IntervalType getIntervalType(String interval, Date statTime) throws Exception {
//		switch (interval) {
//		case "H":
//			return new IntervalType(".1hour", 3600);
//		case "D":
//			return new IntervalType(".1day", 3600*24);
//		case "M":
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(statTime);
//			return new IntervalType(".1month", 3600*24*cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		default:
//			throw new Exception("不支持的intervalType类型！intervalType=" + interval);
//		}
//	}
	
	
	private static class IntervalType {
		private String typeName;
		private int typeValue;

		public IntervalType(String typeName, int typeValue){
			this.typeName = typeName;
			this.typeValue = typeValue;
		}
		
		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		public int getTypeValue() {
			return typeValue;
		}

		public void setTypeValue(int typeValue) {
			this.typeValue = typeValue;
		}
	}

	private static File unCompressGZIP(File gzipFile) {

		File unCompressedFile = null;
		try {
			GZIPInputStream gzi = new GZIPInputStream(new FileInputStream(gzipFile));

			String gzipPath = gzipFile.getPath();
			unCompressedFile = new File(gzipPath.substring(0, gzipPath.lastIndexOf('.')) + ".tmp");
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(unCompressedFile));
			int b;
			byte[] buffer = new byte[1024 * 100];

			while ((b = gzi.read(buffer)) > 0) {
				bos.write(buffer, 0, b);
			}
			gzi.close();
			bos.close();
		} catch (Exception err) {
		}
		return unCompressedFile;
	}
	
	private static void filePropertiesTest(){
		File file = new File("C:\\Users\\Administrator\\Desktop\\git.txt");
		System.out.println(file.getParentFile());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		
		// System.out.println(System.getProperty("user.home"));
		// System.out.println(System.getProperty("java.io.tmpdir"));
		//
		// System.out.println("File.pathSeparator=" + File.pathSeparator);
		// System.out.println("File.pathSeparatorChar=" +
		// File.pathSeparatorChar);
		// System.out.println("File.separator=" + File.separator);
		// System.out.println("File.separatorChar=" + File.separatorChar);
		// System.out.println(File.createTempFile("datamonitor",
		// null).getPath());

		// unCompressGZIP(new
		// File("C:\\Users\\Administrator\\AppData\\Local\\Temp\\datamonitor_1503537707770902895.gz"));
	}
	
}
