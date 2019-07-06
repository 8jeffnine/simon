package impl;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * ssl 적용하여 데이터 가져오기 
 */
public class CrawlerHtml {
 public static void main(String[] args) {
	 

	 
	// Properties Loading
	InputStream inputStream;
	Properties prop = new Properties();
//	String propFileName = "c:\\config.properties";
//	
//	inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//	
//	try{
//		if (inputStream != null) {
//			prop.load(inputStream);
//		} else {
//			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
//		}
//	}catch(Exception e){
//		e.printStackTrace();
//	}
//	
	Date time = new Date(System.currentTimeMillis());
	
	// Setting : File Path
//	String file_path = prop.getProperty("path.fileSave");
//	String file_path = "C:\\catch_mi\\";
//	String file_name = fileName; 
	
	FileWriter fw = null;
	
 

	// repeat crawlering until lastPageIndex
	for(int i = 1; i <= 1 ; i++){
		// Setting : URL Connection
		URL url;
		URLConnection connection;
		 
		InputStream is = null;
		InputStreamReader isr;
		
		BufferedReader br;
		
		long startTime = System.currentTimeMillis();
		
//		String setUrl = "https://media.daum.net/cp/7?page=14&regDate=20190506";

//				String setUrl = "https://news.v.daum.net/v/a0ssa2Akhv";
//				String setUrl = "https://entertain.v.daum.net/v/ayPXymCCpY";
		
//		String setUrl = "https://news.naver.com/main/list.nhn?mode=LPOD&mid=sec&oid=009&listType=paper&date=20190523&page=1";
		String setUrl = "https://finance.naver.com/item/sise_day.nhn?code=005930&page=2";
		
	 try{
//		 File file = new File(file_path + Integer.toString(i) + file_name);
//		 fw = new FileWriter(file);
		 
		 url = new URL(setUrl);
		 System.out.println("permission : " + url.openConnection().getPermission().getName());
//		 System.out.println("port : " + url.getPort());
		 System.out.println("defaultPort : " + url.getDefaultPort());
//		 System.out.println("authority : " + url.getAuthority());
//		 System.out.println(url.getProtocol());
//		 System.out.println(url.getHost());
//		 System.out.println(url.getPath());
//		 System.out.println(url.getFile());
//		 System.out.println(url.getRef());
//		 System.out.println(url.getUserInfo());

		 connection = url.openConnection();
		 System.out.println("getDoInput : " + connection.getDoInput());
		 System.out.println("getAllowUserInteraction : " + connection.getAllowUserInteraction());
		 System.out.println("getDoOutput : " + connection.getDoOutput());
		 

		 // Setting : Http Request Header 
if(setUrl.indexOf("naver") > -1){
 connection.setRequestProperty("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
 connection.setRequestProperty("accept-encoding","deflate");
 connection.setRequestProperty("accept-language","ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,ja;q=0.6");
 connection.setRequestProperty("cache-control","max-age=0");
		 connection.setRequestProperty("Connection","keep-alive");
 connection.setRequestProperty("cookie","JSESSIONID=BBB67A8273E27F0F1DCFD67FBAE98033; NNB=DW54EPQHU7UFY; nid_inf=1665362481; NID_AUT=cN5Pa0Xf1p71+vDKRMn8MBxoUG03SgDOG2bZ9+eMZLe7ppyOH94s9l8gmev9CP+I; NID_JKL=BJw9uI4jOrDY/4vrDvSEzlGdhcBEFKlczyoTfeWLIDc=; NID_SES=AAABiB+7D3QKQpQgr34NTZ/FPP1yBtffhqYBGgD4GxJ8QOpO8tGspdaxpurCHh3uP3Gux4djn2FfwYPD3mBQJyQMus8v4UyRGhaKBeqpbwOG8svzDBFBPk5O3do0gR8oZe1K9Wam8dKL049o+XRkA66kvpRCTByFIuBii+Twz4cnPitNtzqblL6lgZ0EO3oxX6ADretzBA9fxJqUVD/B966PNY3A9RlbSD6oRNMhrrbF5hnFfnDsEXFm1ppaTKA9knKd9A0IV7TzJ5e2XjKNnaRvccMsGQO8pksNHrZ06yJ4u2PAsDtOT6uiZ7FEo4u9xIhofCKo4MQqS8Y5ilYNH0XxzayS5aM2yJ1EizKXfA41Hpvnry6yFA3aE9mbFQx3cvRRY21t4/loaObcB1DjlHg2gkWxGxpxEBOtb+ZP9sapdI/VUntFePk7rKUxnjR0jfARK1W4y3q/wvtBi/TFSQYiktnFK28vOlnXpj9WkWHtMdhrKIolsMNg30ti1mGc541F4FPirclSP5beAvzwZ+gvIk4=; sports.comments.fold=unfold; page_uid=UMCVSwpp6DKssBMbs10ssssssvl-158126; _naver_usersession_=9qWjFRMjtJLKNYIrMd8pXQ==");
 connection.setRequestProperty("dnt","1");
		 connection.setRequestProperty("Host","news.naver.com");
 connection.setRequestProperty("referer","https://news.naver.com/main/list.nhn?mode=LPOD&mid=sec&oid=009&listType=paper&date=20190523&page=1");
 connection.setRequestProperty("upgrade-insecure-requests","1");
 connection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
 
}else if(setUrl.indexOf("daum") > -1){
 connection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
// connection.setRequestProperty("Accept-Encoding","gzip, deflate, br");
 connection.setRequestProperty("Accept-Encoding","deflate");
 connection.setRequestProperty("Accept-Language","ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,ja;q=0.6");
 connection.setRequestProperty("Cache-Control","max-age=0");
 connection.setRequestProperty("Connection","keep-alive");
 connection.setRequestProperty("DNT","1");
// connection.setRequestProperty("Cookie","webid=5d801330a2354905a925ebb27673b6db; ssab=784_1; GS_font_size=17; VIEW_TTS=undefined_undefined; TIARA=kLySF1MwHO8AWEL4-7GrKZVq2WzkebW6eNuYvUTemumfbHVXCDujXltoMMm6Uiw-UML4CnSBSJFxRaRAhp.7GvIRW7zrOk9P; harmony_view_access_dt=1558709906158; webid_sync=1558709907520");
// connection.setRequestProperty("Host","entertain.v.daum.net");
// connection.setRequestProperty("Referer","https://entertain.v.daum.net/v/ayPXymCCpY");
 connection.setRequestProperty("Upgrade-Insecure-Requests","1");
 connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
 
 
// connection.setRequestProperty("Cookie","webid=5d801330a2354905a925ebb27673b6db; ssab=784_1; harmony_view_access_dt=1558710214591; GS_font_size=17; VIEW_TTS=undefined_undefined; TIARA=NFkEDOB2EPRZZ_IrgVTEMZ7QVLJYDOCrn1UuuKJwSdOgboDlPGPYEkP_8hnaIe2NpABpFR5_HEaCh1R1HzwZ2Hqv7Qy7x8i6; webid_sync=1558710222403");
// connection.setRequestProperty("Host","news.v.daum.net");
// connection.setRequestProperty("Referer","https://media.daum.net/cp/7?page=12&regDate=20190506");
 
 connection.setRequestProperty("Cookie","webid=5d801330a2354905a925ebb27673b6db; ssab=784_1; TIARA=NFkEDOB2EPRl18Hj3G2Bw9qEWvmDq__kg.vlQ1m9bc8_-uhhr9ji59ml9kyFzEkm4Kq3xWf6PP1GYCB1wpXDGANp2xo9z82V; webid_sync=1558710332675");
 connection.setRequestProperty("Host","media.daum.net");
 connection.setRequestProperty("Referer","https://media.daum.net/cp/7?page=14&regDate=20190506");
			 
}
// String keyStore = "C:\\java\\jdk1.6.0\\jre\\lib\\security\\cacerts";
//		 String keyStore = "C:\\Users\\today is present\\naver.cer";
//		 String keyStore = "C:\\Users\\today is present\\kakao.cer";

/** 공통영역으로 이동 필요 */
/** ssl 키 관련으로 사이트, 사이트별 적용여부, 파일위치, id 로 데이터 관리 */
 String keyStore = "c:\\java\\jdk1.6.0\\jre\\lib\\security\\cacerts";
//System.setProperty("javax.net.ssl.trustStore", keyStore );
 System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
 System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
 Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

 
//Security.addProvider( (Provider)Class.forName("com.sun.crypto.provider.SunJCE").newInstance());
	   

 
 // Setting : Charset for FileSave
		 String charset = null;
		 String decCharset = null;
		 
		 if( connection.getContentType() != null ){
			 charset = (String)connection.getContentType();
			 if(charset.indexOf("=") > -1){
				 decCharset = charset.substring(charset.indexOf("=")+1);
			 }else{
				 decCharset = "euc-kr";	//fashionplus
//				 decCharset = "UTF-8";
			 }
		 }else{
//				 decCharset = "UTF-8";
			 decCharset = "euc-kr";
		 }
		 
		 
		 // Result
		 if(connection.getHeaderFields().size() > 0){
			 for(int f=0; f<connection.getHeaderFields().size(); f++){
				 System.out.println("getHeaderField : " + connection.getHeaderField(f));
			 }
			 
		 }else{
			 System.out.println("getHeaderField : " + connection.getHeaderField(0));
			 System.out.println("getHeaderField : " + connection.getHeaderField(0));
			 System.out.println("getHeaderField : " + connection.getHeaderField(0));
		 }
		  

		 
		 
//		 System.out.println("===========================================>>> HTTP CODE 200 ");
		 System.out.println("");
		 System.out.println(connection.getContentLength() );
		 // Save : Http -> File
		 is = connection.getInputStream();
		 isr = new InputStreamReader(is,decCharset);
		 br = new BufferedReader(isr);
		 
		 String buf = null;

		 while(true){
			 buf = br.readLine();
			 if(buf == null) break;
			 
//			 fw.append(buf);			// 
			 System.out.println(buf);	// 
		 }
		 
	 }catch(MalformedURLException mue){
         System.err.println("Error : HTTP CODE 400 ");
//         CrawlerHtml crw = new CrawlerHtml();
//         port++;
//   			crw.main(null);
//         System.exit(1);
         
     }catch(IOException ioe){
         System.err.println("IOException " + ioe);
         ioe.printStackTrace();
//         port++;
//         CrawlerHtml crw = new CrawlerHtml();
//  			crw.main(null);
//         System.exit(1);
     }finally{
    	
     }

	 System.out.println("access time == " + i);
	 System.out.println(System.currentTimeMillis() - startTime);
	 System.out.println("");
	} // end-for

 }// end-getHtml
	 
}