document.addEventListener("DOMContentLoaded", () => {
    fetch("http://localhost:8080/customers")
        .then(response => {
            if (!response.ok) throw new Error("Erro ao buscar os clientes!");
            return response.json();
        })
        .then(data => {
            const list = document.getElementById("customers");
            data.forEach(customer => {
                const item = document.createElement("li");
                item.textContent = `${customer.name} - ${customer.email} - ${customer.number}`;
                list.appendChild(item);
            });
        })
        .catch(error => {
            console.error("Erro ao carregar clientes:", error);
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

