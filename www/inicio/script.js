document.addEventListener("DOMContentLoaded", function () {
    function setupAuth() {
        const authToken = sessionStorage.getItem("auth_token") || localStorage.getItem("auth_token");
    
        if (!authToken) {
            // Sem token? Redireciona para login
            window.location.href = "../login/index.html";
            return;
        }
    
        // Intercepta o fetch globalmente para sempre mandar Authorization
        const originalFetch = window.fetch;
        window.fetch = function (url, options = {}) {
            options.headers = options.headers || {};
            options.headers["Authorization"] = "Bearer " + authToken;
    
            return originalFetch(url, options);
        };
    }

    setupAuth();


    // Função para o botão de logout
    const logoutBtn = document.getElementById("logout-btn");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function () {
            sessionStorage.removeItem("auth_token");
            localStorage.removeItem("auth_token");
            window.location.href = "../login/index.html"; // Redireciona para login
        });
    }
});