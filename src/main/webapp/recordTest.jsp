<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Band With</title>
</head>
<body>
    <form name="fileUpload" method="post" action="/members/1/records" enctype="multipart/form-data">
        <label>파일 업로드 테스트</label> <br><br>
        <input type="file" name="file"/>
        <input type="submit" name="submit" value="업로드"/>
    </form>
    <br>
    <form name="fileDelete" method="post" action="/members/1/records/22">
        <input type="hidden" name="_method" value="delete" />
        <label>파일 삭제 테스트</label>
        <input type="submit" name="submit" value="삭제"/>
    </form>
    <br>
    <a href="/members/1/records/22" >파일 다운로드</a>
    <br>
    <br>
    <form name="fileUrl" method="post" action="/records/1/url">
        <label>파일 URL 이동 테스트</label>
<%--        <input type="submit" name="submit" value="이동"/>--%>
    </form>
    <form name="denoiseFile" method="post" action="/record/denoise" enctype="multipart/form-data">
        <label>잡음 제거 테스트</label> <br><br>
        <input type="file" name="file"/>
        <input type="submit" name="submit" value="잡음 제거"/>
    </form>
</body>
</html>
