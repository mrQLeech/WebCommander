<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 09.02.2016
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>WebCommander</title>
    <link href="./Styles/bootstrap.css" rel="stylesheet" />
    <link href="./Styles/main.css"rel="stylesheet"/>
    <script src="Scripts/jquery.js" type="text/javascript"></script>
    <script src="Scripts/main.js" type="text/javascript"></script>

  </head>
  <body>
    <div class="container back-area-container">
      <div class="container main-container border-area">
        <jsp:include page="Views/navBar.jsp"></jsp:include>
        <div class="main-area">
            <jsp:include page="Views/filesPanel.jsp"></jsp:include>
            <jsp:include page="Views/filesPanel.jsp"></jsp:include>

        </div>
      </div>
    </div>
    <div class="container splash-panel">


    </div>

    <div class="create-folder-form-panel inline-item border-area-inner">
      <label class="fs-label">Имя директории: </label>
      <input type="text" class="fs-path folder-name inline-item doted-area border-area-inner" >
      <div class="do-button create-folder inline-item doted-area border-area-inner">Ок</div>
      <div class="do-button cancel inline-item doted-area border-area-inner">Отмена.</div>
    </div>


  </body>
</html>
