<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% int pages = !"".equals(request.getAttribute("page")) && request.getAttribute("page") != null ? Integer.parseInt((String)request.getAttribute("page") ) : 1; %>
<!DOCTYPE html>
<html>
<head>
 <title>Stock >> Scrap >> Code list</title>
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

<jsp:include page="menu.jsp" flush="false"/>

<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="msg">
			<blockquote><h3>Scrap Company Code Registration</h3></blockquote>		  
		  </label>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>

<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-10" align=right>
		<button class="btn btn-warning">Cancel</button>
		<button class="btn btn-primary" onClick="goURL('scrapComReg');">Add</button>
	</div>
	<div class="col-sm-1"></div>
</div>

<div class="row">
	<div class="col-sm-1"></div>
	 <div class="col-sm-10">
		 <table class="table table-striped">
 			<thead>
 				<tr>
	 				<th width=10%>번호</th>
	 				<th width=*>종목명</th>
	 				<th width=10%>종목코드</th>
	 				<th width=5%>시작일</th>
	 				<th width=5%>종료일</th>
	 				<th width=10%>분류1</th>
	 				<th width=10%>분류2</th>
	 				<th width=10%>분류3</th>
	 			</tr>
 			</thead>
 			<tbody>
 			<c:if test="${fn:length(comList) > 0}">
  				<c:forEach items="${comList}" var="comlist" varStatus="status">
  					<tr>
  						<td>${status.count }</td>
  						<td>${comlist.co_nm }</td>
  						<td>${comlist.co_cd }</td>
  						<td>${comlist.st_dt }</td>
  						<td>${comlist.en_dt }</td>
  						<td>${comlist.cat01 }</td>
  						<td>${comlist.cat02 }</td>
  						<td>${comlist.cat03 }</td>
  					</tr>
  				</c:forEach>
  				</c:if>
			<c:if test="${fn:length(comList) eq 0}">
			   <tr>
			     <td colspan="6">There is empty.</td>
			   </tr>
			</c:if>
 			</tbody>
 		</table>
	</div>
	<div class="col-sm-1"></div>
</div>

<div class="row">
	<div class="col-sm-12">&nbsp;</div>
</div>

<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-10" align=right>
		<button class="btn btn-warning">Cancel</button>
		<button class="btn btn-primary" onClick="goURL('scrapComReg');">Add</button>
	</div>
	<div class="col-sm-1"></div>
</div>

<div class="row">
	<div class="col-sm-12">&nbsp;</div>
</div>

</form>
</body>
</html>