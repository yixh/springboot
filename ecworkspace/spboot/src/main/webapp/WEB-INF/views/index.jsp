<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../common/css/bootstrap.css" />
<script type="text/javascript" src="../common/js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../common/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function() {
		$(".xiugai").on("click", function() {
			var userName = $(this).closest(".tongji").find(".userName").text();
			$(".modal-body").text(userName);
		})
	})
</script>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">首页</a></li>
					<li><a href="#">简介</a></li>
					<li class="disabled"><a href="#">信息</a></li>
					<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">下拉<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#">操作</a></li>
							<li><a href="#">设置栏目</a></li>
							<li><a href="#">更多设置</a></li>
							<li class="divider"></li>
							<li><a href="#">分割线</a></li>
						</ul></li>
				</ul>
				<div id="wrapper" class="container">
					<div id="list" class="wrapper wrapper-content animated fadeInRight">
						<!--表格部分-->
						<div class="ibox-content" style="margin-top: 20px;">
							<div class="row">
								<div>
									<table
										class="table table-striped table-bordered table-hover dataTables-example">
										<thead>
											<tr>
												<th align="center"><input type="checkbox"
													id="SelectAll" onClick="selectAllUser()" /> 全选</th>
												<th>用户名</th>
												<th>用户密码</th>
												<th>用户身高</th>
												<th>修改时间</th>
												<th>注册日期</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="user">
												<tr class="tongji">
													<td><input type="checkbox" id="subcheck"
														name="subcheck" value="${user.id}" /></td>
													<td class="userName">${user.userName}</td>
													<td>${user.passWord}</td>
													<td></td>
													<td></td>
													<td><a class="btn btn-success"
														href="/SelectUserById?id=${user.id}">修改</a></td>
													<td><button type="button"
															class="btn btn-primary btn-lg xiugai" data-toggle="modal"
															data-target="#myModal">xiugai</button></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body"> ${user.userName}</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

