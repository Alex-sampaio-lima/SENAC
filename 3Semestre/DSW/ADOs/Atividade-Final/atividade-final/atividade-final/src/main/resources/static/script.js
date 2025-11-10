const API_URL = "http://localhost:8080/blog";
let postAtualId = null; // para saber qual post está sendo alterado

// 1️⃣ Carrega os posts ao abrir a página
document.addEventListener("DOMContentLoaded", carregarPosts);

// Função principal para buscar todos os posts
async function carregarPosts() {
    try {
        const resposta = await fetch(API_URL);
        if (!resposta.ok) throw new Error("Erro ao buscar posts");
        const posts = await resposta.json();
        mostrarPosts(posts);
    } catch (erro) {
        console.error("Erro ao carregar posts:", erro);
    }
}

// 2️⃣ Mostra os posts no HTML
function mostrarPosts(posts) {
    const lista = document.querySelector(".posts-list");
    const newPostArea = lista.querySelector(".new-post-area");
    lista.innerHTML = "";

    posts.forEach(post => {
        const artigo = document.createElement("article");
        artigo.classList.add("post", "published");
        artigo.innerHTML = `
      <section class="post-info">
          <h2>${post.titulo}</h2>
          <p><strong>Autor:</strong> ${post.autor}</p>
          <p><strong>Publicado em:</strong> ${new Date(post.dataPublicacao).toLocaleDateString("pt-BR")}</p>
      </section>
      <p class="post-summary">${post.texto}</p>
      <div class="post-actions">
          <button class="btn-action btn-alterar" data-id="${post.id}">Alterar</button>
          <button class="btn-action btn-excluir" data-id="${post.id}">Excluir</button>
      </div>
    `;
        lista.appendChild(artigo);
    });

    // Recoloca o botão de nova publicação
    if (newPostArea) lista.appendChild(newPostArea);

    // Adiciona eventos aos botões "Alterar"
    document.querySelectorAll(".btn-alterar").forEach(botao => {
        botao.addEventListener("click", () => abrirFormularioAlteracao(botao.dataset.id));
    });
}

// 3️⃣ Abre o formulário preenchido com os dados do post
async function abrirFormularioAlteracao(id) {
    try {
        const resposta = await fetch(`${API_URL}/${id}`);
        if (!resposta.ok) throw new Error("Erro ao buscar post");
        const post = await resposta.json();

        // Preenche o formulário
        document.getElementById("titulo").value = post.titulo;
        document.getElementById("autor").value = post.autor;
        document.getElementById("data").value = post.dataPublicacao; // formato yyyy-MM-dd
        document.getElementById("texto").value = post.texto;

        // Atualiza o título
        document.querySelector(".new-post-form h2").innerText = `Alterar publicação - ID ${id}`;

        // Mostra o formulário
        document.querySelector(".new-post-form").classList.remove("hidden");

        // Salva o ID atual
        postAtualId = id;

    } catch (erro) {
        console.error("Erro ao carregar post:", erro);
    };
};

// 4️⃣ Lida com o clique em "Salvar" no formulário
// document.querySelector(".post-form").addEventListener("submit", async (e) => {
//     e.preventDefault();

//     const post = {
//         titulo: document.getElementById("titulo").value,
//         autor: document.getElementById("autor").value,
//         dataPublicacao: document.getElementById("data").value,
//         texto: document.getElementById("texto").value
//     };

//     if (!post.titulo) {
//         alert("O título deve ser");
//     };

//     if (!post.texto) {
//         alert("O texto tem qu");
//     }

//     const metodo = postAtualId ? "PUT" : "POST";
//     const url = postAtualId ? `${API_URL}/${postAtualId}` : API_URL;
//     console.log(`Esse é o método dessa porra ${metodo}`);
//     try {
//         const resposta = await fetch(url, {
//             method: metodo,
//             headers: { "Content-Type": "application/json" },
//             body: JSON.stringify(post)
//         });

//         if (!resposta.ok) throw new Error("Erro ao salvar o post");

//         Toastify({
//             text: "Publicação salva com sucesso!",
//             duration: 4000,
//             gravity: "top",
//             position: "right",
//             backgroundColor: "#28a745"
//         }).showToast();
//         document.querySelector(".new-post-form").classList.add("hidden");
//         postAtualId = null;
//         carregarPosts();

//     } catch (erro) {
//         Toastify({
//             text: "Erro ao salvar: " + erro.join(", "),
//             duration: 5000,
//             gravity: "top",
//             position: "right",
//             backgroundColor: "#dc3545"
//         }).showToast();
//         console.error("Erro ao salvar:", erro);
//     }
//     carregarPosts();
// });


// Função principal: valida e salva o post
async function salvarPost(e) {
    e.preventDefault();

    const post = {
        titulo: document.getElementById("titulo").value.trim(),
        autor: document.getElementById("autor").value.trim(),
        dataPublicacao: document.getElementById("data").value,
        texto: document.getElementById("texto").value.trim()
    };

    // 🔎 Validações simples
    if (!validarPost(post)) return; // se inválido, para aqui

    const metodo = postAtualId ? "PUT" : "POST";
    const url = postAtualId ? `${API_URL}/${postAtualId}` : API_URL;

    try {
        const resposta = await fetch(url, {
            method: metodo,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(post)
        });

        if (!resposta.ok) {
            const erroMsg = await resposta.text();
            throw new Error(erroMsg || "Erro ao salvar o post");
        };

        mostrarToast("Publicação salva com sucesso!", "sucesso");
        document.querySelector(".new-post-form").classList.add("hidden");
        postAtualId = null;
        carregarPosts();

    } catch (erro) {
        mostrarToast("Erro ao salvar: " + erro.message, "erro");
        console.error("Erro ao salvar:", erro);
    };
};

function validarPost(post) {
    if (!post.titulo) {
        mostrarToast("O título é obrigatório!", "erro");
        return false;
    }

    if (!post.autor) {
        mostrarToast("O autor é obrigatório!", "erro");
        return false;
    }

    if (!post.dataPublicacao) {
        mostrarToast("A data de publicação é obrigatória!", "erro");
        return false;
    }

    if (!post.texto || post.texto.length < 10) {
        mostrarToast("O texto deve ter no mínimo 10 caracteres!", "erro");
        return false;
    }

    return true;
}

function mostrarToast(mensagem, tipo = "sucesso") {
    Toastify({
        text: mensagem,
        duration: 4000,
        gravity: "top",
        position: "right",
        backgroundColor: tipo === "erro" ? "#dc3545" : "#28a745"
    }).showToast();
}

document.querySelector(".post-form").addEventListener("submit", salvarPost);






























document.addEventListener('DOMContentLoaded', () => {
    const showFormBtn = document.getElementById('show-form-btn');
    const postsList = document.querySelector('.posts-list');
    const newPostForm = document.querySelector('.new-post-form');

    // Mostrar o Formulário e Ocultar a Lista
    if (showFormBtn) {
        showFormBtn.addEventListener('click', () => {
            postsList.classList.add('hidden');
            newPostForm.classList.remove('hidden');

            // Limpa o formulário e o postAtualId (modo "novo post")
            document.querySelector(".post-form").reset();
            document.querySelector(".new-post-form h2").innerText = "Incluir nova publicação";
            postAtualId = null;
        });
    }
});