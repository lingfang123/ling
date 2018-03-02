package com.yzf.util;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class CodeSMS {
	public void code(String phone,String context) throws HttpException, IOException{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://api.sms.cn/sms/"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
		NameValuePair[] data ={ 
				new NameValuePair("uid", "send"),
				new NameValuePair("uid", "ling123"),
				new NameValuePair("pwd", "98a93984d230ba849a9986fe29a09322"),
				new NameValuePair("mobile",phone),
				new NameValuePair("content",context)};
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8")); 
		System.out.println(result); //打印返回消息状态
		post.releaseConnection();
	}
}
