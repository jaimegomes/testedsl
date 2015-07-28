<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">
		<h1>Cadastrar Pessoa</h1>
		<springform:form method="post"
			action="${pageContext.request.contextPath}/pessoa/cadastrar.do"
			modelAttribute="pessoa">
			<div style="width: 300px;">

				<div class="form-group">
					<label for="nome">Nome:</label>
					<springform:input id="nome" path="nome" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label for="dataNascimento">Data de Nascimento
						(DD/MM/AAAA):</label>
					<springform:input id="dataNascimento" path="dataNascimento"
						type="text" maxlength="10" cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="cpf">CPF:</label>
					<springform:input id="cpf" path="cpf" cssClass="form-control"
						maxlength="14" />
				</div>
			</div>
			<input type="submit" value="Gravar" class="btn btn-primary" />
		</springform:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>

