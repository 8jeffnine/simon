package impl;

import java.io.File;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.StkPrcMt;


public class PsStockPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new PsStockPrice().getHtmlData("C:\\catch_mi\\20190608\\","EUC-KR");
	}
	public void getHtmlData(final String dirPath, final String fileEncoding){
		
		/** Data type Select  */
		//String Array
		String[] co_cd, co_nm; 
		String compcd = "";
		
		/**
		 * Naver Finance - Stock Price
		 * 
		 */
		try{
	
		/** File Load  */
			File file = new File(dirPath);
			Document doc = Jsoup.parse(file, fileEncoding);

		/** Parsing Data Select */
			Elements rows = doc.select("body table.type2 tr").attr("onMouseOver", "mouseOver(this)");			// BrandName
			compcd = doc.toString().substring(doc.toString().indexOf("code=")+5, doc.toString().indexOf("code=")+11);
			System.out.println(compcd);

		/** Data type Select  */
			//String Array
			String[] dt = new String[rows.size()];
			String[] sVal = new String[rows.size()];
			String[] hVal = new String[rows.size()];
			String[] lVal = new String[rows.size()];
			String[] eVal = new String[rows.size()];
			String[] gap = new String[rows.size()];
			String[] trsAmt = new String[rows.size()];
			
		/** Parsing Start */
			for (int i=0; i<rows.size(); i++) {
				Iterator<Element> iterElem = null;
				
				if(rows.get(i) != null) iterElem = rows.get(i).getElementsByTag("td").iterator();
				
				String item1 = null;
				String item2 = null;
				String item3 = null;
				String item4 = null;
				String item5 = null;
				String item6 = null;
				String item7 = null;
				
				if(iterElem.hasNext()) item1 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item2 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item3 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item4 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item5 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item6 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item7 = new StringBuilder().append(iterElem.next().text()).toString();
				
				try {
					
					dt[i] = item1;
					sVal[i] = item4;
					hVal[i] = item5;
					lVal[i] = item6;
					eVal[i] = item2;
					gap[i] = item3;
					trsAmt[i] = item7;
					
//					System.out.println(compcd+"\t"+dt[i]+"\t"+sVal[i]+"\t"+hVal[i]+"\t"+lVal[i]+"\t"+eVal[i]+"\t"+gap[i]+"\t"+trsAmt[i]);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		/** Parsing END */
			
			//DB Access
			MainServiceImplDAO midao = new MainServiceImplDAO();
			
			System.out.println(dt.length );
			
			for(int g=0; g<dt.length; g++){
				StkPrcMt inDvo = new StkPrcMt();
				
				if(sVal[g] != null && !sVal[g].trim().equals("")){
					inDvo.setCo_cd(compcd);
					inDvo.setEs_dt(dt[g].replaceAll("\\.", ""));
					inDvo.setEs_stvl(sVal[g].replaceAll(",", ""));
					inDvo.setEs_hivl(hVal[g].replaceAll(",", ""));
					inDvo.setEs_lovl(lVal[g].replaceAll(",", ""));
					inDvo.setEs_envl(eVal[g].replaceAll(",", ""));
					inDvo.setEs_trs(trsAmt[g].replaceAll(",", ""));
					inDvo.setEs_time("17:01");
					
					System.out.println(inDvo.getCo_cd() + " / " + inDvo.getEs_dt() + " / " + inDvo.getEs_envl());
/**					
					if( Integer.parseInt(cntList.get(0).getCnt()) > 0){
						// update : already data exist
						midao.updateData("Stock.updatePriceInfo", dto);
					}else{
						// insert : data doesn't exist
						midao.insertData("Stock.insertPriceInfo", dto);
					}
*/
					if(dt[g] == null){
						System.out.println(g +" : row is passed");
						continue;
					}
					int result = midao.insertData("stk_prc_mt.insertPrcInfo", inDvo);
					if(result == 0) midao.updateData("stk_prc_mt.updatePrcInfo", inDvo);
					
				}

					
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}// main - close
	

}

