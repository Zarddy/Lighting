<%--
  Created by IntelliJ IDEA.
  User: Vision
  Date: 2019/3/13
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    单个文件上传：<br/>
    <form action="/uploadSingleFile" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="提交上传">
    </form>

    <br>
    <br>
    <br>

    多个文件上传：<br>
    <form action="/uploadMultipartFiles" method="post" enctype="multipart/form-data">
        文件1：<input type="file" name="files"><br>
        文件2：<input type="file" name="files"><br>
        文件3：<input type="file" name="files"><br>
        <input type="submit" value="上传多个文件">
    </form>

</body>
</html>
