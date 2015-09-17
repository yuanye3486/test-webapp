package com.fengqiliu.test.misc;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.fengqiliu.test.httpclient.HttpClientTest;

public class ZabbixApiTest {

	public static void main(String[] args) throws HttpException, IOException {
		
		zabbixAuthTest();
	}
	
	public static void zabbixAuthTest() throws HttpException, IOException{
		/*
		 * username:yuanbin
		 * auth:99f9c44ddd9c6debeffe21ff439d1128 
		 */
		
		String url = "http://om.trs.cn:9200/zabbix/api_jsonrpc.php";
		String reqVersionJson = "{\"jsonrpc\":\"2.0\",\"method\":\"apiinfo.version\",\"id\":1,\"auth\":null,\"params\":{}}";
		String reqAuth = "{\"jsonrpc\":\"2.0\",\"method\":\"user.login\",\"params\":{\"user\":\"yuanbin\",\"password\":\"yuanbin\"},\"id\":1}";
		
		
		HttpClientTest.post(url, reqAuth);
		
	}

}
