<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Band With</title>
</head>
<body>
    <form name="fileUpload" method="post" action="/upload" enctype="multipart/form-data">
        <label>파일 업로드 테스트</label> <br><br>
        <input type="file" name="file"/>
        <input type="submit" name="submit" value="업로드"/>
    </form>
</body>
</html>
