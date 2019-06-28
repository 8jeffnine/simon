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

public class GetNewsAsahi {
 public static void main(String[] args) {
	 
	 URL url;
	 URLConnection connection;
	 
	 InputStream is = null;
	 InputStreamReader isr;

	 BufferedReader br;
	 
	 
	 /** 
	  * URL占쏙옙 PARAM占쏙옙 占썼열占쏙옙 占쌍곤옙 占쌥븝옙占싹댐옙 占쏙옙占싸그뤄옙占쏙옙占쏙옙 占쏙옙占쏙옙占�
	  * 
	  */

	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Date now = new Date();
	String itrmDate = df.format(now);
	itrmDate = itrmDate.substring(0, 8);
//	System.out.println(itrmDate);
	 
	 // URL 占쏙옙占쏙옙트
	 String target = "http://news.naver.com/main/tool/print.nhn?oid=020&aid=0002153297";
	 int valueables = 1;
	 
	 // param 占쏙옙 占쏙옙큼 url 占쌥븝옙 占쏙옙占쏙옙
	 for(int i = 0; i < 1 ; i++){
		 try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 // 占쏙옙占시울옙 占쏙옙占쏙옙占쏙옙 占쏙옙占싹몌옙占쏙옙 占쏙옙짜 + param 占싱몌옙占쏙옙占쏙옙 占쏙옙占쏙옙
		 String fileName = "c:\\catch_mi\\" + itrmDate + "_" + valueables + ".html";
		 FileWriter fw = null;
		 File file = new File(fileName);
		 
		 String urllist = target ;
		 valueables++;
	 

	 // 占식띰옙占쏙옙占� 占쏙옙占쏙옙트


	 // 占쏙옙짜占쏙옙占쏙옙
//	DateFormat df = new SimpleDateFormat("yyyyMMdd");
//	Date now = new Date();
//	String itrmDate = df.format(now);
//	itrmDate = itrmDate.substring(0, 8);
	 
	 try{
		 fw = new FileWriter(file);
		 // 占쏙옙占쏙옙占쌍쇽옙 & 占쏙옙占쏙옙
		 // HTTP 431 占쏙옙占쏙옙占쏙옙 占쏙옙占시곤옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쌔쇽옙 占쏙옙 占쏙옙 占쏙옙占쏙옙 (占싹븝옙 PORT占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트占쏙옙 占쏙옙占� PORT 占쏙옙占쏙옙占쏙옙占쏙옙 占쌔결가占쏙옙占싹기도 占쏙옙)
		 url = new URL(urllist);
		 System.out.println(url.openConnection().getPermission());
		 System.out.println(url.getPort());
		 System.out.println(url.getAuthority());

		 connection = url.openConnection();
		 

		 // 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙

		 connection.setRequestProperty("Method", "GET");
		 connection.setRequestProperty("Referer", "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=101");
		 connection.setRequestProperty("Host", "news.naver.com");

//		 connection.setRequestProperty("Accept", "*/*; charset=EUC-JP");
//		 connection.setRequestProperty("Accept-Language","ja-JP,ja;q=0.9");
		 connection.setRequestProperty("Accept", "text/html; charset=EUC-KR");
		 connection.setRequestProperty("Accept-Language","ko-KR");
//		 connection.setRequestProperty("Accept-Language","ja");
		 connection.setRequestProperty("Accept-Encoding","deflate");
//		 connection.setRequestProperty("Accept-Charset","UTF-8");

		 connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.2; WOW64; Trident/6.0; .NET4.0E; .NET4.0C; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729; MASMJS)");
		 connection.setRequestProperty("Connection", "Keep-Alive");
//		 connection.setRequestProperty("Pragma", "no-cache");
//		 connection.setRequestProperty("DNT", "1");
		 connection.setRequestProperty("Cookie","JSESSIONID=5CE0FB7982476B437F188CB4961E81F8; npic=+snQkau+o/keJ6svqmXWSOAZM4j8N7uPOyjJCwJB3uUF8JUSf8R/i7nUjAl4SjpeCA==; NNB=I4AE6IRGYWFFQ; sortType=favorite; page_uid=TKILgspydfNssZDaP74sssssstC-066310; sports.comments.fold=unfold; nid_inf=-1304283342; nx_ssl=2; paneOrderNewsHome=today_main_news%2Ctoday_issue%2Csection_entertainment%2Csection_society%2Csection_politics%2Csection_economy%2Csection_life%2Csection_world%2Csection_it%2Csection_magazine_cast; sLastIdpType=naver; NID_AUT=xhGsGlXtEYUPc3pXuSEWOoczPnoHK4fsQuym6+7SHl+FMoMW1jozJ8YzjV2zhYPe; NID_SES=AAABjdtXuX8Pz0Vp+V5lxRvdaH1IVPK5hZPn34hXzIAyl0tgm9yeGF16guQlj2lLci4LIchF/B/LbYBd+ntlKwmfez3L+tkqH/yqCzfpes5PqZN3vZx5wTTWwputvftbVSFfEqPQxVNKc6p71RRZLZR8dO6U/y26FQilwuULuzfrJY3Xl46LbC17jvAF9KoSbn7kKk8roav22maweb/6hmB+zCdfYFHEC9gmGE9HxJmjWPC8+pJ9IcqUt1Dtv2A8GUjqH2NUuXyiWNczZ5s3zBcvBaJICKknce00iyOmfejnjV8ma3Qm0bm3DuKaQZTPyiVb4mVHFy0KWXV4+Xja8n3/tF335E4b2spAdKHlKh61NSq5uU7GovfKXUUfJ3sqJV+r7mAWKq2laYRTz3HjOvrI4Oom3ucIWRm6TrlcFdb9/rgbfBxOE29xKYVjWSlxJKcOk3qNCZ0FYC48QCoTk94FWTw0rrMExC8O148aWHP7pLgwcj1297/BUfMiUsfFqUZBjRsPfrRqstXGJG2DItCea5c=; _naver_usersession_=fjuoTZJNkOfcaH1qA0B/gA==");
//		 connection.setRequestProperty("If-None-Match","3520d25-9e36-5336a47943b00");
//		 connection.setRequestProperty("Upgrade-Insecure-Requests","1");
//		 connection.setRequestProperty("Cache-Control","max-age=0");

		 

		 
		 
		 // 占쏙옙占쌘듸옙占쏙옙 캐占쏙옙占싶쇽옙 占쏙옙占쏙옙
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
		 // 占쏙옙占시메소듸옙 占쏙옙占�
		 System.out.println("getHeaderField : " + connection.getHeaderField(0)); // HTTP 占쏙옙占쏙옙占쏙옙占쏙옙
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

		 System.out.println("===========================================>>> 占쏙옙占쏙옙");
		 System.out.println("");
		 
		 // 占싻억옙占쏙옙占� 占쌨소듸옙 占쏙옙占쏙옙
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
		 
			// Read for Save
			is = connection.getInputStream();
			isr = new InputStreamReader(is, decCharset);
			br = new BufferedReader(isr);
			
			
			String buf = null;
			
			while(true){
				buf = br.readLine();
				if(buf == null) break;
				
				fw.append(buf);
//				System.out.println(buf);
			}
			
			fw.flush();
		 
		 // 占쏙옙占쏙옙占쏙옙 K占쏙옙 占식쏙옙
		 
	 }catch(MalformedURLException mue){
         System.err.println("占쌩몌옙占쏙옙 URL占쌉니댐옙. 占쏙옙占쏙옙 : java URLConn http://hostname/path]");
         System.exit(1);
         
     }catch(IOException ioe){
         System.err.println("IOException " + ioe);
         ioe.printStackTrace();
         System.exit(1);
     }

 } // for 占쏙옙 占쌥븝옙
	 
 }
}




