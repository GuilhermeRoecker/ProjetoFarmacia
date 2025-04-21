document.addEventListener("DOMContentLoaded", function () {
    const errorMessage = document.getElementById("error-message");

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
        .then(response => {
            if (!response.ok) {
                throw new Error("Usuário ou senha inválidos."); // Força erro se status não for 2xx
            }
            return response.json();
        })
        .then(data => {
            localStorage.setItem("auth_token", data.token);
            window.location.href = "/www/inicio/";
        })
        .catch(error => {
            errorMessage.textContent = error.message;
            errorMessage.style.display = "block";
        });
    });
});
