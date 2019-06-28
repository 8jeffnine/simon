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
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="msg">
			<blockquote><h3>Scrap Target Registration</h3></blockquote>		  
		  </label>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">Site(x-y-z):</label>
		  <input type="text" class="form-control" id="scrap_src" placeholder="ex) news-mk-page1"/>
		</div>
	</div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">Parser:</label>
		  <input type="text" class="form-control" id="scrap_prs" placeholder="ex) nvnw"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="usr">Url:</label>
		  <input type="text" class="form-control" id="s_url" placeholder="ex) https://news.naver.com/list.nhn?...."/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">Param Value Type:</label>
		  <select class="form-control" id="p_val">
			<c:if test="${fn:length(cdInfo) > 0}">
			<c:forEach items="${cdInfo}" var="info">
		  	<option value="${info.detail_cd }">${info.cd_name }</option>
			</c:forEach>
			</c:if>
		  </select>
		   <input type="text" class="form-control" id="p_key" placeholder="ex) date"/>
		</div>
	</div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">Param Value:</label>
		  <input type="text" class="form-control" id="p_st" placeholder="ex) 20190526"/>
		  <input type="text" class="form-control" id="p_en" placeholder="ex) 20190601"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">DOM Structure:</label>
		  <input type="text" class="form-control" id="dom_val" placeholder="ex) body.table.tr.td"/>
		</div>
	</div>
	 <div class="col-sm-3">
		<div class="form-group">
		  <label for="usr">Request Header:</label>
		   <select class="form-control" id="req_header_val">
			<c:if test="${fn:length(reqHeaderInfo) > 0}">
			<c:forEach items="${reqHeaderInfo}" var="req">
		  	<option value="${req.detail_cd }">${req.cd_name }</option>
			</c:forEach>
			</c:if>
		  </select>
		</div>
	</div>
	 <div class="col-sm-1">
		<div class="form-group">
		  <label for="usr">&nbsp;</label>
		  <button class="form-control">Add</button>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-12">&nbsp;</div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-6"></div>
	<div class="col-sm-2" align=right>
		<button class="btn btn-warning">Cancel</button>
		<button class="btn btn-primary" onClick="goURL('scrapComReg')">Save</button>
	</div>
	<div class="col-sm-2"></div>
</div>

</form>
</body>
</html>