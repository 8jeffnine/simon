/**
 * common function library
 * author : jeffnine@naver.com
 * 
 */

function goURL(p1){
	document.form.action = "./"+p1+".do";
	document.form.submit();
}
function goURL2(p1, p2){
	document.form.action = "./"+p1+".do";
	document.form.gbn.value = p2;
	document.form.submit();
}
function goPage(p1){
	document.form.page.value = p1;
	document.form.action = "./search.do"
	document.form.submit();
}
function goChart(p1, p2){
	document.form.startdt.value = p1;
	document.form.compcd.value = p2;
	document.form.action = "./chart.do";
	document.form.submit();
}
function goNewsContent(p1){
	if("mobile" == pcOrMb){
		var oid = p1.substr(p1.indexOf("oid=")+4,3);
		var aid = p1.substr(p1.indexOf("aid=")+4,10);
		var url = "https://n.news.naver.com/article/newspaper/"+oid+"/"+aid;
		window.open(url,'_blank');
	}else{
		window.open(p1,'_blank');
	}
		
}
function fn_scrap(p1){
	window.open("./scrapExe.do?s_url="+p1,'_blank');	
}


var filter = "win16|win32|win64|mac|macintel";
var pcOrMb = "pc";

if ( navigator.platform ) {
	if ( filter.indexOf( navigator.platform.toLowerCase() ) < 0 ) {
		var pcOrMb = "mobile";
	}
}