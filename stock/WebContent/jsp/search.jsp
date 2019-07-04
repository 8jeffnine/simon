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
<form name="form" method="post" action="./search.do">
<input type="hidden" name="page" />
<input type="hidden" name="startdt" />
<input type="hidden" name="compcd" />

<jsp:include page="menu.jsp" flush="false"/>

<div class="row">
 <div class="col-sm-4"></div>
 <div class="col-sm-4">
   <div class="input-group">
   	<c:if test="${keyword eq null }">
     <input type="text" class="form-control" placeholder="input search keyword" name="keyword">
    </c:if>
    <c:if test="${keyword ne null }">
     <input type="text" class="form-control" placeholder="input search keyword" name="keyword" value='<c:out value="${keyword }"/>'>
    </c:if>
     <div class="input-group-btn">
       <button class="btn btn-default" type="submit">
         <i class="glyphicon glyphicon-search"></i>
       </button>
     </div>
   </div>
 </div>
 <div class="col-sm-4"></div>
</div>

<div class="container">
 <p>&nbsp;</p>
 <p>Click <b>#Date</b>(if you want to find more information about price by company code), <b>#Title</b>, <b>#Content</b>(connected to article), <b>#Tag</b>(if you want to show about historical chart directly)</p>
 <table class="table table-hover">
   <thead>
   <tr>
     <th width=10%>Date</th>
     <th width=*>Title</th>
     <th width=10%>Content</th>
     <th width=5%>Company</th>
     <th width=10%>Tag</th>
     <th width=5%>N/A</th>
   </tr>
   </thead>
   <tbody>
   <c:if test="${fn:length(newsList) > 0}">
   <c:forEach items="${newsList}" var="news">
   <tr>
     <td onClick="script:goChart('${news.pubDate }','');">
     	${news.pubDate }
     </td>
     <td>${news.title }</td>
     <td onClick="script:goNewsContent('${news.content }')">View</td>
     <td>${news.press }</td>
     <td>
<%-- 		<c:if test="${fn:length(stockList) > 0}">
			<c:forEach items="${stockList}" var="stock">
				<c:if test="${fn:indexOf(news.title, stock.compnm) > -1}">
				<span class="badge" onClick="script:goChart('${news.pubDate }','${stock.compcd}');">${stock.compnm }</span>
				</c:if>
			</c:forEach>
		</c:if> --%>
	 &nbsp;</td>
     <td>&nbsp;</td>
   </tr>
   </c:forEach>
   </c:if>
   <c:if test="${fn:length(newsList) eq 0}">
   <tr>
     <td colspan="6">There is empty.</td>
   </tr>
   </c:if>
   </tbody>
 </table>
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