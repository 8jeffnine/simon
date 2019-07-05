package ui;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import entity.HttpItem;
import entity.Item;
import entity.Joblist;
import entity.News;
import entity.Search;
import entity.StkComMt;
import entity.Stock;
import entity.SysCdMt;
import entity.SysReqMt;
import entity.SysScrapMt;
import entity.User;
import impl.Crawler;
import impl.MainServiceImplDAO;
import impl.ParserNnews2;
import impl.ParserStock;
import impl.ParserStockbetDate;
import impl.PsKospi200Item;
import impl.PsStockPrice;

public class MainController extends Action {

	private String actionPath;
	private File file;
	static Logger logger = Logger.getRootLogger();
	static int k = 0;
	static String systemOs;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
		throws Exception{

		logger.info("MainController.execute() ");
		
		BasicConfigurator.configure();
		request.setCharacterEncoding("UTF-8");
		
		// Property : setting
		Properties props = new Properties();
		String propFile = "/var/lib/tomcat7/webapps/mi/WEB-INF/config.properties";

		
		// Property : File read, load
		FileInputStream fis = new FileInputStream(propFile);
		props.load(new java.io.BufferedInputStream(fis));
		
		// Property : Read properties
		final String file_Encoding = props.getProperty("file.encoding").trim();
		String systemOs = props.getProperty("system.os").trim();
		String file_path = props.getProperty("file."+systemOs+".path").trim();

//		String scrap_url = props.getProperty("scrap.url01").trim();
		
		
		// Session
		HttpSession session = request.getSession(true);
		String rrsidno = (String)session.getAttribute("user") != null ? (String)session.getAttribute("user") : "";
		
		// ActionForward
		actionPath = mapping.getPath().replace("/", "");
		String resultActionPath = actionPath;
		logger.info("actionPath : " + actionPath);
		// DB accesss
		MainServiceImplDAO midao = new MainServiceImplDAO();
		
		if(actionPath.equals("conTest")){
			
			List<Joblist> items = midao.selectData("mkt.selectAlive");
			request.setAttribute("currTime", items.get(0).getStartdt());
			

		}else if(actionPath.equals("scrap")){
			long b = System.currentTimeMillis();
			
			// get Joblists
			List<Joblist> jobList = midao.selectData("sys_scrap_mt.selectScrapJobList", null);
			logger.info("jobList.size() : " + jobList.size());
			request.setAttribute("jobList", jobList);
			
			long a = System.currentTimeMillis();
			logger.info(a-b);
		}else if(actionPath.equals("scrapAdmin")){
			long b = System.currentTimeMillis();
			
			long a = System.currentTimeMillis();
			logger.info(a-b);
			
		}else if(actionPath.equals("scrapComReg")){
			long b = System.currentTimeMillis();
			
			String co_cd = request.getParameter("co_cd");
			
			StkComMt inDvo = new StkComMt();
			inDvo.setCo_cd(co_cd);
			
			logger.info(co_cd);

			List<StkComMt> comList = midao.selectData("skt_com_mt.selectComList", inDvo);
			logger.info("comList : " + comList.size());
			
			if(comList != null && comList.size() > 0){
				request.setAttribute("comList", comList);
				
				long a = System.currentTimeMillis();
				logger.info(a-b);
				return mapping.findForward("success");
				
			}else{
				return mapping.findForward("failed");
			}
			
			
			
		}else if(actionPath.equals("scrapComList")){
			long b = System.currentTimeMillis();
			
			List<StkComMt> comList = midao.selectData("skt_com_mt.selectComList");
			logger.info(comList.size());
			
			if(comList != null && comList.size() > 0){
				request.setAttribute("comList", comList);
				
				long a = System.currentTimeMillis();
				logger.info(a-b);
				return mapping.findForward("success");
				
			}else{
				return mapping.findForward("failed");
			}
			
		}else if(actionPath.equals("scrapComRegProc")){
			long b = System.currentTimeMillis();
			
			String gbn = request.getParameter("gbn");
			
			String co_cd = request.getParameter("co_cd");
			String co_nm = request.getParameter("co_nm");
			String st_dt = request.getParameter("st_dt");
			String en_dt = request.getParameter("en_dt");
			String use_yn = request.getParameter("use_yn");
			String cat01 = request.getParameter("cat01");
			String cat02 = request.getParameter("cat02");
			String cat03 = request.getParameter("cat03");
			String cat04 = request.getParameter("cat04");
			String cat05 = request.getParameter("cat05");
			
			StkComMt inDvo = new StkComMt();
			inDvo.setCo_cd(co_cd);
			inDvo.setCo_nm(co_nm);
			inDvo.setSt_dt(st_dt);
			inDvo.setEn_dt(en_dt);
			inDvo.setUse_yn(use_yn);
			inDvo.setCat01(cat01);
			inDvo.setCat02(cat02);			
			inDvo.setCat03(cat03);			
			inDvo.setCat04(cat04);			
			inDvo.setCat05(cat05);			

			int result = 0;
			
			if("I".equals(gbn)){
				midao.insertData("skt_com_mt.inserttComlnfo", inDvo);
			}else if("U".equals(gbn)){
				midao.updateData("skt_com_mt.updateComlnfo", inDvo);
			}else if("D".equals(gbn)){
				StkComMt delDev = new StkComMt();
				delDev.setUse_yn(use_yn);
				midao.updateData("skt_com_mt.updateComlnfo", delDev);
			}else{
				
			}
			
			long a = System.currentTimeMillis();
			logger.info(a-b);

			if(result > 0){
				return mapping.findForward("success");
			}else{
				return mapping.findForward("failed"); 
			}
			
		}else if(actionPath.equals("scrapComRegProc")){
			// kospi 200 종목(co_cd) 자동 업데이트
			long b = System.currentTimeMillis();
			
			// 수집경로
			
			// parsing
			
			
			long a = System.currentTimeMillis();
			logger.info(a-b);
			
		}else if(actionPath.equals("scrapReg")){
			long b = System.currentTimeMillis();
			
			SysCdMt inDto = new SysCdMt();
			inDto.setGroup_cd("SCR_PARAM");
			
			// 1) Param, 2) Session, 3) Default = 'ko'
			String langKey = (String)request.getParameter("lang_key");
			if(langKey == null || "".equals(langKey) )langKey = (String)session.getAttribute("lang_key");
			if(langKey == null || "".equals(langKey) )inDto.setLang_key("ko");

			List<SysCdMt> cdInfo = midao.selectData("sys_cd_mt.selectSysCdList", inDto);
			List<SysReqMt> headerInfo = midao.selectData("sys_req_mt.selectReqHeaderInfo");
			
			request.setAttribute("cdInfo", cdInfo);
			request.setAttribute("headerInfo", headerInfo);
			
			long a = System.currentTimeMillis();
			logger.info(a-b);
			
			
		}else if(actionPath.equals("scrapRegSave")){
			
			String scrap_src = request.getParameter("scrap_src");
			String scrap_prs = request.getParameter("scrap_prs");
			String s_url = request.getParameter("s_url");
			String p_val = request.getParameter("p_val");
			String p_key = request.getParameter("p_key");
			String p_st = request.getParameter("p_st");
			String p_en = request.getParameter("p_en");
			String dom_val = request.getParameter("dom_val");
			String req_header_val = request.getParameter("req_header_val");
			
			SysScrapMt inDvo = new SysScrapMt();
			inDvo.setScrap_src(scrap_src);
			inDvo.setScrap_prs(scrap_prs);
			inDvo.setS_url(s_url);
			inDvo.setP_stat("0");
			inDvo.setS_stat("0");
			inDvo.setRrsidno(rrsidno);

			int result = midao.insertData("sys_scrap_mt.insertScrapJoblist", inDvo);
			if(result > 0){
				return mapping.findForward("success");
			}else{
				return mapping.findForward("failed"); 
			}
			
			
			
		}else if(actionPath.equals("scrapReqSave")){
			
			String reqNm = request.getParameter("req_nm");
			String reqMth = request.getParameter("req_mth");
			String reqAcc = request.getParameter("req_acc");
			String reqAcen = request.getParameter("req_acen");
			String reqAclg = request.getParameter("req_aclg");
			String reqCach = request.getParameter("req_cach");
			String reqCon = request.getParameter("req_con");
			String reqDnt = request.getParameter("req_dnt");
			String reqCk = request.getParameter("req_ck");
			String reqHost = request.getParameter("req_host");
			String reqRef = request.getParameter("req_ref");
			String reqUir = request.getParameter("req_uir");
			String reqAgent = request.getParameter("req_agent");
			
			SysReqMt inDvo = new SysReqMt();
			inDvo.setReq_nm(reqNm);
			inDvo.setReq_mth(reqMth);
			inDvo.setReq_acc(reqAcc);
			inDvo.setReq_acen(reqAcen);
			inDvo.setReq_aclg(reqAclg);
			inDvo.setReq_cach(reqCach);
			inDvo.setReq_con(reqCon);
			inDvo.setReq_dnt(reqDnt);
			inDvo.setReq_ck(reqCk);
			inDvo.setReq_host(reqHost);
			inDvo.setReq_ref(reqRef);
			inDvo.setReq_uir(reqUir);
			inDvo.setReq_agent(reqAgent);
			
			int result = midao.insertData("sys_req_mt.insertReqHeaderInfo", inDvo);
			if(result > 0){
				return mapping.findForward("success");
			}else{
				return mapping.findForward("failed"); 
			}
			
		}else if(actionPath.equals("loginCheck")){
			
			String usrEmail = request.getParameter("email");
			String usrPw = request.getParameter("pwd");
			
			// email, password is required
			if(usrEmail == null || usrPw == null) return mapping.findForward("failed");
			
			User inDto = new User();
			if(usrEmail != null)inDto.setUsr_email(usrEmail);
			if(usrPw != null)inDto.setUsr_pw(usrPw);
			
			List<User> userInfo = midao.selectData("user.selectUserInfo", inDto);
			if(userInfo.size() > 0){
				session.setAttribute("user", userInfo.get(0).getUsr_nm());
			}else{
				// 일치하는 정보가 없으면 failed 로 처리하여 search 로 다시이동
				return mapping.findForward("failed");
			}
			
		}else if(actionPath.equals("scrapDefSet")){
			long b = System.currentTimeMillis();

			// setup today's default joblist
			Joblist scrDto = new Joblist();
			int result = midao.updateData("StkPrcMt.updateDefaultJobList", scrDto);
			
			if(result == 0){
				return mapping.findForward("success");
			}else{
				return mapping.findForward("failed"); 
			}
			
			
		}else if(actionPath.equals("scrapExe")){
			long b = System.currentTimeMillis();
			
			String today = getToday8digit();
			
			String sUrl = request.getParameter("s_url");
			logger.info("sUrl : " + sUrl);
			Joblist scrDto = new Joblist();
			if(sUrl != null && !"".equals(sUrl)) scrDto.setS_url(sUrl);
			
			// get Joblist
			List<Joblist> items = midao.selectData("mkt.selectJobList", scrDto);
			k = items.size();
			logger.info("k : " + k);
			// get Http request header info
			if(k == 0) 
				return mapping.findForward("success");
			
			String compcd = items.get(0).getComp();	// parser
			String gbn = items.get(0).getGbn();	// http request
				SysReqMt inDto = new SysReqMt();
						inDto.setReq_nm(gbn);
				List<SysReqMt> httpItems = midao.selectData("sys_req_mt.selectHttpItem", inDto);

			// crawling => file save
			String pre_fileName = compcd + "_" + today + "_";
			String exePath = getFilePath(file_path);
//			backupPath = getBackupFilePath(file_path);
			
			File dest = new File(exePath);
			if(!dest.exists()) dest.mkdir();
			
			// crawling on web
			for(int i=0; i < items.size(); i++){
				if(compcd != items.get(i).getComp() ){
					compcd = items.get(i).getComp();
					
					// if "compcd" is changed, http_request_header_info must change
					inDto.setReq_nm(compcd);
					httpItems = midao.selectData("sys_req_mt.selectHttpItem", inDto);
					pre_fileName = compcd + "_" + today + "_" + System.currentTimeMillis();
				}
				
				logger.info("httpItems SIZE : " + httpItems.size());
				Crawler craw = new Crawler();
					craw.getHTMLFile(items.get(i).getS_url(), exePath, pre_fileName + i + ".html", httpItems);
					Thread.sleep(320); // delay 0.3s
					Joblist updDto = new Joblist();
						updDto.setS_url(items.get(i).getS_url());
						updDto.setS_status("1");
					midao.updateData("mkt.updateJobStatus", updDto);
			}
//			logger.info("crawling == " + (System.currentTimeMillis()-b)/1000 + "s");
			
			if(k >= 1){
				return mapping.findForward("continue");
			}
			
		}else if(actionPath.equals("insert")){
			long b = System.currentTimeMillis();
			
			// 날짜를 지정해서 parsing 하는 경우 today 파라미터로 수신
			String today = (String)request.getParameter("today");
			
			String exePath = getFilePath(file_path);
			String backupPath = getBackupFilePath(file_path);
			
			// 설정된 폴더의 파일들을 찾음
			File file = new File(exePath);
			File[] listOfFiles = file.listFiles();
			
			// 백업할 파일 관련하여
			File backupFile = new File(backupPath);
			if(!backupFile.exists()) backupFile.mkdirs();
			
//			logger.info(listOfFiles.length);
			
			// 파일 중 html파일을 선택
			// 각 파일명에 parser 명이 있을 경우 해당 parser를 수행 
			for(int i=0; i<listOfFiles.length; i++){
				if(listOfFiles[i].toString().indexOf(".html") > -1){
					if(listOfFiles[i].toString().toLowerCase().indexOf("daum") > -1){
						logger.info(listOfFiles[i].toString());
						ParserStock parseStock = new ParserStock();
						parseStock.getHtmlData(listOfFiles[i].toString(), "UTF-8");
					}else if(listOfFiles[i].toString().toLowerCase().indexOf("nvw01") > -1){
						// naver news 01
						logger.info(listOfFiles[i].toString());
						ParserNnews2 parseNews = new ParserNnews2();
						parseNews.getHtmlData(listOfFiles[i].toString(), file_Encoding);
						
					}else if(listOfFiles[i].toString().toLowerCase().indexOf("nvf02") > -1){
						// naver finance 01 -- kospi 200 company code update
						logger.info(listOfFiles[i].toString());
						PsStockPrice parseStockPrice = new PsStockPrice();
						parseStockPrice.getHtmlData(listOfFiles[i].toString(), file_Encoding);
						
					}else if(listOfFiles[i].toString().toLowerCase().indexOf("nvf01") > -1){
						// naver finance 01 -- kospi 200 company code update
						logger.info(listOfFiles[i].toString());
						PsKospi200Item parseComCode = new PsKospi200Item();
						parseComCode.getHtmlData(listOfFiles[i].toString(), file_Encoding);
					}
				}
				// 파일을 백업 위치로 이동
				listOfFiles[i].renameTo(new File(backupPath));
			}
			
			return mapping.findForward("success");
			
		}else if(actionPath.equals("isrDate")){
			long b = System.currentTimeMillis();

			String startdt = (String)request.getParameter("startdt");
			String enddt = (String)request.getParameter("enddt");
			
			String today = getToday8digit();
			if(startdt == null) startdt = today;
			if(enddt == null) enddt = today;

			String exePath = getFilePath(file_path);
//			String backupPath = getBackupFilePath(file_path);
			
			File file = new File(exePath);
			File[] listOfFiles = file.listFiles();

			for(int i=0; i<listOfFiles.length; i++){
				if(listOfFiles[i].toString().indexOf(".html") > -1){
					if(listOfFiles[i].toString().toLowerCase().indexOf("daum") > -1){
//						logger.info(listOfFiles[i].toString());
						ParserStockbetDate parseStock = new ParserStockbetDate();
						parseStock.getHtmlData(listOfFiles[i].toString(), startdt, enddt);
					}else if(listOfFiles[i].toString().toLowerCase().indexOf("n2") > -1){
//						logger.info(listOfFiles[i].toString());
						ParserNnews2 parseNews = new ParserNnews2();
						parseNews.getHtmlData(listOfFiles[i].toString(), file_Encoding);
					}
				}
			}
			
			logger.info("parsing == " + (System.currentTimeMillis()-b)/1000 + "s");
			
			
		}else if(actionPath.equals("NewsHis")){
			long b = System.currentTimeMillis();
			
			String today = getToday8digit();
			
			// get Joblist
			List<Joblist> items = midao.selectData("mkt.selectNewsJobList");

			// get Http request header info
			String compcd = items.get(0).getComp();
			today = items.get(0).getStartdt();
				HttpItem inDto = new HttpItem();
					inDto.setCompcd(compcd);
				List<HttpItem> httpItems = midao.selectData("mkt.selectHttpItem", inDto);

			// crawling => file save
			String pre_fileName = compcd + "_" + today + "_";

			String exePath = getFilePath(file_path);
//			String backupPath = getBackupFilePath(file_path);
			
			File dest = new File(exePath);
			if(!dest.exists()) dest.mkdir();
			
			// crawling on web
			for(int i=0; i < items.size(); i++){
				if(compcd != items.get(i).getComp() ){
					compcd = items.get(i).getComp();
					
					// if "compcd" is changed, http_request_header_info must change
					inDto.setCompcd(compcd);
					httpItems = midao.selectData("mkt.selectHttpItem", inDto);
					pre_fileName = compcd + "_" + today + "_";
				}
				
				Crawler craw = new Crawler();
					craw.getHTMLFile(items.get(i).getS_url(), exePath, pre_fileName + i + ".html", httpItems);
					Thread.sleep(1650); // delay 0.3s
					Joblist updDto = new Joblist();
						updDto.setS_url(items.get(i).getS_url());
						updDto.setS_status("1");
					midao.updateData("mkt.updateJobStatus", updDto);
			}
//			logger.info("crawling == " + (System.currentTimeMillis()-b)/1000 + "s");
			
			
		}else if(actionPath.equals("search")){
			
			
//			String keyword = request.getParameter("keyword") != null ? new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"UTF-8") : null;
//			String title = null != keyword ? new String(keyword.toLowerCase().getBytes("UTF-8"), "UTF-8") : null;

			// if keyword is null, then post process is not working.
			if(request.getParameter("keyword") == null) return mapping.findForward("search");
			
			String keyword = request.getParameter("keyword").trim().toLowerCase();
			
			String title = null;
			String title2 = null;
			String title3 = null;
			String[] key3word = new String[10];
			
			key3word = keyword.split(" ");
			if(key3word.length > 0){
				if(null != key3word[0] && !"".equals(key3word[0])) title = key3word[0];
				if(key3word.length >= 2) if(null != key3word[1] && !"".equals(key3word[1])) title2 = key3word[1];
				if(key3word.length >= 3) if(null != key3word[2] && !"".equals(key3word[2])) title3 = key3word[2];
			}
//			logger.info(key3word[0]+"\t"+key3word[1]+"\t"+key3word[2]);
			
			String page = request.getParameter("page") != null && !"".equals(request.getParameter("page")) ? request.getParameter("page") : "1";
			int pagef = (Integer.parseInt(page) - 1) * 30;
			
//			logger.info("search param ====>" + keyword + "\t" + pagef);
			News inDto = new News();
				if(title != null) inDto.setTitle(title);
				if(title2 != null) inDto.setTitlesec(title2);
				if(title3 != null) inDto.setTitlethi(title3);
				inDto.setPagef(pagef);
//				inDto.setContent(keyword);

			try{
				List<News> newsList = midao.selectData("mkt.selectNewsList", inDto);
//				List<Stock> stockList = midao.selectData("mkt.selectStockList", inDto);
//				logger.info("newsList.cnt == " + newsList.size());
				
//				logger.info(stockList.size());
				request.setAttribute("newsList", newsList);
//				request.setAttribute("stockList", stockList);
				
				logger.info(newsList.size());
				
				// log save
				Search schDto = new Search();
					schDto.setAction("/"+actionPath+".do");
					if(keyword != null)schDto.setKeyword(keyword);
//					if(startdt != null)schDto.setStartdt(startdt);
//					if(enddt != null)schDto.setEnddt(enddt);
//					if(compcd != null)schDto.setCompcd(compcd);
//				midao.insertData("mkt.insertSearchLog", schDto);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
//				logger.info("keyword : " + keyword + "\t" + "page : " + page);
				if(null != keyword) request.setAttribute("keyword", keyword);
				request.setAttribute("page", (String)request.getParameter("page"));
				logger.info("search end");
				
		}else if(actionPath.equals("chart")){

//			String keyword = request.getParameter("keyword") != null ? new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"UTF-8") : null;
			
			String keyword = request.getParameter("keyword") != null ? request.getParameter("keyword") : null;
			String startdt = request.getParameter("startdt") != null ? request.getParameter("startdt").replaceAll("-", "") : null;
//			String enddt = request.getParameter("enddt") != null ? request.getParameter("enddt").replaceAll("-", "") : Integer.parseInt(startdt.substring(0,4))+1 + startdt.substring(4, 8);
			String enddt = request.getParameter("enddt") != null ? request.getParameter("enddt").replaceAll("-", "") : request.getParameter("startdt") != null ? Integer.parseInt(startdt.substring(0,4))+1 + startdt.substring(4, 8) : null;
			String compcd = request.getParameter("compcd") != null ? request.getParameter("compcd") : null;
			
			List<Stock> compList = midao.selectData("mkt.selectCompList");
			
			if(startdt != null){
				Stock inDto = new Stock();
					inDto.setsDate(startdt);
				List<Stock> guideLine = midao.selectData("mkt.selectGideLine", inDto);
				
				if(guideLine.size() > 0){
	//				logger.info(guideLine.get(0).getsDate() );
					
	//				logger.info(guideLine.get(0).getsDate().substring(0, 4)+"-"+guideLine.get(0).getsDate().substring(4, 6)+"-"+guideLine.get(0).getsDate().substring(6, 8));
					request.setAttribute("release", guideLine.get(0).getsDate());
					request.setAttribute("judge", guideLine.get(0).geteDate());
				}
			}
				
			if(null != keyword) request.setAttribute("keyword", keyword);
			if(null != startdt) request.setAttribute("startdt", startdt);
			if(null != enddt) request.setAttribute("enddt", enddt);
			if(null != compcd) request.setAttribute("compcd", compcd);
			if(compList.size() > 0) request.setAttribute("compList", compList);
			
//			logger.info(keyword + "\t" + startdt + "\t" + enddt);
			
			// log save
/**
			Search schDto = new Search();
				schDto.setAction("/"+actionPath+".do");
				if(keyword != null)schDto.setKeyword(keyword);
				if(startdt != null)schDto.setStartdt(startdt);
				if(enddt != null)schDto.setEnddt(enddt);
				if(compcd != null)schDto.setCompcd(compcd);
			midao.insertData("mkt.insertSearchLog", schDto);
	*/		
			
		}else if(actionPath.equals("chartData")){
			
			String compcd = request.getParameter("compcd") != null ? request.getParameter("compcd") : " ";
			String startdt = request.getParameter("startdt") != null ? request.getParameter("startdt").replaceAll("-", "") : null;
			String enddt = request.getParameter("enddt") != null ? request.getParameter("enddt").replaceAll("-", "") : null;
			
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			if(enddt == null) enddt = df.format(new Date());
			
			Stock inDto = new Stock();
				inDto.setsDate(startdt);
				inDto.seteDate(enddt);
				inDto.setCompcd(compcd);

			try{
				List<Stock> priceList = midao.selectData("mkt.selectPriceList", inDto);
				
				List date = new ArrayList();
				List endValue = new ArrayList();
				List startValue = new ArrayList();
				List highestValue = new ArrayList();
				List lowestValue = new ArrayList();
				
				for(int i=0; i<priceList.size(); i++){
					date.add(priceList.get(i).getDt());
					endValue.add(priceList.get(i).geteVal());
					startValue.add(priceList.get(i).getsVal());
					highestValue.add(priceList.get(i).gethVal());
					lowestValue.add(priceList.get(i).getlVal());
				}
				
				JSONObject json = new JSONObject();
					json.put("date", date);
					json.put("eval", endValue);
					json.put("sval", startValue);
					json.put("hval", highestValue);
					json.put("lval", lowestValue);
				
				logger.info(json.toString());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json.toString());
				
				return null;
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
			
		}else if(actionPath.equals("chartSave")){
	
			String keyword = request.getParameter("keyword") != null ? request.getParameter("keyword") : null;
			String startdt = request.getParameter("startdt") != null ? request.getParameter("startdt").replaceAll("-", "") : null;
			String compcd = request.getParameter("compcd") != null ? request.getParameter("compcd") : null;
			String updown = request.getParameter("updown") != null ? request.getParameter("updown") : null;
			
			// just save param from screen for after-analysis
			Search schDto = new Search();
				schDto.setAction("/"+actionPath+".do");
				if(keyword != null)schDto.setKeyword(keyword);
				if(startdt != null)schDto.setStartdt(startdt);
				if(compcd != null)schDto.setCompcd(compcd);
				if(updown != null)schDto.setUpdown(updown);
			midao.insertData("mkt.insertSearchResult", schDto);
			
			JSONObject json = new JSONObject();
				json.put("Status", 200);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Status", "200");
			response.getWriter().write(json.toString());
			
			
		}else{
			//action path is null
			
		}
		return mapping.findForward(resultActionPath);
	}
	
	public String getFilePath(String path){
		String today = getToday8digit();
		
		// properties 파일의 설정에 따라 파일 기본경로를 설정한다
		if("window".equals(systemOs)){
			path = path+today+"\\";	//windows
		}else{
			path = path+today+"/";
		}

		return path;
	}
	
	public String getBackupFilePath(String path){
		String today = getToday8digit();
		
		// properties 파일의 설정에 따라 파일 기본경로를 설정한다
		if("window".equals(systemOs)){
			path = path + "b" + today + "\\";
		}else{
			path = path + "b" + today + "/";
		}
		
		return path;
	}
	
	public String getToday8digit(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String today = df.format(now);
		today = today.substring(0, 8);
		
		return today;
	}

}