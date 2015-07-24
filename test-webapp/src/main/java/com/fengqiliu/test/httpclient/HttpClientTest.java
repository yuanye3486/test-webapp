package com.fengqiliu.test.httpclient;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClientTest {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
/*		Data data = new Data("dcm.group.1hour", "loc-windows", "dataRepertoryId=52,targetName=guonei10", 250, 1437634800, 3600, "GAUGE");
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.parseDate("2015-07-23 00", "yyyy-MM-dd HH"));
		while(cal.getTime().before(new Date())){
//			cal.add(Calendar.MINUTE, 1);
			cal.add(Calendar.HOUR_OF_DAY, 1);
			data.setTimestamp(cal.getTime().getTime()/1000);
			addOne(data);
		}*/
		
//		addMulti();
		
		addOne();
	}
	
	public static void addOne() throws ParseException, HttpException, IOException{
		String url = "http://192.168.73.128:1989/v1/push";
//		long dateTimestamp = DateUtils.parseDate("2015-7-24 14", "yyyy-MM-dd HH").getTime()/1000;
		long dateTimestamp = DateUtils.parseDate("2015-07-24 24", "yyyy-MM-dd HH").getTime()/1000;
		double value = 250d;
		Data data = new Data("dcm.group.1hour", "loc-windows", "dataRepertoryId=52,targetName=guonei10", value, dateTimestamp, 3600, "GAUGE");
		String datajson = objectMapper.writeValueAsString(data);
		datajson = "[" + datajson + "]";
		post(url, datajson);
	}
	
	public static void addOne(Data data) throws ParseException, HttpException, IOException{
		String url = "http://192.168.73.128:1989/v1/push";
		String datajson = objectMapper.writeValueAsString(data);
		datajson = "[" + datajson + "]";
		System.out.println(datajson);
		post(url, datajson);
	}

	public static void addMulti() throws ParseException, HttpException, IOException{
		String url = "http://192.168.73.128:1989/v1/push";
		List<Data> list = new ArrayList<Data>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.parseDate("2015-01-01 00", "yyyy-MM-dd HH"));
		
		
		Date endTime = DateUtils.parseDate("2015-01-02 00", "yyyy-MM-dd HH");
		Random random = new Random();
		while(cal.getTime().before(endTime)){
			Data data = new Data("dcm.dbDataInc", "loc-windows", "dbname=dc_chuantong", random.nextInt(100000), cal.getTime().getTime()/1000, 3600, "GAUGE");	
			cal.add(Calendar.HOUR_OF_DAY, 1);
			list.add(data);
			if(list.size() == 500){
				String datajson = objectMapper.writeValueAsString(list);
				FileUtils.writeStringToFile(new File("C:\\Users\\Administrator\\Desktop\\muti.log"), datajson + "\n", true);
				post(url, datajson);
				list.clear();
			}
		}
		
		if(list.size()>0){
			String datajson = objectMapper.writeValueAsString(list);
			FileUtils.writeStringToFile(new File("C:\\Users\\Administrator\\Desktop\\muti.log"), datajson + "\n", true);
			post(url, datajson);
		}
	}
	
	public static void post(String url, List<Data> list) throws HttpException, JsonProcessingException, IOException{
		String jsonData = objectMapper.writeValueAsString(list);
		List<String> dataList = new ArrayList<String>(1);
		dataList.add(jsonData);
		FileUtils.writeLines(new File("C:\\Users\\Administrator\\Desktop\\push.txt"), dataList, true);
		
//		try {
//			Thread.sleep(10000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		post(url, jsonData);
	}
	
	public static void post(String url, String json) throws HttpException, IOException{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
//		System.out.println("push data = " + json);
		RequestEntity requestEntity = new StringRequestEntity(json, "application/json", "utf-8");
		post.setRequestEntity(requestEntity);
		client.executeMethod(post);
		// 打印服务器返回的状态
//		System.out.println("Status = " + post.getStatusLine());
		// 打印返回的信息
//		System.out.println("response info=" + post.getResponseBodyAsString());
		// 释放连接
		post.releaseConnection();
	}

	public static class Data {
		private String metric;
		private String endpoint;
		private String tags;
		private double value;
		private long timestamp;
		private int step;
		private String counterType;

		public static final String GAUGE = "GAUGE";
		public static final String COUNTER = "COUNTER";
		
		public Data() {
			super();
		}

		public Data(String metric, String endpoint, String tags, double value, long timestamp, int step, String counterType) {
			super();
			this.metric = metric;
			this.endpoint = endpoint;
			this.tags = tags;
			this.value = value;
			this.timestamp = timestamp;
			this.step = step;
			this.counterType = counterType;
		}

		public String getMetric() {
			return metric;
		}

		public void setMetric(String metric) {
			this.metric = metric;
		}

		public String getEndpoint() {
			return endpoint;
		}

		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public int getStep() {
			return step;
		}

		public void setStep(int step) {
			this.step = step;
		}

		public String getCounterType() {
			return counterType;
		}

		public void setCounterType(String counterType) {
			this.counterType = counterType;
		}
	}
}
