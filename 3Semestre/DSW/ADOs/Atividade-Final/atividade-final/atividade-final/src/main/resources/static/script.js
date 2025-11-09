document.addEventListener('DOMContentLoaded', (event) => {
    const showFormBtn = document.getElementById('show-form-btn');
    const postsList = document.querySelector('.posts-list');
    const newPostForm = document.querySelector('.new-post-form');

    // 1. Mostrar o Formulário e Ocultar a Lista
    if (showFormBtn) {
        showFormBtn.addEventListener('click', () => {
            postsList.classList.add('hidden');
            newPostForm.classList.remove('hidden');
        });
    }

    // Opcional: Adicionar um evento para o botão 'Salvar'
    // que ocultaria o formulário e voltaria para a lista.
    // Aqui, apenas previne o envio para demonstração.
    const saveBtn = document.querySelector('.btn-save');
    if (saveBtn) {
        saveBtn.addEventListener('click', (e) => {
            e.preventDefault(); // Impede o envio real do formulário
            // alert('Postagem salva (simulação). Voltando para a lista...');
            newPostForm.classList.add('hidden');
            postsList.classList.remove('hidden');
        });
    }
});