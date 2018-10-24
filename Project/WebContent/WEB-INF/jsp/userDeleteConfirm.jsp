<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザ削除確認</title>
</head>
<body>


<p class="head">
<c:out value="${userInfo.name}さん" />　　　　<a class="user" href="LogoutServlet">ログアウト</a><label>　</label></p>
<br/>
<h1 class="login font-italic big">ユーザ削除確認</h1><br/>


<p class="input-area">ログインID:　${reference3.loginId}<br>を本当に削除してよろしいでしょうか。</p><br/><br/><br/><br/>

<form action="UserDeleteConfirmServlet" method="post">

<div class="container-fluid input-area2">
  <div class="row">
    <div class="col">
      <input type="submit" value="　キャンセル　" name="cancel">
      <input type="hidden" name="loginId" value="${reference3.loginId}">
    </div>
    <div class="col">
    <input type="submit" value="　　　OK　　　" name="ok">
    </div>
  </div>
  </form>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</body>
</html>