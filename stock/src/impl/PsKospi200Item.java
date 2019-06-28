package impl;

import java.io.File;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import entity.StkComMt;


public class PsKospi200Item {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new PsKospi200Item().getHtmlData("C://html//1.html");
	}
	
	public void getHtmlData(final String dirPath, final String fileEncoding){
		
		File file = new File(dirPath);
		File[] listOfFiles = file.listFiles();
		
		/** Data type Select  */
		//String Array
		String[] co_cd, co_nm; 
		
		for(int i=0; i<listOfFiles.length; i++){
			String fileName = listOfFiles[i].toString();
		

			try{
				File input = new File(fileName);
				Document doc = Jsoup.parse(input, fileEncoding);
	
				Elements rows = doc.select("body div table tbody tr td.ctg a"); // title 
				Elements rows2 = doc.select("body div table tbody tr td.ctg a"); // title 
				co_cd = new String[rows.size()];
				co_nm = new String[rows.size()];

				
				for(int j=0; j<rows.size(); j++){
					co_cd[j] = rows.get(j).attr("href").substring(rows.get(j).attr("href").indexOf("code")+5);
					co_nm[j] = rows2.get(j).text();
				}
				
				/** Parsing END */
				
				/** DB insert & update */
				MainServiceImplDAO midao = new MainServiceImplDAO();
				
				for(int g=0; g<co_cd.length; g++){
					StkComMt inDto = new StkComMt();
					inDto.setCo_cd(co_cd[g]);
					inDto.setCo_nm(co_nm[g]);
					inDto.setUse_yn("Y");
					
					List<StkComMt> cntList = midao.selectData("skt_com_mt.selectComListExist", inDto);

					if( cntList.size() < 1 ){
						// 존재하지 않으면 insert
						int result = midao.insertData("mkt.inserttComlnfo", inDto);
						if(result < 0) new Exception();
					}else{
						// 존재하면 update
						int result = midao.updateData("mkt.updateComlnfo", inDto);
						if(result < 0) new Exception();
					}
					
				}	
				
			
			}catch(Exception e){
				e.printStackTrace();
			}
	
				
		}
		
	}

}
