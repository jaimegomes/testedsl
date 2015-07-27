<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>

	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">

		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-1">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>

			</button>
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/index.jsp">In�cio</a>
		</div>

		<div class="collapse navbar-collapse" id="navbar-1">

			<ul class="nav navbar-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Pessoas<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">

						<li><a
							href="${pageContext.request.contextPath}/preparaCadastroPessoa.do">Cadastrar</a></li>

						<li><a
							href="${pageContext.request.contextPath}/pessoa/listar.do">Listar</a></li>

					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Livros<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="${pageContext.request.contextPath}/preparaCadastroLivro.do">Cadastrar</a></li>
						<li><a
							href="${pageContext.request.contextPath}/livro/listar.do">Listar</a></li>

					</ul></li>
				<li><a
					href="${pageContext.request.contextPath}/preparaCadastroEmprestimo.do">Realizar
						/ Visualizar Empr�stimo</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<c:if test="${mensagem != null}">
		<div class="${mensagem.tipoMensagem.classeCss}" role="alert">${mensagem.texto}</div>
	</c:if>
	<div class="panel panel-default">
		<div class="panel-body">
			<tiles:insertAttribute name="corpo" />
		</div>
	</div>
</body>
</html>


