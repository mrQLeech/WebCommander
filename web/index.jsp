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
    <title>$Title$</title>
    <link href="./Styles/bootstrap.css" rel="stylesheet" />
    <link href="./Styles/main.css"rel="stylesheet"/>
  </head>
  <body>
    <div class="container">
      <div class="container main-container">
        <div class="row container buttons-container">
          <div class="do-button create-folder-button inline-item"></div>
          <div class="do-button load-file-button inline-item"></div>
          <div class="do-button move-button inline-item"></div>
          <div class="do-button copy-button inline-item"></div>
          <div class="do-button delete-button inline-item"></div>
        </div>
        <div class="main-area">
          <div class="row">
            <div class="nav-panel">
              <div class="container">
                <form class="nav-text-box">
                  <input type="text" class="fs-path">
                </form>
              </div>
              <div class="container file-panel-holder">
                <div class="file-panel">
                  <table class="file-table">
                    <thead>
                      <tr>
                        <td></td>
                        <td>Имя файла</td>
                        <td>Размер</td>
                        <td>Дата изменения</td>
                        <td>Только чтение</td>
                        <td>Архивный</td>
                        <td>Системный</td>

                      </tr>
                    </thead>
                  </table>
                </div>
              </div>
              <div class="container file-panel-holder">
                <div class="file-panel">
                  <table class="file-table">
                    <thead>
                    <tr>
                      <td></td>
                      <td>Имя файла</td>
                      <td>Размер</td>
                      <td>Дата изменения</td>
                      <td>Только чтение</td>
                      <td>Архивный</td>
                      <td>Системный</td>

                    </tr>
                    </thead>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
