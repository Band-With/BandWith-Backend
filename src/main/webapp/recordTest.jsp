<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Band With</title>
</head>
<body>
    <form name="fileUpload" method="post" action="/member/1/records" enctype="multipart/form-data">
        <label>파일 업로드 테스트</label> <br><br>
        <input type="file" name="file"/>
        <input type="submit" name="submit" value="업로드"/>
    </form>
    <br>
    <form name="fileDelete" method="post" action="/member/1/records">
        <input type="hidden" name="_method" value="delete" />
        <label>파일 삭제 테스트</label> <br><br>
        <label>파일 이름</label>
        <input type="text" name="fileName"/>
        <input type="submit" name="submit" value="삭제"/>
    </form>
    <br>
    <form name="fileUrl" method="post" action="/records/1">
        <label>파일 URL 이동 테스트</label> <br><br>
        <label>파일 이름</label>
        <input type="text" name="fileName"/>
        <input type="submit" name="submit" value="이동"/>
    </form>
</body>
</html>
