package impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.Stock;


public class ParserStockbetDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new ParserStock().getHtmlData("C://catch_mi//daum_005930_1.html");
	}
	public void getHtmlData(final String file_name, final String startdt, final String enddt){
		String fileName = file_name;
//		final String compcd = comp_cd;
		String compcd = "";
		System.out.println(fileName);
		
		/**
		 * Daum Finance - Stock Price
		 * 
		 */
		try{
	
		/** File Load  */
			File input = new File(fileName);
			Document doc = Jsoup.parse(input, "UTF-8");

		/** Parsing Data Select */
			Elements rows = doc.select("table.gHead tr");			// BrandName
			Elements rows2 = doc.select("div input.typeBtn");
			
			int substrNo = rows2.get(0).getElementsByAttribute("onclick").toString().indexOf("code=")+5;
			compcd = rows2.get(0).getElementsByAttribute("onclick").toString().substring(substrNo, substrNo+6);
			

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
				String item8 = null;
				
				if(iterElem.hasNext()) item1 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item2 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item3 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item4 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item5 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item6 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item8 = new StringBuilder().append(iterElem.next().text()).toString();
				if(iterElem.hasNext()) item8 = new StringBuilder().append(iterElem.next().text()).toString();
				
				try {
					dt[i] = ("20"+item1).replaceAll("\\.", "");
					sVal[i] = item2.replaceAll("\\,", "");
					hVal[i] = item3.replaceAll("\\,", "");
					lVal[i] = item4.replaceAll("\\,", "");
					eVal[i] = item5.replaceAll("\\,", "");
					gap[i] = "0";
					trsAmt[i] = item8.replaceAll("\\,", "");
					
					
					System.out.println(compcd+"\t"+dt[i]+"\t"+sVal[i]+"\t"+hVal[i]+"\t"+lVal[i]+"\t"+eVal[i]+"\t"+gap[i]+"\t"+trsAmt[i]);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		/** Parsing END */
			
			//DB Access
			MainServiceImplDAO midao = new MainServiceImplDAO();
			
			for(int g=0; g<dt.length; g++){
				Stock dto = new Stock();
				
				// if date-value between startdt and enddt, then save else waiver
				if(dt[g].length() > 7 && Integer.parseInt(dt[g].trim()) >= Integer.parseInt(startdt.trim()) 
						&& Integer.parseInt(dt[g].trim()) <= Integer.parseInt(enddt.trim())){
				
					if(sVal[g] != null && !sVal[g].trim().equals("")){
						dto.setCompcd(compcd);
						dto.setDt(dt[g]);
						dto.setsVal(sVal[g]);
						dto.sethVal(hVal[g]);
						dto.setlVal(lVal[g]);
						dto.seteVal(eVal[g]);
						dto.setGap(gap[g]);
						dto.setTrsAmt(trsAmt[g]);
	/**					
						List<Stock> cntList = midao.selectData("Stock.selectPriceInfoExist", dto);
						
						if( Integer.parseInt(cntList.get(0).getCnt()) > 0){
							// update : already data exist
							midao.updateData("Stock.updatePriceInfo", dto);
						}else{
							// insert : data doesn't exist
							midao.insertData("Stock.insertPriceInfo", dto);
						}
	*/
						midao.insertData("Stock.insertPriceInfo", dto);
						
					}
				}
					
			}
		
		}catch(Exception e){
			System.out.println("error occured");
			e.printStackTrace();
		}
		
		
	}// main - close
	

}

