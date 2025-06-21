<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Produtos com Filtros</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Produtos com Filtros</h1>
        
        <!-- Formulário de Filtros -->
        <form method="get" action="${pageContext.request.contextPath}/produtos/filtrados">
            <div class="filtros">
                <input type="text" name="nome" placeholder="Nome do produto" value="${nome}">
                <input type="number" name="precoMin" placeholder="Preço mínimo" step="0.01" value="${precoMin}">
                <input type="number" name="precoMax" placeholder="Preço máximo" step="0.01" value="${precoMax}">
                <button type="submit">Filtrar</button>
                <a href="${pageContext.request.contextPath}/produtos/filtrados">Limpar</a>
            </div>
        </form>
        
        <!-- Lista de Produtos -->
        <div class="produtos">
            <c:forEach var="produto" items="${produtos}">
                <div class="produto-item">
                    <h3>${produto.nome}</h3>
                    <p>${produto.descricao}</p>
                    <p>Preço: R$ ${produto.preco}</p>
                </div>
            </c:forEach>
        </div>
        
        <!-- Paginação -->
        <div class="paginacao">
            <c:if test="${paginaAtual > 1}">
                <a href="?nome=${nome}&precoMin=${precoMin}&precoMax=${precoMax}&page=${paginaAtual - 2}">Anterior</a>
            </c:if>
            
            <span>Página ${paginaAtual} de ${totalPaginas}</span>
            
            <c:if test="${paginaAtual < totalPaginas}">
                <a href="?nome=${nome}&precoMin=${precoMin}&precoMax=${precoMax}&page=${paginaAtual}">Próxima</a>
            </c:if>
        </div>
        
        <a href="${pageContext.request.contextPath}/">Voltar</a>
    </div>
</body>
</html>