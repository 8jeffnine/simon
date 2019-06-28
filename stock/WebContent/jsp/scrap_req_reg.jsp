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

<jsp:include page="menu.jsp" flush="false"/>

<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="msg">
			<blockquote><h3>Http Request Header Registration</h3></blockquote>		  
		  </label>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
 
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Name:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_nm" name="req_nm" placeholder="ex) NaverNEWS"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Method:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_mth" name="req_mth" placeholder="ex) GET"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Accept:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_acc" name="req_acc" placeholder="ex) text/html"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Accept-Encoding:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_acen" name="req_acen" placeholder="ex) deflate"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Accept-Language:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_aclg" name="req_aclg" placeholder="ex) ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,ja;q=0.6"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Cache-Control:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_cach" name="req_cach" placeholder="ex) max-age=0"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Connection:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_con" name="req_con" placeholder="ex) keep-alive"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">DNT:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_dnt" name="req_dnt" placeholder="ex) 1"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Cookie:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_ck" name="req_ck" placeholder="ex) webid=5d801330a2354905a925ebb27673b6db; ssab=784_1;"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Host:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_host" name="req_host" placeholder="ex) news.naver.com"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Referer:</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_ref" name="req_ref" placeholder="ex) https://news.naver.com/list?..."/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">Upgrade-Insecure-Requests</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_uir" name="req_uir" placeholder="ex) 1"/>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-2">
		<div class="form-group">
		  <label for="usr">User-Agent</label>
		</div>
	</div>
	 <div class="col-sm-6">
		<div class="form-group">
		  <input type="text" class="form-control" id="req_agent" name="req_agent" placeholder="ex) Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"/>
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
		<button class="btn btn-warning" >Cancel</button>
		<button class="btn btn-primary" onClick="goURL('scrapReqSave');">Save</button>
	</div>
	<div class="col-sm-2"></div>
</div>

</form>
</body>
</html>