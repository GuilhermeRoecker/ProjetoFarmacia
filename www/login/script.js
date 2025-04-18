document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("loginForm").addEventListener("submit", function (event) {
        event.preventDefault();

        const username = document.querySelector('input[name="username"]').value;
        const password = document.querySelector('input[name="password"]').value;

        const formData = new URLSearchParams();
        formData.append("username", username);
        formData.append("password", password);

        fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: formData.toString()
        })        
        .then(response => response.json())
        .then(data => {
            localStorage.setItem("auth_token", data.token);
            alert("Login bem-sucedido!");
            window.location.href = "/www/inicio/";  // Corrigido
        })        
        .catch(error => {
            alert("Usuário ou senha inválidos.");
        });
    });
});
