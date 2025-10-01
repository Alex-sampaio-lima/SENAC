const btnIncluir = document.getElementById('btnIncluirBlog');
const formNovaBlog = document.getElementById('formNovaBlog');
const blogsContainer = document.getElementById('blogsContainer');
const msgSucesso = document.getElementById('msgSucesso');
const msgErro = document.getElementById('msgErro');

const API_URL = 'http://localhost:8080/blog';
formNovaBlog
function formatDate(dateStr) {
    const date = new Date(dateStr);
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
}

function isLate(dateStr) {
    const today = new Date();
    const date = new Date(dateStr);
    today.setHours(0, 0, 0, 0);
    date.setHours(0, 0, 0, 0);
    return date > today;
}

function createBlogHTML(blog) {
    const lateClass = isLate(blog.dataPublicacao) ? `<span class="late-label">NÃO PUBLICADA</span>` : '';
    return `
        <div class="blog">
            <h3>${blog.titulo} ${lateClass}</h3>
            <p>Autor: <strong>${blog.autor}</strong></p>
            <p>Data da publicação: <strong>${formatDate(blog.dataPublicacao)}</strong></p>
            <p class="description">${blog.texto}</p>
        </div>
    `;
}

async function carregarBlog() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error('Erro na busca do texto inserido');
        const data = await response.json();
        blogsContainer.innerHTML = '';
        data.forEach(blog => {
            blogsContainer.innerHTML += createBlogHTML(blog);
        });
    } catch (error) {
        console.error('Erro ao buscar textos:', error);
        blogsContainer.innerHTML = '<p>Erro ao buscar textos.</p>';
    }
}

btnIncluir.addEventListener('click', () => {
    formNovaBlog.style.display = 'block';
    btnIncluir.style.display = 'none';
    msgSucesso.textContent = '';
    msgErro.textContent = '';
});

formNovaBlog.addEventListener('submit', async (e) => {
    e.preventDefault();

    const novoBlog = {
        titulo: document.getElementById('titulo').value.trim(),
        autor: document.getElementById('autor').value.trim(),
        dataPublicacao: document.getElementById('dataPublicacao').value,
        texto: document.getElementById('texto').value.trim(),
    };

    msgSucesso.textContent = '';
    msgErro.textContent = '';


    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(novoBlog)
        });

        if (response.ok) {
            msgSucesso.textContent = 'Blog salvo com sucesso!';
            formNovaBlog.reset();
            formNovaBlog.style.display = 'none';
            btnIncluir.style.display = 'block';
            await carregarBlog();
        } else {
            const errorData = await response.json();
            const primeiraMensagem = Array.isArray(errorData)
                ? errorData[0]
                : (errorData.errors?.[0]?.defaultMessage || 'Erro ao buscar texto.');
            msgErro.textContent = `Erro: ${primeiraMensagem}`;
        }
    } catch (error) {
        msgErro.textContent = 'Erro de comunicação com o servidor.';
        console.error(error);
    }
});

carregarBlog();
