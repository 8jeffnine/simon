<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% int pages = !"".equals(request.getAttribute("page")) && request.getAttribute("page") != null ? Integer.parseInt((String)request.getAttribute("page") ) : 1; %>
<!DOCTYPE html>
<html>
<head>
 <title>Recommend > Stock > Today</title>
 <meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
 
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src="/mi/js/common_fn.js" charset="utf-8"></script>

</head>
<body>
<form name="form" method="post">
<input type="hidden" name="page" />
<input type="hidden" name="startdt" />
<input type="hidden" name="compcd" />

<jsp:include page="menu.jsp" flush="false"/>

<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-10" align=center>
		<a href="#" class="cal_prev_btn _prev_day_btn"><span>전일</span></a>
		<span class="today _open_calendar_btn _date_title">
			2019.07.06.토<button class="ico_cal">달력보기</button>
		</span>
		<a href="#" class="cal_next_btn _next_day_btn"><span>내일</span></a>
	</div>
	<div class="col-sm-1"></div>
</div>

<div class="row">
 <div class="col-sm-1"></div>
 <div class="col-sm-10" align=center>
	<span>오늘의 추천주</span>
 </div>
 <div class="col-sm-1"></div>
</div>


<div class="row">
 <div class="col-sm-1"></div>
 <div class="col-sm-10">
	<div class="container">
	 <table class="table table-striped">
	   <thead>
	     <tr>
	       <th>순위</th>
	       <th>종목</th>
	       <th>목표기간</th>
	       <th>추천사유</th>
	       <th>목표수익률</th>
	     </tr>
	   </thead>
	   <tbody>
	   <%for(int i=0; i<5; i++){ %>
	     <tr>
		     <td width=10%><%=i+1 %></td>
		     <td width=*>좋은주식<%=i+1 %></td>
		     <td width=10%>(분기)</td>
		     <td width=20%>(전기차),(배당)</td>
		     <td width=20%>최저 15 %<br>~ 최대 <%=33-i%>%</td>
	     </tr>
	   <%} %>
	    </tbody>
	  </table>  
	</div>
  </div>
 <div class="col-sm-1"></div>
</div>

</form>
</body>
</html>