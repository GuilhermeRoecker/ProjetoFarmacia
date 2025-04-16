document.addEventListener("DOMContentLoaded", function () { 
    document.getElementById("loginForm").addEventListener("submit", function (event) {
        event.preventDefault(); // Evita o reload da página

        const username = document.querySelector('input[name="username"]').value;
        const password = document.querySelector('input[name="password"]').value;

        fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            credentials: "include", // Importante para enviar cookies/sessão
            body: new URLSearchParams({
                username: username,
                password: password
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Usuário ou senha inválidos.");
            }
            return response.json(); // Isso só funciona se o servidor retornar JSON
        })
        .then(data => {
            alert("Login bem-sucedido!");
            // Redireciona para outra página, se quiser
            // window.location.href = "pagina-principal.html";
        })
        .catch(error => {
            alert(error.message);
        });
    });
});
