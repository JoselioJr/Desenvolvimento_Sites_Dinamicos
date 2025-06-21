<%@ include file="header.jspf" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <title>Lista de Produtos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <main>
        <h2>Produtos Cadastrados</h2>
        <table class="produtos-tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descri��o</th>
                    <th>Pre�o (R$)</th>
                    <th>Arquivo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${produtos}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.nome}</td>
                        <td>${p.descricao}</td>
                        <td>${p.preco}</td>
                        <td>
                            <c:if test="${not empty p.nomeArquivo}">
                                <a href="${pageContext.request.contextPath}/uploads/${p.nomeArquivo}" target="_blank" rel="noopener noreferrer">${p.nomeArquivo}</a>
                            </c:if>
                            <c:if test="${empty p.nomeArquivo}">
                                -
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="paginacao">
            <c:if test="${paginaAtual > 1}">
                <a href="${pageContext.request.contextPath}/produtos?pagina=${paginaAtual - 1}">Anterior</a>
            </c:if>
            
            <c:forEach begin="1" end="${totalPaginas}" var="i">
                <c:choose>
                    <c:when test="${i == paginaAtual}">
                        <span class="pagina-atual">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/produtos?pagina=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
            <c:if test="${paginaAtual < totalPaginas}">
                <a href="${pageContext.request.contextPath}/produtos?pagina=${paginaAtual + 1}">Proxima</a>
            </c:if>
        </div>
        
        <a class="btn-voltar" href="${pageContext.request.contextPath}/">Voltar</a>
    </main>
<%@ include file="footer.jspf" %>
</body>
</html>