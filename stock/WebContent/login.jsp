<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- <!DOCTYPE html> -->
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
 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login</title>
</head>
<body>
<form name="form" method="post" action="loginCheck.do">
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="msg">
			<blockquote><h1>LOGIN</h1></blockquote>		  
		  </label>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		
		<div class="form-group">
		  <label for="usr">Email:</label>
		  <input type="text" class="form-control" id="email" name="email">
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<div class="form-group">
		  <label for="pwd">Password:</label>
		  <input type="password" class="form-control" id="pwd" name="pwd">
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<button type="submit" class="btn btn-primary btn-block" onCilck="document.form.submit();">로그인</button>
	</div>
	<div class="col-sm-2"></div>
</div>
<div class="row">
	<div class="col-sm-12">&nbsp;</div>
</div>
<div class="row">
	<div class="col-sm-2"></div>
	 <div class="col-sm-8">
		<button type="button" class="btn btn btn-md">아이디/비밀번호 찾기</button>
		<button type="button" class="btn btn btn-md">회원가입</button>
	</div>
	<div class="col-sm-2"></div>
</div>

</form>
</body>
</html>