<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Eventos::</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
rel="stylesheet">
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
<div class="container-fluid">
<a class="navbar-brand" href=<c:url value="/" />> Gestão de Eventos  </a>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
data-bs-target="#navbarSupportedContent"
aria-controls="navbarSupportedContent" aria-expanded="false"
aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<li class="nav-item"><a class="nav-link " href=<c:url value="/eventos/incluir" />>Incluir Evento</a></li>
<li class="nav-item">Listar Eventos</li>
<li class="nav-item"><a class="nav-link" href="#">Buscar Evento</a></li>
</ul>

</div>
</div>
</nav>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container">
<div>
<h2>Lista Evento</h2>
</div>
<table class="table table-striped">
<thead>
<tr>
<th>ID</th>
<th>DESCRIÇÃO</th>
<th>DATA</th>
<th>RESPONSÁVEL</th>
<th>PREÇO</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>

<c:forEach var="ev" items="${eventos}">
<tr>
<td>${ev.id}</td>
<td>${ev.descricao}</td>
<td><fmt:formatDate value="${ev.data}" pattern="dd/MM/yyyy" /></td>
<td>${ev.responsavel}</td>

<td><fmt:formatNumber value="${ev.preco}" type="currency" /></td>
<td>
<a href=<c:url value="/eventos/alterarEvento/${ev.id}" />>Alterar</a>
<button type="button" class="btn btn-danger remove"
data-id="${ev.id}" data-bs-toggle="modal" data-bs-target="#modal">Remover</button>

</td>

</tr>
</c:forEach>

</tbody>
</table>
</div>
<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog">
   <div class="modal-content">
<!--    Cabecalho (header) -->
     <div class="modal-header">
       <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
       <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
     </div>
<!--      Conteúdo (body) -->
     <div class="modal-body">
       <h4>Tem certeza que deseja remover esse evento?</h4>
     </div>
<!--      Rodapé (footer) -->
     <div class="modal-footer">
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não, voltar para lista</button>
       <button type="button" id="btnRemover" class="btn btn-danger" data-bs-dismiss="modal">Sim, remover</button>
     </div>
   </div>
 </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
<script>
$(document).ready(function() {
let id;
$('.remove').click(function() {
id = $(this).attr('data-id');
});
$('#btnRemover').click(function() {

let url = "http://localhost:8080/Projeto01_Eventos_SpringMVC/eventos/excluirEvento/" + id;
$(location).attr('href', url);
})
});
</script>
</body>
</html>
