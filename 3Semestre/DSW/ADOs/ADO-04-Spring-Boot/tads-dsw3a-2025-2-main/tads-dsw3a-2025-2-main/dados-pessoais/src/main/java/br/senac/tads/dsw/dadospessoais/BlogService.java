package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private Map<String, BlogDTO> mapBlog;

    public BlogService() {
        mapBlog = new HashMap<>();
        mapBlog.put("Fazer site de futebol",
                new BlogDTO("Descubra como fazer seu site", "Alexsander Sampaio Lima",
                        LocalDate.parse("2025-09-20"),
                        "Olá pequeno Gafanhoto, tudo bem ? Hoje vamos te ensinar como fazer seu site........"));
        mapBlog.put("Prova de DSW",
                new BlogDTO("Receitas de Bolo", "Sthephany Viana",
                        LocalDate.parse("2025-10-11"), "Como iniciar sua Receita, clique aqui para saber mais !"));
    }

    public List<BlogDTO> findAll() {
        return new ArrayList<>(mapBlog.values());
    }

    public BlogDTO findByTitulo(String titulo) {
        return mapBlog.get(titulo);
    }

    public BlogDTO addNew(BlogDTO dto) {
        mapBlog.put(dto.getTitulo(), dto);
        return dto;
    }

    public BlogDTO update(String username, BlogDTO dto) {
        return null;
    }

    public void delete(String titulo) {

    }

}
