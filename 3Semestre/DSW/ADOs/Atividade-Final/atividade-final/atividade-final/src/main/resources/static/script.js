const API_URL = "http://localhost:8080/blog";
let postAtualId = null;

// Carrega os posts ao abrir a página
document.addEventListener("DOMContentLoaded", carregarPosts);

// Função principal para buscar todos os posts
async function carregarPosts() {
    try {
        const resposta = await fetch(API_URL);

        if (!resposta.ok) {
            throw new Error("Erro ao buscar posts")
        };
        const posts = await resposta.json();
        mostrarPosts(posts);
    } catch (erro) {
        console.error("Erro ao carregar posts:", erro);
    }
}

// Mostra os posts no HTML
function mostrarPosts(posts) {
    const lista = document.querySelector(".posts-list");
    const newPostArea = lista.querySelector(".new-post-area");
    lista.innerHTML = "";

    posts.forEach(post => {
        const artigo = document.createElement("article");
        artigo.classList.add("post", "published");

        const dataPublicacao = new Date(post.dataPublicacao);
        const hoje = new Date();
        const isNaoPublicado = dataPublicacao > hoje;

        if (isNaoPublicado) {
            artigo.classList.add("nao-publicado");
        };

        artigo.innerHTML = `
      <section class="post-info">
          <h2>${post.titulo}</h2>
          <p><strong>Autor:</strong> ${post.autor}</p>
          <p><strong>Publicado em:</strong> ${new Date(post.dataPublicacao).toLocaleDateString("pt-BR")}</p>
           ${isNaoPublicado ? '<span class="status-tag tag-nao-publicado">NÃO PUBLICADO</span>' : ''}
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
    if (newPostArea) {
        lista.appendChild(newPostArea);
    };

    // Aqui estou adicionando eventos aos botões de alteração
    document.querySelectorAll(".btn-alterar").forEach(botao => {
        botao.addEventListener("click", () => abrirFormularioAlteracao(botao.dataset.id));
    });

    // document.querySelector(".posts-list").classList.add("hidden");

    document.querySelectorAll(".btn-excluir").forEach(botao => {
        botao.addEventListener("click", (e) => {
            const id = e.target.dataset.id;
            const titulo = e.target.closest('.post').querySelector('h2').textContent;
            mostrarModalConfirmacao(id, titulo);
        });
    });
};

// Pega os dados da banco e insere no form, para poder atualizar
async function abrirFormularioAlteracao(id) {
    try {
        const resposta = await fetch(`${API_URL}/${id}`);
        if (!resposta.ok) {
            throw new Error("Erro ao buscar post");
        };
        const post = await resposta.json();

        document.getElementById("titulo").value = post.titulo;
        document.getElementById("autor").value = post.autor;
        document.getElementById("data").value = post.dataPublicacao;
        console.log("OLHA AQUI CORNO !" + post.dataPublicacao);

        document.getElementById("texto").value = post.texto;

        // Aqui eu vou atualizar o título
        document.querySelector(".new-post-form h2").innerText = `Alterar publicação - ID ${id}`;

        document.querySelector(".new-post-form").classList.remove("hidden");
        document.querySelector(".posts-list").classList.add("hidden");

        postAtualId = id;

    } catch (erro) {
        console.error("Erro ao carregar post:", erro);
    };
};

async function salvarPost(e) {
    e.preventDefault();

    const post = {
        titulo: document.getElementById("titulo").value.trim(),
        autor: document.getElementById("autor").value.trim(),
        dataPublicacao: document.getElementById("data").value,
        texto: document.getElementById("texto").value.trim()
    };

    if (!validarPost(post)) {
        mostrarToast("Dados inválidos", "erro")
    };

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
            throw new Error("Erro ao salvar o post" + erroMsg);
        };

        mostrarToast("Publicação salva com sucesso!", "sucesso");
        document.querySelector(".new-post-form").classList.add("hidden");
        document.querySelector(".posts-list").classList.remove("hidden");
        postAtualId = null;
        await carregarPosts();

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
    };

    return true;
};

function mostrarToast(mensagem, tipo = "sucesso") {
    Toastify({
        text: mensagem,
        duration: 4000,
        gravity: "top",
        position: "right",
        backgroundColor: tipo === "erro" ? "#dc3545" : "#28a745"
    }).showToast();
};

document.querySelector(".post-form").addEventListener("submit", salvarPost);

// Função para mostrar modal de confirmação
function mostrarModalConfirmacao(id, titulo) {
    const modalOverlay = document.createElement('div');
    modalOverlay.className = 'modal-overlay';

    modalOverlay.innerHTML = `
        <div class="modal-content">
            <h3>Confirmar Exclusão</h3>
            <p>Deseja excluir a publicação "<strong>${titulo}</strong>" - ID ${id}?</p>
            <div class="modal-actions">
                <button class="btn-confirm btn-yes" data-id="${id}">SIM</button>
                <button class="btn-confirm btn-no">NÃO</button>
            </div>
        </div>
    `;

    document.body.appendChild(modalOverlay);

    modalOverlay.querySelector('.btn-yes').addEventListener('click', () => {
        excluirPost(id);
        document.body.removeChild(modalOverlay);
    });

    modalOverlay.querySelector('.btn-no').addEventListener('click', () => {
        document.body.removeChild(modalOverlay);
    });

    modalOverlay.addEventListener('click', (e) => {
        if (e.target === modalOverlay) {
            document.body.removeChild(modalOverlay);
        };
    });
};

async function excluirPost(id) {
    try {
        const resposta = await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });

        if (!resposta.ok) {
            throw new Error('Erro ao excluir post');
        }

        mostrarToast('Publicação excluída com sucesso!', 'sucesso');
        carregarPosts();

    } catch (erro) {
        console.error('Erro ao excluir:', erro);
        mostrarToast('Erro ao excluir publicação', 'erro');
    }
}






























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