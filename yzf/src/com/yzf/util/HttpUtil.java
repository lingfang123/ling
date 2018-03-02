package com.yzf.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil<T> {
	
	public Object httpRequest(T t) throws Exception {
		ObjectMapper m = new ObjectMapper();  
		String sendStr = m.writeValueAsString(t);
		//sendStr.append("测试数据");
		
		BufferedReader reader = null;
		try {
			String strMessage = "";  
	        StringBuffer buffer = new StringBuffer();  
	        // 接报文的地址  
	        URL uploadServlet = new URL(  
	               "http://192.168.3.132:8080/ZtreeShiro/user/getmessage");  
	        HttpURLConnection servletConnection = (HttpURLConnection) uploadServlet  
	               .openConnection();  
	        
	        // 设置连接参数  
	        servletConnection.setRequestMethod("POST");  
	        servletConnection.setDoOutput(true);  
	        servletConnection.setDoInput(true);  
	        servletConnection.setAllowUserInteraction(true);  
	        
	        // 开启流，写入XML数据  
	        OutputStream output = servletConnection.getOutputStream();  
	        System.out.println("发送的报文：");  
	        System.out.println(sendStr);  
	        output.write(sendStr.getBytes());  
	        output.flush();  
	        output.close();  
	        
	        // 获取返回的数据  
	        InputStream inputStream = servletConnection.getInputStream();  
	        reader = new BufferedReader(new InputStreamReader(inputStream));  
	        while ((strMessage = reader.readLine()) != null) {  
	           buffer.append(strMessage);  
	        }  
	        String msg = buffer.toString();
	        System.out.println("接收返回值:" + msg);  
	    } catch (java.net.ConnectException e) {  
	        throw new Exception();  
	    } finally {  
	        if (reader != null) {  
	           reader.close();  
	        }  
	    }
		return "";
	}
}
