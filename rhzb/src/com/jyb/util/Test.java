package com.jyb.util;

public class Test {
	public static void main(String[] args) {
		
		 IdcardInfoExtractor idcardInfo=new IdcardInfoExtractor("360732199702102370");  
	        System.out.println("出生日期:"+idcardInfo.getYear()+"-"+idcardInfo.getMonth()+"-"+idcardInfo.getDay());  
	        System.out.println("性别:"+idcardInfo.getGenderId());  
	        System.out.println("年龄:"+idcardInfo.getAge());  
	        System.out.println("省份:"+idcardInfo.getProvince()); 
	        
	        
	        //如果查询出来的结果为null，身份证校验不通过
		//
		/**
		 *15位身份证，第15位奇数为男，偶数为女
		 *18位身份证   第17为奇数为男，偶数为女
		 * */
	/*	String id ="360732199702102370";
		
		String birth = id.substring(6, 14);
		
		String sex = id.substring(16, 17);
		if(Integer.parseInt(sex)%2==0){
			sex = "女";
		}else{
			sex ="男";
			
		}
		System.err.println("生日："+birth+"性别"+sex);*/
		
		//Test test=new Test();
	        
	     /* String str="1252018521@qq.com";
	      int leng=str.length();
	      int beginIndex = str.indexOf("@");
	      String test=str.substring(0,3)+"****"+str.substring(beginIndex,leng-0);
		System.out.println(beginIndex+"||||"+test);*/
		
	System.out.println((int)((Math.random()*9+1)*100000));  
	
	String str="您好！\n\n您收到该信息，是由于在 【众易贷】 (http://localhost:8080/rhzb/user/personal)\n进行了新用户注册，或修改账户信息时，需要通过这个邮箱地址进行验证。如果您并没有访问过 【众易贷】，或没有进行上述操作，请忽略这封邮件。您不需要退订或进行其他进一步的操作。\n\n您的本次操作的验证码为\n----------------------------------------------------------------------\n"+123456+"\n----------------------------------------------------------------------\n请注意：该验证码将在15分钟后失效，请尽快验证！";
	System.out.println(str);
	}
	
	
	
	
}
