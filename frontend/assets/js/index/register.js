document.querySelector("#register-form").addEventListener("submit", async function (e) {
    e.preventDefault();

    const formDataName = document.querySelector("#name").value;
    const formDataEmail = document.querySelector("#email").value;
    const formDataPassword = document.querySelector("#password").value;
    const formDataConfirmPassword = document.querySelector("#confirm-password").value;

    if (!formDataName || !formDataEmail || !formDataPassword || !formDataConfirmPassword) {
        throw new Error("Todos os campos são obrigatórios.");
        messageEl.innerHTML = `<span class="error-message">Por favor, preencha todos os campos.</span>`;
        return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(formDataEmail)) {
        throw new Error("Email inválido.");
        messageEl.innerHTML = `<span class="error-message">Por favor, insira um email válido.</span>`;
        return;
    }

    if (formDataPassword.lenght < 5) {
        throw new Error("Senha muito curta.");
        messageEl.innerHTML = `<span class="error-message">A senha deve ter pelo menos 5 caracteres.</span>`;
        return;
    }

    if (formDataPassword !== formDataConfirmPassword) {
        throw new Error("Senhas não coincidem.");
        messageEl.innerHTML = `<span class="error-message">As senhas não coincidem.</span>`;
        return;
    }

    try {
        const response = await fetch("http://localhost:8080/freelancers/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                name: formDataName,
                email: formDataEmail,
                password: formDataPassword,
                confirmPassword: formDataConfirmPassword
            })
        });

        const messageEl = document.querySelector("#message");
        if (response.ok) {
            messageEl.innerHTML = `<span class="success-message">Usuário cadastrado com sucesso!</span>`;
            document.querySelector("#register-form").reset();
        } else {
            const errorData = await response.text();
            messageEl.innerHTML = `<span class="error-message">${errorData}</span>`;
        }

    } catch (error) {
        document.querySelector("#message").innerHTML = `<span class="error-message">Erro de conexão com o servidor.</span>`;
    }

})