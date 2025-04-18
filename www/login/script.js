document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("loginForm").addEventListener("submit", function (event) {
        event.preventDefault();

        const username = document.querySelector('input[name="username"]').value;
        const password = document.querySelector('input[name="password"]').value;

        const formData = new URLSearchParams();
        formData.append("username", username);
        formData.append("password", password);

        fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            credentials: "include",
            body: formData.toString()
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Usuário ou senha inválidos.");
            }
            alert("Login bem-sucedido!");
            // Redirecionar para o início
            window.location.href = "http://127.0.0.1:5500/www/inicio/"; // URL corrigida
        })
        .catch(error => {
            alert(error.message);
        });
    });
});
