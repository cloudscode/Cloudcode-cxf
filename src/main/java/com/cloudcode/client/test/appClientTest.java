package com.cloudcode.client.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;

public class appClientTest {

	public static void main(String[] args) {
		String wsdlUrl="http://localhost:8080/com.cloudcode/cxfService/appClient?wsdl";
		 DynamicClientFactory dcf = DynamicClientFactory.newInstance();
		 Client client = dcf.createClient(wsdlUrl);
		Object[] objects;
		 try {
			 objects = client.invoke("LoadAppAll", new Object[]{});
			 Object str = objects[0];
			 System.out.println("Client Test:"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
