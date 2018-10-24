<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ログイン画面</title>
</head>
<body>
<br/>
<h1 class="login big">ログイン画面</h1><br/><br/><br/><br/>
<form action="LoginServlet" method="post">



<c:if test="${errMsg3 != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg3}
		</div>
	</c:if>




<div class="container">

  <div class="row justify-content-center">
    <div class="col-4">
      <label style="font-weight: bold">ログインID</label>
    </div>
    <div class="col-4">
      <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="id" name="loginId">
    </div>
  </div>
  <br>
  <div class="row justify-content-center">
    <div class="col-4">
      <label style="font-weight: bold">パスワード</label>
    </div>
    <div class="col-4">
      <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="●●●●●" name="pass">
    </div>
  </div>
</div>
</div>
<br><br><br><br>
<p class="login"><input type="submit" value="　　ログイン　　"></p>
</form>
</body>
</html>