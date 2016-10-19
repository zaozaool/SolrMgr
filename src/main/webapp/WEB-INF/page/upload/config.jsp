<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上传Config</title>
</head>
<body>
	<form action="/SolrMgr/api/upload/config" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> 
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
