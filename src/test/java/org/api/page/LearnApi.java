package org.api.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LearnApi {
 public static void main(String[] args) {
	 try {
		URL url= new URL("https://reqres.in/api/users?page=2");
		HttpURLConnection openConnection = (HttpURLConnection)url.openConnection();
		openConnection.setRequestMethod("GET");
		String responseMessage = openConnection.getResponseMessage();
		int responseCode = openConnection.getResponseCode();
		System.out.println(responseMessage +  responseCode);
		InputStream inputStream = openConnection.getInputStream();
		InputStreamReader ISR=new InputStreamReader(inputStream);
		BufferedReader BR= new BufferedReader(ISR);
		StringBuffer SB= new StringBuffer();
		String line;
		while ((line= BR.readLine())!=null) {
			  SB.append(line);

		}System.out.println(SB);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
