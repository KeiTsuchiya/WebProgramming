<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザ情報詳細参照</title>
</head>
<body>
<p class="head">
<c:out value="${userInfo.name}さん" />　　　　<a class="user" href="LogoutServlet">ログアウト</a><label>　</label></p>
<br/>
<h1 class="login font-italic big">ユーザ情報詳細参照</h1><br/><br/><br/>


<div class="container-fluid input-area">
  <div class="row">
    <div class="col-6">
      <label class="user3">ログインID</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <label class="user5">${reference.loginId}</label>
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
    <label class="user5">${reference.name}</label>
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
    <label class="user5">${reference.birthDate}</label>
    </div>
  </div>
  <br/>
  <div class="row">
    <div class="col-6">
      <label class="user3">登録日時</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <label class="user5">${reference.createDate}</label>
    </div>
  </div>
  <br/>
  <div class="row">
    <div class="col-6">
      <label class="user3">更新日時</label>
    </div>
    <div class="col-1">
    </div>
    <div class="col-5">
    <label class="user5">${reference.updateDate}</label>
    </div>
  </div>
  </div>
  <br/><br/>
<a class="user4" href="UserListServlet"><label>　　</label>戻る</a>
</body>
</html>