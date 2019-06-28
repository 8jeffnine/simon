package impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNewsYomiuri {
 public static void main(String[] args) {
	 
	 URL url;
	 URLConnection connection;
	 
	 InputStream is = null;
	 InputStreamReader isr;

	 BufferedReader br;
	 
	 
	 /** 
	  * URL�뜝�룞�삕 PARAM�뜝�룞�삕 �뜝�띁�뿴�뜝�룞�삕 �뜝�뙇怨ㅼ삕 �뜝�뙠釉앹삕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�떥洹몃쨪�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝占�
	  * 
	  */

	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Date now = new Date();
	String itrmDate = df.format(now);
	itrmDate = itrmDate.substring(0, 8);
//	System.out.println(itrmDate);
	 
	 // URL �뜝�룞�삕�뜝�룞�삕�듃
	 String target = "http://www.yomiuri.co.jp/economy";
	 int valueables = 1;
	 
	 // param �뜝�룞�삕 �뜝�룞�삕�겮 url �뜝�뙠釉앹삕 �뜝�룞�삕�뜝�룞�삕
	 for(int i = 0; i < 1 ; i++){
		 try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 // �뜝�룞�삕�뜝�떆�슱�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�룞�삕吏� + param �뜝�떛紐뚯삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
		 String fileName = "D:\\Yominuri_Business_" + itrmDate + "_" + valueables + ".txt";
		 FileWriter fw = null;
		 File file = new File(fileName);
		 
		 String urllist = target ;
		 valueables++;
	 

	 // �뜝�떇�씛�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�듃


	 // �뜝�룞�삕吏쒎뜝�룞�삕�뜝�룞�삕
//	DateFormat df = new SimpleDateFormat("yyyyMMdd");
//	Date now = new Date();
//	String itrmDate = df.format(now);
//	itrmDate = itrmDate.substring(0, 8);
	 
	 try{
		 fw = new FileWriter(file);
		 // �뜝�룞�삕�뜝�룞�삕�뜝�뙇�눦�삕 & �뜝�룞�삕�뜝�룞�삕
		 // HTTP 431 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�떆怨ㅼ삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�뙏�눦�삕 �뜝�룞�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 (�뜝�떦釉앹삕 PORT�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�듃�뜝�룞�삕 �뜝�룞�삕�뜝占� PORT �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�뙏寃곌��뜝�룞�삕�뜝�떦湲곕룄 �뜝�룞�삕)
		 url = new URL(urllist);
		 System.out.println(url.openConnection().getPermission());
		 System.out.println(url.getPort());
		 System.out.println(url.getAuthority());

		 connection = url.openConnection();
		 

		 // �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕

		 connection.setRequestProperty("Method", "GET");
//		 connection.setRequestProperty("Host", "www.yahoo.co.jp");
		 connection.setRequestProperty("Host", "www.yomiuri.co.jp");

//		 connection.setRequestProperty("Accept", "*/*; charset=EUC-JP");
//		 connection.setRequestProperty("Accept-Language","ja-JP,ja;q=0.9");
		 connection.setRequestProperty("Accept", "*/*; charset=UTF-8");
		 connection.setRequestProperty("Accept-Language","ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
//		 connection.setRequestProperty("Accept-Language","ja");
		 connection.setRequestProperty("Accept-Encoding","x-gzip, deflate");
//		 connection.setRequestProperty("Accept-Charset","UTF-8");

		 connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.2; WOW64; Trident/6.0; .NET4.0E; .NET4.0C; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729; MASMJS)");
		 connection.setRequestProperty("Connection", "Keep-Alive");
//		 connection.setRequestProperty("Pragma", "no-cache");
		 connection.setRequestProperty("DNT", "1");
		 connection.setRequestProperty("Cookie","OX_sd=1; OX_plg=pm; ASAHISEG=AS0%3D60159/AS1%3D52802/AS2%3D46210/AS3%3D62058/AS4%3D46236/AS5%3D46460/AS6%3D46742/AS7%3D62049/AS8%3D61877/AS9%3D55792/AS10%3D58449/AS11%3D61466/AS12%3D46215/; AONEU=true; tuuid=b17644c6-d7bf-4490-a713-39ac446ec083; s_cc=true; s_fid=2A78044FFAAE8675-3B94441B33D9B538; s_nr=1463920219132-New; sc_fst_vi=VyYBIMMnioEqt1Qf9jao; sc_clk_btn=no%20value; sc_prv_mp=nm; sc_prv_crs=nm; s_pnum=http%3A%2F%2Fwww.asahi.com%2Fbusiness%2F%26s_vn%3D1%26non_tgt%3D1; s_lv=1463920214766; s_lv_s=First%20Visit; sc_ppv_pagename=%2Fbusiness%2Findex.html%5Bwww.asahi.com%5D; s_sq=%5B%5BB%5D%5D; sync_af=1; digital_fontsize=100; __utma=261975709.1493773360.1463920208.1463920208.1463920208.1; __utmb=261975709.1.10.1463920218; __utmc=261975709; __utmz=261975709.1463920218.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; s_ppv=21; sc_crs=nm; sc_m_attr=s_uk%3Ab_uk");
		 connection.setRequestProperty("If-None-Match","3520d25-9e36-5336a47943b00");
//		 connection.setRequestProperty("Upgrade-Insecure-Requests","1");
//		 connection.setRequestProperty("Cache-Control","max-age=0");

		 

		 
		 
		 // �뜝�룞�삕�뜝�뙓�벝�삕�뜝�룞�삕 罹먨뜝�룞�삕�뜝�떢�눦�삕 �뜝�룞�삕�뜝�룞�삕
		 String charset = null;
		 String decCharset = null;
		 
		 if( connection.getContentType() != null ){
			 charset = (String)connection.getContentType();
			 if(charset.indexOf("=") > -1){
				 decCharset = charset.substring(charset.indexOf("=")+1);
			 }else{
//				 decCharset = "euc-kr";	//fashionplus
//				 decCharset = "EUC-JP";
				 decCharset = "UTF-8";
			 }
		 }
		 
		 System.out.println("decCharset == " + decCharset);
		 // �뜝�룞�삕�뜝�떆硫붿냼�벝�삕 �뜝�룞�삕�뜝占�
		 System.out.println("getHeaderField : " + connection.getHeaderField(0)); // HTTP �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		 System.out.println("getHeaderField : " + connection.getHeaderField(1)); 
		 System.out.println("getHeaderField : " + connection.getHeaderField(2)); 
		 System.out.println("getHeaderField : " + connection.getHeaderField(3)); 
		 System.out.println("getHeaderField : " + connection.getHeaderField(4)); 
		 System.out.println("getHeaderField : " + connection.getHeaderField(5)); 
		 System.out.println("getHeaderField : " + connection.getHeaderField(6)); 
		 
		 System.out.println("getContent :  " + connection.getContent());
		 System.out.println("getContentEncoding :  " + connection.getContentEncoding());
		 System.out.println("getContentLength :  " + connection.getContentLength());
		 System.out.println("getContentType :  " + connection.getContentType());
		 System.out.println("getDoInput :  " + connection.getDoInput());
		 System.out.println("getDoOutput :  " + connection.getDoOutput());
		 System.out.println("getExpiration :  " + connection.getExpiration());
		 System.out.println("getFileNameMap :  " + connection.getFileNameMap());
		 System.out.println("getHeaderField :  " + connection.getHeaderField(""));
		 System.out.println("getInputStream :  " + connection.getInputStream());
		 System.out.println("getPermission :  " + connection.getPermission());
		 System.out.println("getRequestProperties :  " + connection.getRequestProperty("accept"));
		 System.out.println("getURL :  " + connection.getURL());

		 System.out.println("===========================================>>> �뜝�룞�삕�뜝�룞�삕");
		 System.out.println("");
		 
		 // �뜝�떩�뼲�삕�뜝�룞�삕�뜝占� �뜝�뙣�냼�벝�삕 �뜝�룞�삕�뜝�룞�삕
		 is = connection.getInputStream();
		 isr = new InputStreamReader(is,decCharset);
		 
//		 System.out.println("jp : " + new BufferedReader(new InputStreamReader(is,"euc-jp")).readLine());
//		 System.out.println("kr : " + new BufferedReader(new InputStreamReader(is,"euc-kr")).readLine());
//		 System.out.println("utf8 : " + new BufferedReader(new InputStreamReader(is,"utf-8")).readLine());
//		 System.out.println("utf16 : " + new BufferedReader(new InputStreamReader(is,"utf-16")).readLine());
//		 System.out.println("Shift-JIS : " + new BufferedReader(new InputStreamReader(is,"Shift-JIS")).readLine());
		 
		 System.out.println("==========================");
//		 System.out.println("utf8 : " + new BufferedReader(new InputStreamReader(is,"utf-8")).readLine());
//		 System.out.println("utf16 : " + new BufferedReader(new InputStreamReader(is,"utf-16")).readLine());
		 
		 br = new BufferedReader(isr);
		 
		 
		 // �솕�뜝�띂�뿉 �뜝�룞�삕�뜝占�
		 String buf = null;
		 String temp = null;
		 
		 while(true){
			 buf = br.readLine();
//			 System.out.println(buf);
			 if(buf == null) break;
			 // 
			 if( (buf.indexOf("<a href=\"http://www.yomiuri.co.jp/economy/") > -1) && (buf.indexOf(".html") > -1) ){
			 temp = buf;
//			 System.out.println(temp.indexOf("<a href=\"/articles/")+","+temp.indexOf(".html"));
			 if(temp.indexOf(".html") > temp.indexOf("<a href=\"http://www.yomiuri.co.jp/economy/")) fw.append(buf.substring(temp.indexOf("<a href=\"http://www.yomiuri.co.jp/economy/")+9, temp.indexOf(".html")+5)+";;");			// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
			 
			 }
			 System.out.println(buf);	// �뜝�뙟�눦�삕
		 }
		 
		 // �뜝�룞�삕�뜝�떦琉꾩삕 �뜝�룞�삕�뜝�룞�삕(�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕)
		 fw.flush();
		 
		 // �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 K�뜝�룞�삕 �뜝�떇�룞�삕
		 
	 }catch(MalformedURLException mue){
         System.err.println("�뜝�뙥紐뚯삕�뜝�룞�삕 URL�뜝�뙃�땲�뙋�삕. �뜝�룞�삕�뜝�룞�삕 : java URLConn http://hostname/path]");
         System.exit(1);
         
     }catch(IOException ioe){
         System.err.println("IOException " + ioe);
         ioe.printStackTrace();
         System.exit(1);
     }

 } // for �뜝�룞�삕 �뜝�뙠釉앹삕
	 
 }
}

