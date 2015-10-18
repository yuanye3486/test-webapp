package com.fengqiliu.test.jedis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.exceptions.InvalidURIException;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.util.SafeEncoder;

public class JedisTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Jedis jedis = new Jedis("192.168.106.216");

	@Test
	public void exportOnlineData() throws IOException {
		List<String> shortKeyList = new ArrayList<String>();
		shortKeyList.add("54:4");
//		shortKeyList.add("53:4");
		shortKeyList.add("54:3");
//		shortKeyList.add("53:3");

		Jedis jedis = new Jedis("192.168.200.107", 6379, 360000);
		/*
		 * 分库分监控类型查询
		 */
		for (String shortKey : shortKeyList) {
			writeLog("\n" + sdf.format(new Date()) + "	export " + shortKey + "start...");
			int startIndex = 0;
			int pageSize = 10000;
			try {
				long totalCount = jedis.zcard(shortKey);
				System.out.println(shortKey + "包含的key数量：" + totalCount);
				long totalPage = totalCount / pageSize;
				if (totalCount % pageSize != 0) {
					totalPage = totalPage + 1;
				}

				File file = new File("C:\\Users\\Administrator\\Desktop\\redis-backup\\" + shortKey.replace(":", "-") + ".txt");

				/*
				 * 分页查询
				 */
				for (int i = 0; i < totalPage; i++) {
					Set<String> targetNames = jedis.zrange(shortKey, startIndex, startIndex + pageSize - 1);
					startIndex = startIndex + pageSize;

					/*
					 * 分key查询
					 */
					for (String tn : targetNames) {
						Map<String, String> map = jedis.hgetAll(shortKey + ":" + tn);

						/*
						 * 分条保存
						 */
						StringBuilder val = new StringBuilder();
						val.append(tn).append(">>>");
						for (Entry<String, String> entry : map.entrySet()) {
							val.append(entry.getKey()).append(";").append(entry.getValue()).append("#");
						}
						Collection<String> content = new ArrayList<String>();
						content.add(val.substring(0, val.length() - 1));
						FileUtils.writeLines(file, content, true);
					}
				}
			} catch (Exception e) {
				writeLog(sdf.format(new Date()) + "	export " + shortKey + " failed! \n" + e.getMessage());
			}
			
			writeLog(sdf.format(new Date()) + "	export " + shortKey + " success!");
		}
		jedis.close();

	}
	
	private void writeLog(String info) throws IOException{
		Collection<String> msg = new ArrayList<>(1);
		msg.add(info);
		FileUtils.writeLines(new File("C:\\Users\\Administrator\\Desktop\\redis-backup\\log.txt"), msg, true);
	}

	@Test
	public void test() {
		Jedis jedis = new Jedis("192.168.200.107");
		Set<String> val;
		long startTime = System.currentTimeMillis();
		// String val = jedis.hget("52:3:", "H:2015051614");
		// long len = jedis.zcard("53:3");
		val = jedis.zrangeByScore("53:3", 0, 0, 8500, 10);
		// val = jedis.zrange("53:3", 2400, 2410);
		long endTime = System.currentTimeMillis();
		System.out.println("val = " + 10 + ", 耗时：" + (endTime - startTime));
		printList(val);
		// System.out.println(len);
		jedis.close();
	}

	@Test
	public void testFlush() {
		// Jedis jedis = new Jedis("192.168.200.107");
		// long startTime = System.currentTimeMillis();
		// jedis.flushDB();
		// long endTime = System.currentTimeMillis();
		// System.out.println("耗时：" + (endTime - startTime));
		// jedis.close();

	}

	@Test
	public void testInfo() {
		Jedis jedis = new Jedis("192.168.200.107");
		long startTime = System.currentTimeMillis();
		String info = jedis.info();
		long endTime = System.currentTimeMillis();
		System.out.println("耗时：" + (endTime - startTime));
		System.out.println(info);
		jedis.close();
	}

	@Test
	public void testKeysTimes() {
		Set<String> val;
		Jedis jedis = new Jedis("192.168.200.107");
		long startTime = System.currentTimeMillis();
		val = jedis.keys("53:3:新华网*");
		long endTime = System.currentTimeMillis();
		jedis.close();
		printList(val);
		System.out.println("val = 53:3:*新华网*, 耗时：" + (endTime - startTime));
	}

	@Test
	public void testHmGetVal() {
		Jedis jedis = new Jedis("192.168.200.107");
		long startTime = System.currentTimeMillis();
		List<String> list = jedis.hmget("53:3:新华网", new String[] { "H:2015060100", "H:2015060101", "H:2015060102", "H:2015060103", "H:2015060104",
				"H:2015060105", "H:2015060106", "H:2015060107", "H:2015060108", "H:2015060109", "H:2015060110", "H:2015060111", "H:2015060112",
				"H:201506013", "H:201506014", "H:201506015", "H:2015060116", "H:2015060117", "H:2015060118", "H:2015060119", "H:2015060120",
				"H:2015060121", "H:2015060122", "H:2015060123" });
		long endTime = System.currentTimeMillis();
		jedis.close();
		System.out.println("val = " + 24 + ", 耗时：" + (endTime - startTime));
		printList(list);

	}

	@Test
	public void test2() {
		Jedis jedis = new Jedis("192.168.106.216");
		long startTime = System.currentTimeMillis();
		String val = jedis.hget("15:4:国内论坛", "H:2015051614");
		long endTime = System.currentTimeMillis();
		System.out.println("val = " + val + ", 耗时：" + (endTime - startTime));
		jedis.close();
	}

	@Test
	public void testScan() {
		Jedis jedis = new Jedis("192.168.200.107");
		ScanParams sp = new ScanParams();
		sp.count(10);
		long startTime = System.currentTimeMillis();
		List<String> list = jedis.scan("0", sp).getResult();
		long endTime = System.currentTimeMillis();
		System.out.println(" 耗时：" + (endTime - startTime));
		jedis.close();
		printList(list);

	}

	@Test
	public void testKeys() {
		Jedis jedis = new Jedis("192.168.200.107");
		long startTime = System.currentTimeMillis();
		jedis.keys("52:3:*上*");
		long endTime = System.currentTimeMillis();
		System.out.println(" 耗时：" + (endTime - startTime));
		jedis.close();
	}

	public void testGetVal() {

	}

	@Test
	public void export() {
		Jedis jedis = new Jedis("192.168.200.107");
		String keyPattern = "52:3:*";
		long startTime = System.currentTimeMillis();
		Set<String> keySet = jedis.keys(keyPattern);
		long endTime = System.currentTimeMillis();
		System.out.println("keys = " + keySet.size() + " * 耗时=" + (endTime - startTime));
		Transaction tx = jedis.multi();
		for (String key : keySet) {
			int lastIndexOfSep = key.lastIndexOf(":");
			String shortKey = key.substring(0, lastIndexOfSep);
			String targetName = key.substring(lastIndexOfSep + 1, key.length());
			tx.zadd(shortKey, 0, targetName);
		}
		tx.exec();
		long endTime2 = System.currentTimeMillis();
		System.out.println("add " + keySet.size() + "个sortedset key 耗时=" + (endTime2 - endTime));
		jedis.close();
	}

	@Test
	public void testTransaction() throws Exception {

		Transaction t = jedis.multi();
		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				// throw new Exception("jedis exception!");
			}
			t.lpush("datamonitor-test-key-01", String.valueOf(i));
		}
		t.exec();

		printValue();

	}

	@Test
	public void printValueElement() {
		ScanParams sp = new ScanParams();
		sp.count(10);
		ScanResult<String> sr = jedis.scan("0", sp);
		List<String> list = sr.getResult();
		printList(list);
		jedis.close();
	}

	@Test
	public void printZsetValue() {
		long startTime = System.currentTimeMillis();
		Set<String> keySet = jedis.zrangeByScore("15:3", 0, 0, 0, 20);
		long endTime = System.currentTimeMillis();
		System.out.println("查询一页耗时：" + (endTime - startTime));
		jedis.close();
		printList(keySet);
	}

	@Test
	public void testZscan() {
		ScanParams params = new ScanParams();
		params.count(Integer.MAX_VALUE);
		params.match("榆林*");
		long startTime = System.currentTimeMillis();
		List<Tuple> list = jedis.zscan("15:3", "0", params).getResult();
		long endTime = System.currentTimeMillis();
		System.out.println("zscan耗时：" + (endTime - startTime));

		for (Tuple tuple : list) {
			System.out.println(tuple.getElement());
		}

		System.out.println("***********************************");
		startTime = System.currentTimeMillis();
		Set<String> keySet = jedis.keys("*榆林*");
		endTime = System.currentTimeMillis();
		System.out.println("keys 耗时：" + (endTime - startTime));

		printList(keySet);
	}

	@Test
	public void printValue() {

		String key = "15:3:佛教论坛";
		String key2 = "15:4:国内新闻";
		String key3 = "15:4:国内论坛";
		long s = System.currentTimeMillis();
		String val = jedis.hget(key, "D:2015051600");
		long e = System.currentTimeMillis();
		System.out.println(val + (e - s));
		jedis.close();
	}

	@Test
	public void printMapValue() {

		String key1 = "15:3:新华网四川频道";
		String key2 = "15:4";
		String key3 = "15:4";
		String key = key1;
		String field = "H:2015051406";
		// printList(jedis.keys("15:3*"));
		printList(jedis.hmget(key, field));
		jedis.close();
	}

	@Test
	public void printKeys() {
		String keyPattern = "15,4,*";

		Set<String> keysSet = jedis.keys(keyPattern);
		System.out.println("============>key size:" + keysSet.size());
		Iterator<String> it = keysSet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " length = " + jedis.llen(key));
		}
		jedis.close();
	}

	@Test
	public void printMapKeys() {
		String keyPattern = "15:3*";
		Set<String> keysSet = jedis.keys(keyPattern);
		System.out.println("============>key size:" + keysSet.size());
		Iterator<String> it = keysSet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			// System.out.println(key + " length = " + jedis.llen(key));
		}
		jedis.close();
	}

	private void printList(Collection<String> collection) {
		if (collection == null || collection.size() < 1) {
			System.out.println("list为空");
			return;
		}
		for (String ele : collection) {
			System.out.println(ele);
		}
	}

	@Test
	public void checkBinaryData() {
		byte[] bigdata = new byte[1777];
		for (int b = 0; b < bigdata.length; b++) {
			bigdata[b] = (byte) ((byte) b % 255);
		}
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("data", SafeEncoder.encode(bigdata));

		String status = jedis.hmset("foo", hash);
		assertEquals("OK", status);
		assertEquals(hash, jedis.hgetAll("foo"));
	}

	@Test
	public void connectWithShardInfo() {
		JedisShardInfo shardInfo = new JedisShardInfo("localhost", Protocol.DEFAULT_PORT);
		shardInfo.setPassword("foobared");
		Jedis jedis = new Jedis(shardInfo);
		jedis.get("foo");
	}

	@Test(expected = JedisConnectionException.class)
	public void timeoutConnection() throws Exception {
		jedis = new Jedis("localhost", 6379, 15000);
		jedis.auth("foobared");
		jedis.configSet("timeout", "1");
		Thread.sleep(2000);
		jedis.hmget("foobar", "foo");
	}

	@Test(expected = JedisConnectionException.class)
	public void timeoutConnectionWithURI() throws Exception {
		jedis = new Jedis(new URI("redis://:foobared@localhost:6380/2"), 15000);
		jedis.configSet("timeout", "1");
		Thread.sleep(2000);
		jedis.hmget("foobar", "foo");
	}

	@Test(expected = JedisDataException.class)
	public void failWhenSendingNullValues() {
		jedis.set("foo", null);
	}

	@Test(expected = InvalidURIException.class)
	public void shouldThrowInvalidURIExceptionForInvalidURI() throws URISyntaxException {
		Jedis j = new Jedis(new URI("localhost:6380"));
		j.ping();
	}

	@Test
	public void shouldReconnectToSameDB() throws IOException {
		jedis.select(1);
		jedis.set("foo", "bar");
		jedis.getClient().getSocket().shutdownInput();
		jedis.getClient().getSocket().shutdownOutput();
		assertEquals("bar", jedis.get("foo"));
	}

	@Test
	public void startWithUrlString() {
		Jedis j = new Jedis("localhost", 6380);
		j.auth("foobared");
		j.select(2);
		j.set("foo", "bar");
		Jedis jedis = new Jedis("redis://:foobared@localhost:6380/2");
		assertEquals("PONG", jedis.ping());
		assertEquals("bar", jedis.get("foo"));
	}

	@Test
	public void startWithUrl() throws URISyntaxException {
		Jedis j = new Jedis("localhost", 6380);
		j.auth("foobared");
		j.select(2);
		j.set("foo", "bar");
		Jedis jedis = new Jedis(new URI("redis://:foobared@localhost:6380/2"));
		assertEquals("PONG", jedis.ping());
		assertEquals("bar", jedis.get("foo"));
	}

	@Test
	public void checkCloseable() {
		jedis.close();
		BinaryJedis bj = new BinaryJedis("localhost");
		bj.connect();
		bj.close();
	}

	@Test
	public void checkDisconnectOnQuit() {
		jedis.quit();
		assertFalse(jedis.getClient().isConnected());
	}

}