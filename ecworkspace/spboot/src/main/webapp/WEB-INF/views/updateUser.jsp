<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../common/css/bootstrap.css" />
<script type="text/javascript" src="../common/js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../common/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form">
				<div class="form-group">
					 <label for="exampleInputEmail1">userName</label>
					 <input type="email" class="form-control" id="userName" value="${user.userName}"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label>
					 <input type="password" class="form-control" id="passWord" value="${user.passWord}"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">File input</label>
					 <input type="file" id="exampleInputFile" value=""/>
					<p class="help-block">
						Example block-level help text here.
					</p>
				</div>
				<div class="checkbox">
					 <label><input type="checkbox" />Check me out</label>
				</div> <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>