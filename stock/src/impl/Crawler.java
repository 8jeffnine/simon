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
import java.security.Security;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.HttpItem;

public class Crawler {
	public static void main(String[] args) {

	}

	public void getHTMLFile(String input_url, String file_path, String file_name, Object httpItem) {

		URL url;
		URLConnection connection;
		InputStream is = null;
		InputStreamReader isr;
		BufferedReader br;

		// Url Setting
		String url_path = input_url;
		System.out.println("=====>> " + url_path);
		
		// FileName Setting
		String fileName = file_name;
		
		FileWriter fw = null;
		File file = new File(file_path + fileName);
		
		// Date Info
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String today = df.format(now);
		today = today.substring(0, 8);
		
		try{
			fw = new FileWriter(file);
			url = new URL(url_path);
			
			// Proxy setting needed
//			System.getProperties().put("http.proxyHost", "71.100.103.80");
//			System.getProperties().put("http.proxyPort", "8080");
			// Check Proxy setting available
//			System.out.println(url.openConnection().getPermission());
//			System.out.println(url.getPort());
//			System.out.println(url.getAuthority());
			
			 connection = url.openConnection();
			 System.out.println("getDoInput : " + connection.getDoInput());
			 System.out.println("getAllowUserInteraction : " + connection.getAllowUserInteraction());
			 System.out.println("getDoOutput : " + connection.getDoOutput());
			
			// Http Request Header setting
			// Each site's requirements are different
			List<HttpItem> hItem = new ArrayList<HttpItem>();
				hItem = (List<HttpItem>) httpItem;
/**			
			if(hItem.get(0).getMethod() != null) connection.setRequestProperty("Method", hItem.get(0).getMethod() );
			if(hItem.get(0).getAccept()!= null) connection.setRequestProperty("Accept", hItem.get(0).getAccept() );
			if(hItem.get(0).getA_encoding() != null) connection.setRequestProperty("Accept-Encoding", hItem.get(0).getA_encoding() );
			if(hItem.get(0).getA_lang() != null) connection.setRequestProperty("Accept-Language", hItem.get(0).getA_lang() );
			if(hItem.get(0).getCache() != null) connection.setRequestProperty("Cache-Control", hItem.get(0).getCache() );
			if(hItem.get(0).getHost() != null) connection.setRequestProperty("Host", hItem.get(0).getHost() );
			if(hItem.get(0).getReferer() != null) connection.setRequestProperty("Referer", hItem.get(0).getReferer() );
			if(hItem.get(0).getOrigin() != null) connection.setRequestProperty("Origin", hItem.get(0).getOrigin() );
			if(hItem.get(0).getProxy() != null) connection.setRequestProperty("Proxy-Connection", hItem.get(0).getProxy() );
			if(hItem.get(0).getUpgrade() != null) connection.setRequestProperty("Upgrade-Insecure-Requests", hItem.get(0).getUpgrade() );
			if(hItem.get(0).getX_requested() != null) connection.setRequestProperty("x-requested-with", hItem.get(0).getX_requested() );
			if(hItem.get(0).getCookie() != null) connection.setRequestProperty("Cookie", hItem.get(0).getCookie() );
			
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
*/
		if(url_path.indexOf("naver") > -1){
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
			 
			}else if(url_path.indexOf("daum") > -1){
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
				
			// SSL setting
			String keyStore = "C:\\Program Files\\ojdkbuild\\java-1.8.0-openjdk-1.8.0.191-1\\jre\\lib\\security\\cacerts";
			//System.setProperty("javax.net.ssl.trustStore", keyStore );
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		 
			// File setting for Download
			// Charset, decCharset
			String charset = null;
			String decCharset = null;
			
			if( connection.getContentType() != null ){
				charset = (String)connection.getContentType();
				
				if(charset.indexOf("=") > -1){
					decCharset = charset.substring(charset.indexOf("=")+1);
				}else{
					decCharset = "UTF-8";
				}
			}
			System.out.println("decCharset == " + decCharset);
			
			// Review Http Request Header
			for(int i=0; i < 6; i++){
				System.out.println("getHeaderField : " + connection.getHeaderField(i));
			}
//			System.out.println("getContentEncoding : " + connection.getContentEncoding());
//			System.out.println("getContentLength : " + connection.getContentLength());
//			System.out.println("getContentType : " + connection.getContentType());
//			System.out.println("getDoInput : " + connection.getDoInput());
//			System.out.println("getDoOutput : " + connection.getDoOutput());
//			System.out.println("getExpiration : " + connection.getExpiration());
//			
//			System.out.println("getFileNameMap : " + connection.getFileNameMap() );
//			System.out.println("getHeaderField : " + connection.getHeaderField("") );
//			System.out.println("getPermission : " + connection.getPermission() );
//			System.out.println("getRequestProperties : " + connection.getRequestProperty("accept") );
			
			System.out.println("=========================>>>> START ");
			System.out.println("");
			

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
			
			
		}catch(MalformedURLException mue){
			System.err.println("PATH is not correct");
			System.exit(1);
		}catch(IOException ioe){
			System.err.println("IOException " + ioe);
			ioe.getCause();
			ioe.printStackTrace();
			System.exit(1);
			
		}
		
	}// end-getHtml

}