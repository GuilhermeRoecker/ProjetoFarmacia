document.addEventListener("DOMContentLoaded", function () {
    // Função para verificar se o usuário está logado
    function checkIfLoggedIn() {
        // Aqui você pode usar um método de verificação, como o uso de cookies ou sessionStorage.
        // Suponha que um cookie chamado 'auth_token' indique que o usuário está logado.
        // Você pode adaptar essa parte conforme sua implementação de login.

        const isLoggedIn = document.cookie.includes("auth_token");

        if (isLoggedIn) {
            // Redirecionar para a página inicial se estiver logado
            window.location.href = "www/inicio/index.html";
        } else {
            // Redirecionar para a página de login se não estiver logado
            window.location.href = "www/login/index.html";
        }
    }

    checkIfLoggedIn();
});