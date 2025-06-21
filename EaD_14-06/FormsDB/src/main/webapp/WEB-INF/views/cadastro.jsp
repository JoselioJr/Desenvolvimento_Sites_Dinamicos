<%@ include file="header.jspf" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <title>Cadastrar Produto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <main>
        <h1>Cadastro de Produto</h1>
        <form action="${pageContext.request.contextPath}/salvar" method="post" enctype="multipart/form-data">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required />

            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao" rows="4" required></textarea>

            <label for="preco">Preço:</label>
            <input type="number" step="0.01" id="preco" name="preco" required />

            <label for="file">Imagem:</label>
            <input type="file" id="file" name="file" />

            <button type="submit">Salvar</button>
        </form>
    </main>

    <%@ include file="footer.jspf" %>
</body>
</html>