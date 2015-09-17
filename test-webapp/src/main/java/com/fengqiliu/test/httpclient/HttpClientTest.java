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
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
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
		
//		addMulti();
		
//		addOne();
		
//		queryTest();
		
//		get("http://192.168.73.128:8081/api/endpoints?q=l&tags=&limit=50&_r=0.013681906275451183");
		
//		post("http://42.62.65.248:8081/api/counters", "{\"endpoints\":[\"dam\"],\"q\":国内论坛,\"limit\":50,\"_r\":0.2284870920702815}");
		
		String url = "http://42.62.65.248:8081/api/counters";
		String url2 = "http://42.62.65.248:8081/chart";
		NameValuePair[] reqParams = { new NameValuePair("endpoints[]", "dam"),
				new NameValuePair("counters[]", "category.coll_inc.1hour/drId=52,mt=4,name=国内博客"),
				new NameValuePair("graph_type", "d"),
				new NameValuePair("_r", String.valueOf(Math.random())) }; 
		
		
		
		
		postWithHeader(url2, reqParams);
		
		
	}
	
	public static void postWithHeader(String url, NameValuePair[] reqParams) throws IOException{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		
//		post.getParams().setUriCharset("utf-8");
		post.getParams().setContentCharset("utf-8");
//		
//		Header header = new Header();
//		header.setName("Content-Type");
//		header.setValue("application/x-www-form-urlencoded; charset=GBK");
//		post.addRequestHeader(header);
		
		post.setRequestBody(reqParams);
		client.executeMethod(post);
		System.out.println("===> response info=" + post.getResponseBodyAsString());
		post.releaseConnection();
		
	}
	
	
	public static void get(String uri) throws HttpException, IOException{
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(uri);
		client.executeMethod(get);
		System.out.println("===> response info=" + get.getResponseBodyAsString());
		// 释放连接
		get.releaseConnection();
	}
	
	public static void queryTest() throws HttpException, IOException{
		String url = "http://192.168.200.37:9966/graph/history";
		String datajson = "{\"start\":1439276400,\"end\":1439277000,\"cf\":\"AVERAGE\",\"endpoint_counters\":[{\"endpoint\":\"falcon-host\",\"counter\":\"cpu.idle\"}]}";
		
		post(url, datajson);
	}
	
	public static void addOne() throws ParseException, HttpException, IOException{
		String url = "http://192.168.73.128:1989/v1/push";
//		long dateTimestamp = DateUtils.parseDate("2015-7-24 14", "yyyy-MM-dd HH").getTime()/1000;
		long dateTimestamp = DateUtils.parseDate("2015-08-10 13", "yyyy-MM-dd HH").getTime()/1000;
		double value = 250d;
		Data data = new Data("dam.test.1hour", "loc-windows", "test=测试4", value, dateTimestamp, 3600, "GAUGE");
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
		cal.setTime(DateUtils.parseDate("2015-08-10 00", "yyyy-MM-dd HH"));
		
		
		Date endTime = new Date(); //DateUtils.parseDate("2015-01-02 00", "yyyy-MM-dd HH");
		Random random = new Random();
		while(cal.getTime().before(endTime)){
			Data data = new Data("dam.test.1hour", "loc-windows", "test=测试5", random.nextInt(100000), cal.getTime().getTime()/1000, 3600, "GAUGE");	
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
//		 打印返回的信息
		System.out.println("===> response info=" + post.getResponseBodyAsString());
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
