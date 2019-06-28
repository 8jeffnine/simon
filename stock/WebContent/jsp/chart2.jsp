<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List, entity.Stock" %>
<%
	List<Stock> compList = (List<Stock>)request.getAttribute("compList");
	String compcd = ""; 
	if(request.getAttribute("compcd") != null) compcd = (String)request.getAttribute("compcd");
%>
<!DOCTYPE html>
<html class='no-js'>
<head>
 <title>Stock >> Chart</title>
 <meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <!-- c3.js -->
   <!-- Load c3.css -->
   <link href="./c3/c3.css" rel="stylesheet" type="text/css">

   <!-- Load d3.js and c3.js -->
<!-- 	<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script> -->
	<script src="./c3/c3.min.js" charset="utf-8"></script>
	<script src="./d3/d3.v3.min.js" charset="utf-8"></script>
   <!-- <script src="http://c3js.org/js/c3.min-4c5bef8f.js"></script> -->


<script>
window.onload = initPage;
chart = c3;
function initPage(){
	var sel = document.getElementById("compcd");
	chart = c3.generate({
    data: {
    	url: '/mi/chartData.do?startdt='+document.form.startdt.value+'&enddt='+document.form.enddt.value+'&compcd='+sel.options[sel.selectedIndex].value,
    	mimeType: 'json',
    	x: 'date',
    	columns: ['eval', 'sval', 'hval', 'lval']
    },
    names: {
    	eval: 'end value',
        sval: 'start value',
        hval: 'highest value',
        lval: 'lowest value'
    },
    axis: {
        x: {
            type: 'timeseries',
            tick: {
                format: '%Y-%m-%d'
            }
        }
    },
    point: {
        show: false
    }
    <%if(request.getAttribute("release") != null && !"".equals(request.getAttribute("release")) ){%>
    ,
    grid: {
    	x: {
    		lines: [
				{value: '<%=request.getAttribute("release")%>', text: 'News Release'},
				{value: '<%=request.getAttribute("judge")%>', text: 'After 3 months', position: 'start'}
			]
    	},
        y: {
            show: true
        }
    }
    <%} %>
});
}

function loadDoc(p1) {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert('save complete == '+document.form.compcd.value);
	    }
	  };
	  xhttp.open("GET", 'chartSave.do?startdt='+document.form.startdt.value+'&compcd='+document.form.compcd.value+'&keyword='+document.form.keyword.value+'&updown='+p1, true);
	  xhttp.send();
}
</script>
</head>

<body class='antialiased'>

<jsp:include page="menu.jsp" flush="false"/>

<form name="form">
<div class="row">
 <div class="col-md-1"></div>
 <div class="col-md-3">
   <div class="input-group date" data-provide="datepicker">
   	<%if(request.getAttribute("startdt") == null){ %>
     <input type="text" name="startdt" class="form-control" placeholder="input start-date : 8 digit (ex.20170420)">
    <%}else{ %>
     <input type="text" name="startdt" class="form-control" placeholder="input start-date : 8 digit (ex.20170420)" value="<%=request.getAttribute("startdt")%>">
    <%} %>
     <div class="input-group-addon">
       <span class="glyphicon glyphicon-th"></span>
     </div>
   </div>
 </div>
 <div class="col-md-3">
   <div class="input-group date" data-provide="datepicker">
   	<%if(request.getAttribute("enddt") == null){ %>
     <input type="text" name="enddt" class="form-control" placeholder="input end-date : 8 digit (ex.20170420)">
    <%}else{ %>
     <input type="text" name="enddt" class="form-control" placeholder="input end-date : 8 digit (ex.20170420)" value="<%=request.getAttribute("enddt")%>">
    <%} %>
     <div class="input-group-addon">
       <span class="glyphicon glyphicon-th"></span>
     </div>
   </div>
 </div>
 <div class="col-md-4">
   	<%if(request.getAttribute("keyword") == null){ %>
     <input type="text" class="form-control" placeholder="input search keyword" name="keyword" disabled>
    <%}else{ %>
     <input type="text" class="form-control" placeholder="input search keyword" name="keyword" value="<%=request.getAttribute("keyword") %>" readonly>
    <%} %>
 </div>
 <div class="col-md-1"></div>
</div>
<div class="row">
 &nbsp;
</div>
<div class="row">
 <div class="col-md-1"></div>
 <div class="col-md-3">
   <div class="input-group">
   	 <%if(compList.size() < 1){ %>
   	 	<input type="text" name="compcd" class="form-control" placeholder="input company_code (ex.005930)">
   	 <%}else if(compList.size() > 0){ %>
   	 <select name="compcd" id="compcd" class="form-control">
   	 	<%for(int i=0; i<compList.size(); i++){ %>
   	 	<option value="<%=compList.get(i).getCompcd()%>" <% if( compcd.equals( compList.get(i).getCompcd() ) ){ %>selected<%} %>><%=compList.get(i).getCompnm() %>(<%=compList.get(i).getCompcd()%>)</option>
   	 	<%} %>
   	 </select>
   	 <%} %>
     <div class="input-group-btn">
	 	<button class="btn btn-default" type="submit">
	         <i class="glyphicon glyphicon-search"></i>
	    </button>
     </div>
   </div>
 </div>
 <div class="col-md-3">
 <!-- 
 	  <button class="btn btn-default" onClick="window.history.go(-2);">
        <i class="glyphicon glyphicon-step-backward"></i>
      </button>
      [go to back]
  -->
 </div>
 <div class="col-md-4">
      <a class="btn btn-default" href="javascript:loadDoc('1');">
        <i class="glyphicon glyphicon-thumbs-up" ></i>
      </a>
      <b>[True]</b> Achieve a goal &emsp;
      <br>
      <a class="btn btn-default" href="javascript:loadDoc('2');">
        <i class="glyphicon glyphicon-thumbs-down" ></i>
      </a>
      <b>[False]</b> Fail to achieve a goal 
 </div>
 <div class="col-md-1"></div>
</div>

<div class='container'>
	<h1 class='title'>Historical Chart</h1>
	<div class='chart'>
		<div id='chart'></div>
	</div>
	<div id='ace-error'></div>
</div>
</form>

</body>
</html>
