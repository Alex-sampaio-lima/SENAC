document.getElementById("btn-carregar").addEventListener("click", () => {
    fetch("data.json")
        .then(response => response.json())
        .then(data => {
            const dataUser = data;

            const info = document.getElementById("info");

            info.innerHTML = `
            <h2>Dados Pessoais</h2>
            ${dataUser.info.map(item => `
                <p><strong>Nome:</strong> ${item.nome}</p>
                <p><strong>Data nascimento:</strong> ${item.nascimento}</p>
                <p><strong>Email:</strong> ${item.email}</p>
                <p><strong>Telefone:</strong> ${item.telefone}</p>
                <p><strong>Linkedin:</strong> ${item.linkedin}</p>
                <p><strong>Linkedin:</strong> ${item.github}</p>
                
                `)}`;

            const experiencia = document.getElementById("experiencia");
            experiencia.innerHTML = `
                <h3>Experiências</h3>
                ${dataUser.experiencia.map(item => `
                    <p><strong>Cargo:</strong> ${item.cargo}</p>
                    <p><strong>Empresa:</strong> ${item.empresa}</p>
                    <p><strong>Descrição:</strong> ${item.descricao}</p>
                    <p><strong>Data:</strong> ${item.data}</p>
                `)}
            `;

            const formacao = document.getElementById("formacao").innerHTML = `
            <h3>Formação</h3>
            
            `;

            const conhecimento = document.getElementById("conhecimento").innerHTML = `
            <h3>Conhecimento</h3>
            
            `;


        })
        .catch(error => {
            console.error("Erro ao carregar o JSON:", error);
        });
});

