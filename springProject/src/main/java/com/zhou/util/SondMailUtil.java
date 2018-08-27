package com.zhou.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 
 * @author Mr_zhou
 * 2018年8月13日 下午11:15:54
 * TODO QQ邮箱多收件人邮件demo
 * maven依赖
 *  <dependency>
	    <groupId>javax.mail</groupId>
	    <artifactId>mail</artifactId>
	    <version>1.5.0-b01</version>
	</dependency>
 */
public class SondMailUtil
{
	 // 发件人电子邮箱
		static String from = "871003310@qq.com";
		static String pass = "ieegdofrcdpvbdfc";

	    // 指定发送邮件的主机为 smtp.qq.com
		static String host = "smtp.qq.com";  //QQ 邮件服务器
	    
	    public static void sondMail(String to[],String title,String msg) throws GeneralSecurityException
	    {
	    	 // 获取系统属性
	        Properties properties = System.getProperties();

	        // 设置邮件服务器
	        properties.setProperty("mail.smtp.host", host);

	        properties.put("mail.smtp.auth", "true");
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	        // 获取默认session对象
	        Session session = Session.getDefaultInstance(properties,new Authenticator(){
	            public PasswordAuthentication getPasswordAuthentication()
	            {
	                return new PasswordAuthentication(from, pass);
	            }
	        });

	        try{
	            // 创建默认的 MimeMessage 对象
	            MimeMessage message = new MimeMessage(session);

	            // Set From: 头部头字段
	            message.setFrom(new InternetAddress(from));

	            // Set To: 头部头字段
	            InternetAddress[] sendTo = new InternetAddress[to.length];  
	            for (int i = 0; i < to.length; i++) {  
	                System.out.println("发送到:" + to[i]);  
	                sendTo[i] = new InternetAddress(to[i]);  
	            } 
	            message.addRecipients(Message.RecipientType.TO, sendTo);

	            // Set Subject: 头部头字段
	            message.setSubject(title);

	            // 设置消息体
	            message.setText(msg);

	            // 发送消息
	            Transport.send(message);
	            System.out.println("发送邮件ok--------->");
	        }catch (MessagingException mex) {
	            mex.printStackTrace();
	            System.out.println("发生异常-------------->"+mex);
	        }
	    }
	    
	    
	    public static void main(String [] args) throws GeneralSecurityException 
	    {
	    	String tos[]= {"871003310@qq.com"};
	    	sondMail(tos,"------标题-----","主体信息");
	    }
}
