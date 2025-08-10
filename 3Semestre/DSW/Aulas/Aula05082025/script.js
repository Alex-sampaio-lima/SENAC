document.getElementById("btn-carregar").addEventListener("click", () => {
    fetch("data.json")
        .then(response => response.json())
        .then(data => {
            const dataUser = data;

            const nome = document.getElementById("nome");

            nome.innerHTML = `${dataUser.info[0].nome}`;

            const imgperfil = document.getElementById("imgperfil");

            imgperfil.innerHTML = `
             ${dataUser.info.map(item => `<img src="${item.imgperfil}" alt="Foto-perfil-usuario">`)}
            `;

            const info = document.getElementById("info");

            info.innerHTML = `
            <h3>Dados Pessoais</h3>
            ${dataUser.info.map(item => `
                <p><strong>Nome:</strong> ${item.nome}</p>
                <p><strong>Email:</strong> ${item.email}</p>
                <p><strong>Telefone:</strong> ${item.telefone}</p>
                <p><strong>Cargo:</strong> ${item.cargo}</p>
                <p><strong>Cidade:</strong> ${item.cidade}</p>
                <p><strong>Data nascimento:</strong> ${item.nascimento}</p>
                <p><strong>Cidade:</strong> ${item.cidade}</p>
                <p><strong>Linkedin:</strong> ${item.linkedin}</p>
                `)}`;

            const experiencia = document.getElementById("experiencia");

            experiencia.innerHTML = `
                <h3>Experiências</h3>
                ${dataUser.experiencia.map(item => `
                    <p><strong>Cargo:</strong> ${item.cargo}</p>
                    <p><strong>Empresa:</strong> ${item.empresa}</p>
                    <p><strong>Descrição:</strong> ${item.descricao}</p>
                    <p><strong>Data:</strong> ${item.data}</p>
                    `)}`;

            const formacao = document.getElementById("formacao");

            formacao.innerHTML = `
                    <h3 class="formacao-title">Formação</h3>
                    ${dataUser.formacao.map(item => `
                        <p><strong>Nome do curso:</strong> ${item.nomeCurso}</p>
                        <p><strong>Instituição:</strong> ${item.instituicao}</p>
                        <p><strong>Data de inicio:</strong> ${item.data}</p>
                        <p><strong>Status do curso:</strong> ${item.status}</p>
                        <hr/>
                        `).join('')}`;

            const conhecimento = document.getElementById("conhecimento");

            conhecimento.innerHTML = `
                        <h3 class="conhecimento-title">Conhecimento</h3>
                        ${dataUser.conhecimento.map(item => `
                        <p>${item}</p>   
                        `).join('')}
            `;


        })
        .catch(error => {
            console.error("Erro ao carregar o JSON:", error);
        });
});

