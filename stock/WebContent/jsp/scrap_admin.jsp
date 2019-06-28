<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% int pages = !"".equals(request.getAttribute("page")) && request.getAttribute("page") != null ? Integer.parseInt((String)request.getAttribute("page") ) : 1; %>
<!DOCTYPE html>
<html>
<head>
 <title>Stock >> Search</title>
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
 <div class="col-md-1"></div>
 <div class="col-md-1" align=left>
	<button class="btn btn-default">Job List</button>
 </div>
 <div class="col-md-8"></div>
 <div class="col-md-1" align=right>
 	<button class="btn btn-default" onClick="goURL('scrapComList');">Com Code Add</button>
	<button class="btn btn-default" onClick="goURL('scrapReg');">Add</button>
 </div>
 <div class="col-md-1"></div>
</div>



<div class="row">
 <div class="col-md-1"></div>
  <div class="col-md-10" style="height:480px; overflow:auto;">
 <p>&nbsp;</p>
 <table>
 	<thead>
	<tr>
     <th width=5%>Seq</th>
     <th width=10%>Site(x-y-z)</th>
     <th width=*>URL</th>
     <th width=10%>Option</th>
     <th width=25%>Var(param - from - to)</th>
     <th width=10%>DOM</th>
     <th width=10%>Req.Header</th>
   </tr>
 	</thead>
 	
 	<tbody>
 	<tr>
 		<td>1</td>
 		<td>News-MK-1면</td>
		<td><input type="text" value="http://www.mk.co.kr" size=40 disabled/></td>
 		<td><select><option selected>상수</option></select></td>
 		<td><input type="text" value="date" size=6 disabled/><input type="text" value="20190523"  size=6 disabled/><input type="text" value="0" size=6 disabled/></td>
 		<td><input type="text" value="body.list[0]" size=6 disabled/></td>
 		<td><input type="button" onClick="#" value="이동" /></td>
 	</tr>
 	<tr>
 		<td>2</td>
 		<td>News-MK-2면</td>
		<td><input type="text" value="http://www.mk.co.kr" size=40 disabled/></td>
 		<td><select><option selected>상수</option></select></td>
 		<td><input type="text" value="date" size=6 disabled/><input type="text" value="20190523" size=6 disabled/><input type="text" value="0" size=6 disabled/></td>
 		<td><input type="text" value="body.list[0]" size=6 disabled/></td>
 		<td><input type="button" onClick="#" value="이동" /></td>
 	</tr>
 	</tbody>
 </table>
 </div>
  <div class="col-md-1"></div>
</div>



<div class="row" align="center">
 <ul class="pagination">
  <!-- 2val needed : current-pages, all-pages -->
  <!-- all-pages < 5 then show all number else depend on current-pages -->
<%if( pages < 3  ){ %>
	<%for(int i=1; i<6; i++){ %>
   <li><a href="#" onClick="script:goPage('<%=i %>');"><%=i %></a></li>
   	<%} %>
<%}else{ %>   
	<%for(int i=(pages-2); i<(pages+3); i++){ %>
   <li><a href="#" onClick="script:goPage('<%=i %>');"><%=i %></a></li>
   	<%} %>
<%} %>
 </ul>
</div>

</form>
</body>
</html>