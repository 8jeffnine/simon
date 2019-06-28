package impl;

import impl.MainServiceImplDAO;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.News;


public class ParserData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new ParserData().getHtmlData("C://html//1.html");
//	}
//	public void getHtmlData(String file_name){
		
		File file = new File("C://html//");
		File[] listOfFiles = file.listFiles();
		
		for(int i=0; i<listOfFiles.length; i++){
			String fileName = listOfFiles[i].toString();
		

			try{
				File input = new File(fileName);
				Document doc = Jsoup.parse(input, "UTF-8");
	
				String newText = doc.toString().substring(doc.toString().indexOf("list-area cf"), doc.toString().indexOf("pagenation-btm"));
				System.out.println(newText);
				
			
			}catch(Exception e){
				e.printStackTrace();
			}
	
		}
		
	}

}
