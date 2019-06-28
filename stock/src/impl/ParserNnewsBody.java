package impl;

import impl.MainServiceImplDAO;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.News;


public class ParserNnewsBody {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ParserNnewsBody().getHtmlData("C://catch_mi//20170405_1.html", "EUC-KR");
	}
	public void getHtmlData(final String file_name, final String file_Encoding){
		
		String fileEncoding = file_Encoding;
		String fileName = file_name;

		
		/**
		 * Naver News Parser
		 * 1. title
		 * 2. content
		 * 3. press
		 * 
		 */
		try{
	
		/** File Load  */
			File input = new File(fileName);
			Document doc = Jsoup.parse(input, fileEncoding);

//			System.out.println(doc.toString());
			
		/** Parsing Data Select */
			Elements rows = doc.select("div.article_body"); // title
//			Elements rows2 = doc.select("ul.type13 li dl dt a"); // link url
//			Elements rows3 = doc.select("div.list_body div.view_type a"); // link url
//			Elements rows3 = doc.select("ul.srch_list li div.ct div.info span.press"); // press
//			Elements rows4 = doc.select("ul.srch_list li div.ct div.info"); //link
			
//			System.out.println("#1 : " +rows.toString());
//			System.out.println("#2 : " +rows2.toString());
//			Elements rows5 = doc.select("div.search_tab a.tab_tx"); 
//			String today_raw = rows5.get(0).attr("href").toString();
//			String today = today_raw.substring(today_raw.indexOf("range:")+6, today_raw.indexOf("range:")+14);
			
		/** Data type Select  */
			//String Array
			String[] title = new String[rows.size()];
			String[] artiURL = new String[rows.size()];
			String oid = "";
			String aid = "";
			String date = "";
			
			System.out.println("제목\t\t\t| 날짜\t\t\t| 링크URL");
			
			
			// List
			for(int i=0; i<rows.size(); i++){
				
				Iterator<Element> iterElem = null;
				Iterator<Element> iterElem2 = null;
				
				if(rows.get(i) != null) iterElem = rows.get(i).getElementsByTag("div").iterator();
//				if(rows.get(i) != null) iterElem2 = rows2.get(i).getElementsByTag("a").iterator();
				
				String item1 = null;
//				String item2 = null;
				
				if(iterElem.hasNext()) item1 = new StringBuilder().append(iterElem.next().text()).toString();
//				if(iterElem2.hasNext()) item2 = new StringBuilder().append(iterElem2.next().text()).toString();
				
				
				try {
					// title = news title, artiURL = news url
					title[i] = item1;
					// oid = news_comp_code, aid = ariticle sequence
//					oid = rows2.get(i).toString().substring(rows2.get(i).toString().indexOf("oid=")+4, rows2.get(i).toString().indexOf("oid=")+7);
//					aid = rows2.get(i).toString().substring(rows2.get(i).toString().indexOf("aid=")+4, rows2.get(i).toString().indexOf("aid=")+14);
					artiURL[i] = "http://news.naver.com/main/tool/print.nhn?oid="+oid+"&aid="+aid;
					
//					int v_start = rows3.get(0).toString().indexOf("date=")+5;
//					date = rows3.get(0).toString().substring(v_start, v_start+8); 
							
					System.out.println(oid+"\t| "+date+"\t| "+title[i]+"\t| "+artiURL[i]);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		/** Parsing END */
//			System.out.println("====> save starting .....");
			
		/** DB insert & update */
			MainServiceImplDAO midao = new MainServiceImplDAO();
			
			for(int g=0; g<title.length; g++){
				// null row를 skip 하기 위한 방법 고민중
				// data => [] 대신에 data => list 로 하여 null data를 skip 할 수 있을듯
				if(title[g].trim().length() > 1 && !title[g].equals("") && artiURL[g].trim().length() > 1 && !artiURL[g].equals("") && oid != null && !oid.equals("")){
				News dto = new News();
					dto.setTitle(title[g]);
					dto.setPress(oid);
					dto.setArtiURL(artiURL[g]);
					dto.setDate(date);
				
//				List<News> cntList = midao.selectData("mkt.selectNewsExist", dto);
//				if( cntList.get(0).getSeq() > 0){
//					midao.updateData("mkt.updateNewsInfo", dto);
//				}else{
//					midao.insertData("mkt.insertNewsInfo", dto);
//				}
					
//				midao.insertData("mkt.insertNewsInfo", dto);
				}
			}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
