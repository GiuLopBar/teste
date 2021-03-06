<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/" var="raiz" />
<c:url value="/assets" var="assets" />
<c:url value="/app/producao/salvar" var="urlSalvarProducao" />


<!DOCTYPE html>
<html>
<head>
<c:import url="../templates/head.jsp" />
</head>
<body>
	<c:import url="../templates/header.jsp" />
	<main class="container read-container">
	<form:form action="${urlSalvarProducao}" method="post"
		class="grid-flex" modelAttribute="producao">
		<h1 class="titulo">Salvar Item de Produ��o</h1>
		<form:hidden path="id" />
		<div class="row">
			<div class="col flex-1">
				<form:label path="data">data</form:label>
				<form:input path="data" id="data" type="date" />
				<form:errors path="data" cssClass="erro" element="div" />
			</div>
		</div>

		<div class="row">
			<div class="col flex-1">
				<form:select path="item.id">
					<form:options items="${itens}" itemLabel="nome" itemValue="id" />
					<form:errors path="item.id" cssClass="erro" element="div" />
				</form:select>
			</div>
		</div>

		<div class="row">
			<div class="col flex-1">
				<form:label path="itensAprovados">Itens Aprovados</form:label>
				<form:input path="itensAprovados" id="aprovados" />
				<form:errors path="itensAprovados" cssClass="erro" element="div" />
			</div>
		</div>

		<div class="row">
			<div class="col flex-1">
				<form:label path="itensReprovados">Itens Reprovados</form:label>
				<form:input path="itensReprovados" id="reprovados" />
				<form:errors path="itensReprovados" cssClass="erro" element="div" />
			</div>
		</div>

		<div class="row">
			<div class="col flex-1">
				<form:label path="itensProduzidos">Itens Produzidos</form:label>
				<form:input path="itensProduzidos" disabled="true" />
				<form:errors path="itensProduzidos" cssClass="erro" element="div" />
			</div>
		</div>

		<div class="row">
			<div class="col flex-1">
				<form:label path="prejuizoEstimado">Preju�zo Estimado</form:label>
				<form:input path="prejuizoEstimado" />
				<form:errors path="prejuizoEstimado" cssClass="erro" element="div" />
			</div>
		</div>

		<div class="row">
			<div class="col flex-1">
				<form:label path="email">E-mail</form:label>
				<form:input path="email"/>
				<form:errors path="email" cssClass="erro" element="div" />
			</div>
		</div>

		<p id="mensagemDeErro"></p>

		<div class="row btn-group">
			<button type="submit" class="btn btn-blue col flex-1"
				onclick="return validate()">SALVAR</button>
		</div>
	</form:form> </main>

	<script type="text/javascript">
		
	</script>

</body>
</html>