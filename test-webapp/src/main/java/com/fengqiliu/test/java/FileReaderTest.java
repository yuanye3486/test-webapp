package com.fengqiliu.test.java;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		stat();
	}
	
	public static void stat() throws IOException{
		List<String> lines = FileUtils.readLines(new File("C:\\Users\\Administrator\\Desktop\\采集点统计.txt"));
		Set<String> set = new HashSet<String>();
		int totalLines = 0;
		for(String line : lines){
			
			String[] cols = line.split("\t");
			String serviceId = cols[0];
			if(StringUtils.isNotEmpty(serviceId)){
				if(set.contains(serviceId)){
					System.out.println("already contained : " + serviceId);
				}else{
					set.add(serviceId);	
				}
			}
			totalLines ++;
		}
		System.out.println("total lines = " + totalLines);
		System.out.println("diff serviceId lines = " + set.size());
		
	}

}
