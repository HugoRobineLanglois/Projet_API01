package com.UTC.BooksMatching.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.sun.xml.internal.ws.api.ResourceLoader;

public class AppConfigDAO {
	
	private String xmlFile;
	
	public AppConfigDAO(){
		try{
			xmlFile = getClass().getClassLoader().getResource("/xml/conf.xml").toString();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String getAppUrl(){
		String url = new String();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(xmlFile);
			url= dom.getElementsByTagName("appurl").item(0).getTextContent();
	   }catch(SAXException se){
		   System.out.println("Parse exception: "+se.getMessage());
	   }
		catch(IllegalArgumentException iae){
			System.out.println("The file is null");
		}
		catch(IOException ioe){
			System.out.println("An input/output exception: "+ioe.getMessage());
			System.out.println(ioe.getClass().getName());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
	    }
		return url;
	}
	
	public String getAppName(){
		String appName = new String();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(xmlFile);
			appName= dom.getElementsByTagName("appname").item(0).getTextContent();
	   }catch(SAXException se){
		   System.out.println("Parse exception: "+se.getMessage());
	   }
		catch(IllegalArgumentException iae){
			System.out.println("The file is null");
		}
		catch(IOException ioe){
			System.out.println("An input/output exception: "+ioe.getMessage());
			System.out.println(ioe.getClass().getName());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
	    }
		return appName;
	}
	
	public Map<String, String> getMailSettings(){
		Map<String, String> mailSettings  = new HashMap<String, String>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(xmlFile);
			String host = dom.getElementsByTagName("host").item(0).getTextContent();
			String port = dom.getElementsByTagName("port").item(0).getTextContent();
			String email = dom.getElementsByTagName("email").item(0).getTextContent();
			String password = dom.getElementsByTagName("password").item(0).getTextContent();
			String username = dom.getElementsByTagName("username").item(0).getTextContent();
			String protocol = dom.getElementsByTagName("protocol").item(0).getTextContent();
			mailSettings.put("host", host);
			mailSettings.put("port", port);
			mailSettings.put("email", email);
			mailSettings.put("username", username);
			mailSettings.put("password", password);
			mailSettings.put("protocol", protocol);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	    }
		return mailSettings;
	}
	}