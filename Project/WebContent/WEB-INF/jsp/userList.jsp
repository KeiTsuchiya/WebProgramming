<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザー覧</title>
</head>
<body>
<p class="head">
<c:out value="${userInfo.name}" />さん　　　　<a class="user" href="LogoutServlet">ログアウト</a><label>　</label></p>
<br/>
<h1 class="login font-italic big">ユーザー覧</h1><br/>
<p class="user2"><a href="UserSignUpServlet">新規登録</a><label>　　</label></p>





<form action="UserListServlet" method="post">
<div class="container-fluid">
  <div class="row">
    <div class="col">
      <label class="user3">ログインID</label>
    </div>
    <div class="col-5">
    <input type="text" class="form-control" id="exampleFormControlInput1" name="loginId"><br/>
    </div>
    <div class="col">
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label class="user3">ユーザー名</label>
    </div>
    <div class="col-5">
      <input type="text" class="form-control" id="exampleFormControlInput1" name="name"><br/>
    </div>
    <div class="col">
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label class="user3">生年月日</label>
    </div>
    <div class="col">
    </div>
    <div class="col-2">
    <input type="date" class="form-control" id="exampleFormControlInput1" placeholder="年/月/日" name="fromBirthDate">
    </div>
    <div class="col-1">
    <label style="margin: 9px">〜</label>
    </div>
    <div class="col-2">
    <input type="date" class="form-control" id="exampleFormControlInput1" placeholder="年/月/日" name="toBirthDate">
    </div>
    <div class="col">
    </div>
    <div class="col">
    </div>
  </div>
  </div>
<p style="text-align: right"><input type="submit" value="　　　検索　　　"><label>　　</label></p>
<hr></form>






<div class="table-responsive">
             <table class="table table-striped">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>


                 <c:forEach var="user" items="${userList}" >

                   <tr>

                     <td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.birthDate}</td>

                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
                     <td>
                       <a class="btn btn-primary" href="UserInfoReferenceServlet?id=${user.id}">詳細</a>

					<c:if test="${userInfo.loginId == 'admin'|| user.loginId.equals(userInfo.loginId)}">
                       <a class="btn btn-success" href="UserInfoUpdateServlet?id=${user.id}">更新</a>
					</c:if>

					<c:if test="${userInfo.loginId == 'admin'}" >
                       <a class="btn btn-danger" href ="UserDeleteConfirmServlet?id=${user.id}">削除</a>
					</c:if>

                     </td>
                   </tr>
                 </c:forEach>

               </tbody>
             </table>
<br/>
</body>
</html>