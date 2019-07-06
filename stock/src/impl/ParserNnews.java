package impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.News;

/** Expired.. before 2019-05 **/
public class ParserNnews {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		new ParserELM().getHtmlData("C://workspace/mi/src/02.SK_FASHION_MALL.html");
//	}
	public void getHtmlData(final String file_name){
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
			Document doc = Jsoup.parse(input, "UTF-8");

			System.out.println(doc.toString());
			
		/** Parsing Data Select */
			Elements rows = doc.select("ul.srch_list li div.ct a.tit"); // title 
			Elements rows2 = doc.select("ul.srch_list li div.ct p.dsc"); // description
			Elements rows3 = doc.select("ul.srch_list li div.ct div.info span.press"); // press
			Elements rows4 = doc.select("ul.srch_list li div.ct div.info"); //link
			Elements rows5 = doc.select("div.search_tab a.tab_tx"); 
			
			String today_raw = rows5.get(0).attr("href").toString();
			String today = today_raw.substring(today_raw.indexOf("range:")+6, today_raw.indexOf("range:")+14);
			
		/** Data type Select  */
			//String Array
			String[] title = new String[rows.size()];
			String[] content = new String[rows.size()];
			String[] press = new String[rows.size()];
			String[] artiURL = new String[rows.size()];
			
			System.out.println("제목\t\t\t| 내용\t\t\t| 신문사\t\t| 링크URL");
			
			
			// List
			for(int i=0; i<rows.size(); i++){
				
				Iterator<Element> iterElem = null;
				Iterator<Element> iterElem2 = null;
				Iterator<Element> iterElem3 = null;
				
				if(rows4.get(i).getElementsByClass("go_naver").toString().length() > 2){
					artiURL[i] = rows4.get(i).getElementsByClass("go_naver").attr("href") ;
				}else{
					artiURL[i] = rows4.get(i).getElementsByClass("btn_share").attr("data-url") ;
				}
				
				if(rows.get(i) != null) iterElem = rows.get(i).getElementsByTag("a").iterator();
				if(rows2.get(i) != null) iterElem = rows2.get(i).getElementsByTag("p").iterator();
				if(rows3.get(i) != null) iterElem = rows3.get(i).getElementsByTag("span").iterator();
//				if(rows4.get(i) != null) iterElem = rows4.get(i).getElementsByTag("a").attr("href");
				
				String item1 = null;
				String item2 = null;
				String item3 = null;
//				String item4 = null;
				
				if(iterElem.hasNext()) item1 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem2.hasNext()) item2 = new StringBuilder().append(iterElem2.next().text()).toString();
				if(iterElem3.hasNext()) item3 = new StringBuilder().append(iterElem3.next().text()).toString();
//				if(iterElem4.hasNext()) item4 = new StringBuilder().append(iterElem4.next().text()).toString();
				
				
				try {
					title[i] = item1;
					content[i] = item2;
					press[i] = item3;
					
					System.out.println(title[i].substring(0, 12) + "\t| " + content[i].substring(0,12) + "\t| " + press[i] + "\t\t| " + artiURL[i] );
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		/** Parsing END */

			
		/** DB insert & update */
			MainServiceImplDAO midao = new MainServiceImplDAO();
			
			for(int g=0; g<title.length; g++){
				News dto = new News();
					dto.setPubDate(today);
					dto.setTitle(title[g]);
					dto.setContent(content[g]);
					dto.setPress(press[g]);
					dto.setArtiURL(artiURL[g]);
				
				List<News> cntList = midao.selectData("mkt.selectNewsExist", dto);
				if( cntList.get(0).getSeq() > 0){
					midao.updateData("mkt.updateNewsInfo", dto);
				}else{
					midao.insertData("mkt.insertNewsInfo", dto);
				}
				
			}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
