document.addEventListener("DOMContentLoaded", () => {
    fetch("http://localhost:8080/customers")
        .then(response => response.json())
        .then(client => renderClients(client))
        .catch(error => {
            console.error("Erro ao buscar os clientes: ".error);
            document.querySelector(".client-list").innerHTML = "<p>Erro ao carregar os clientes.</p>";
        });
});

function renderClients(clients) {
    const list = document.querySelector(".client-list");
    if (clients.length === 0) {
        list.innerHTML = "<p>Nenhum cliente encontrado.</p>";
        return;
    }

    const ul = document.createElement("ul");
    clients.forEach(client => {
        const li = document.createElement("li");
        li.textContent = `${client.name} - ${client.email}`;
        ul.appendChild(li);
    });

    list.appendChild(ul);
}

