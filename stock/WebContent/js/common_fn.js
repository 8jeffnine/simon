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
	window.open(p1,'_blank');	
}
function fn_scrap(p1){
	window.open("./scrapExe.do?s_url="+p1,'_blank');	
}
