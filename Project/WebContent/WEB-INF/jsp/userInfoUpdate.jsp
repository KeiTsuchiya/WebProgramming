<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザ情報更新</title>
</head>
<body>
<p class="head">
<c:out value="${userInfo.name}さん" />　　　　<a class="user" href="LogoutServlet">ログアウト</a><label>　</label></p>
<br/>
<h1 class="login font-italic big">ユーザ情報更新</h1><br/><br/><br/>

<c:if test="${errMsg2 != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg2}
		</div>
	</c:if>

<form action="UserInfoUpdateServlet" method="post">
<div class="container-fluid input-area">
  <div class="row">
    <div class="col-6">
      <label class="user3">ログインID</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <label class="user5">${reference2.loginId}${keep2.loginId}</label>
    <input type="hidden" name="loginId" value="${reference2.loginId}${keep2.loginId}">
    </div>
  </div>
  <br/>
  <div class="row">
    <div class="col-6">
      <label class="user3">パスワード</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <input type="text" class="form-control" id="exampleFormControlInput1" name="pass">
    </div>
  </div>
  <br/>
  <div class="row">
    <div class="col-6">
      <label class="user3">パスワード(確認)</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <input type="text" class="form-control" id="exampleFormControlInput1" name="passCheck">
    </div>
  </div>
  <br/>
  <div class="row">
    <div class="col-6">
      <label class="user3">ユーザ名</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <input type="text" class="form-control" id="exampleFormControlInput1" value="${keep2.name}" name="name">
    </div>
  </div>
  <br/>
  <div class="row">
    <div class="col-6">
      <label class="user3">生年月日</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <input type="date" class="form-control" id="exampleFormControlInput1" value="${keep2.birthDateStr}" name="birthDate">
    </div>
  </div>
  </div>
  <br/>
  <br/>
  <br/>
  <p class="login">
<input type="submit" value="　　　更新　　　">
	</p></form>
	<br/>
<a class="user4" href="UserListServlet"><label>　　</label>戻る</a>
</body>
</html>