<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% int pages = !"".equals(request.getAttribute("page")) && request.getAttribute("page") != null ? Integer.parseInt((String)request.getAttribute("page") ) : 1; %>
<!DOCTYPE html>
<html>
<head>
 <title>Stock >> Company Code Registration for Scrap</title>
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
	<input type="hidden" name="gbn"/>
<jsp:include page="menu.jsp" flush="false"/>

<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="msg">
			<blockquote><h3>Company Code Registration</h3></blockquote>		  
		  </label>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<c:if test="${comList ne null}">
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="usr">종목명:</label>
		  <input type="text" class="form-control" id="co_nm" name="co_nm" placeholder="ex) news-mk-page1" value="${co_nm }"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="usr">종목코드:</label>
		  <input type="text" class="form-control" id="co_cd" name="co_cd" placeholder="ex) news-mk-page1" value="${co_cd }"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-3">
		<div class="form-group">
		  <label for="usr">시작일:</label>
		  <input type="text" class="form-control" id="st_dt" name="st_dt" placeholder="ex) news-mk-page1" value="${st_dt }"/>
		</div>
	</div>
	 <div class="col-sm-3">
		<div class="form-group">
		  <label for="usr">종료일:</label>
		  <input type="text" class="form-control" id="en_dt" name="en_dt" placeholder="ex) news-mk-page1" value="${en_dt }"/>
		</div>
	</div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">사용여부:</label>
		  <input type="text" class="form-control" id="use_yn" name="use_yn" placeholder="ex) news-mk-page1" value="${use_yn }"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">카테고리1:</label>
		  <input type="text" class="form-control" id="cat01" name="cat01" placeholder="ex) news-mk-page1" value="${cat01 }"/>
		</div>
	</div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">카테고리2:</label>
		  <input type="text" class="form-control" id="cat02" name="cat02" placeholder="ex) news-mk-page1" value="${cat02 }"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">카테고리3:</label>
		  <input type="text" class="form-control" id="cat03" name="cat03" placeholder="ex) news-mk-page1" value="${cat03 }"/>
		</div>
	</div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">카테고리4:</label>
		  <input type="text" class="form-control" id="cat04" name="cat04" placeholder="ex) news-mk-page1" value="${cat04 }"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-4">
		<div class="form-group">
		  <label for="usr">카테고리5:</label>
		  <input type="text" class="form-control" id="cat05" name="cat05" placeholder="ex) news-mk-page1" value="${cat05 }"/>
		</div>
	</div>
	<div class="col-sm-4"></div>
	<div class="col-sm-2"></div>
</div>
</c:if>
<div class="row">
	<div class="col-sm-12">&nbsp;</div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8" align=right>
		<button class="btn btn-warning">Cancel</button>
		<button class="btn btn-primary" onClick="goURL2('scrapComRegProc','I');">Save</button>
		<button class="btn btn-primary" onClick="goURL2('scrapComRegProc','U');">Modify</button>
		<button class="btn btn-primary" onClick="goURL2('scrapComRegProc','D');">Delete</button>
	</div>
	<div class="col-sm-2"></div>
</div>

</form>
</body>
</html>