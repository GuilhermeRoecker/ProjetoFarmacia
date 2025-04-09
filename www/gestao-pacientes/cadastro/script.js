// Garante que apenas um tipo de pessoa pode ser selecionado
function selecionarTipo(el) {
    document.querySelectorAll('input[name="tipoPessoa"]').forEach(input => {
        if (input !== el) input.checked = false;
    });
}

document.getElementById("formCadastro").addEventListener("submit", async function(e) {
    e.preventDefault();

    const tipoPessoaSelecionada = document.querySelector('input[name="tipoPessoa"]:checked');

    const cliente = {
        nome: document.getElementById("nome").value,
        dtNascimento: document.getElementById("nascimento").value,
        documento: document.getElementById("cpf").value,
        telefone: document.getElementById("telefone").value,
        email: document.getElementById("email").value,
        pessoaTipo: tipoPessoaSelecionada ? tipoPessoaSelecionada.value : null,
        endereco: {
            rua: document.getElementById("rua").value,
            numero: document.getElementById("numero").value,
            bairro: document.getElementById("bairro").value,
            cidade: document.getElementById("cidade").value,
            estado: document.getElementById("estado").value,
            cep: document.getElementById("cep").value
        }
    };

    try {
        const response = await fetch("http://localhost:8080/clientes", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cliente)
        });

        if (response.ok) {
            alert("Cliente cadastrado com sucesso!");
            document.getElementById("formCadastro").reset();
        } else {
            const error = await response.text();
            alert("Erro ao cadastrar: " + error);
        }
    } catch (error) {
        alert("Erro na requisição: " + error);
    }
});
