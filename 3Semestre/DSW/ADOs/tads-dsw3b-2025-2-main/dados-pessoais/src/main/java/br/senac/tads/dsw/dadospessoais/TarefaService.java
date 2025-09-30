package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private Map<String, TarefaDTO> mapTarefas;

    public TarefaService() {
        mapTarefas = new HashMap<>();
        mapTarefas.put("Fazer almoço da semana",
                new TarefaDTO("Fazer almoço da semana", "Fulano da Silva", 
                LocalDate.parse("2025-09-20"), "Preparar o almoço para família"));
        mapTarefas.put("Prova de DSW",
                new TarefaDTO("Prova de DSW", "Ciclano da Silva", 
                LocalDate.parse("2025-10-11"), "Preparar o resumo da prova para usar como consultac"));
    }

      public List<TarefaDTO> findAll() {
    return new ArrayList<>(mapTarefas.values());
    }

    public TarefaDTO findByTitulo(String titulo) {
        return mapTarefas.get(titulo);
    }
    
    public TarefaDTO addNew(TarefaDTO dto) {
    mapTarefas.put(dto.getTitulo(), dto);
    return dto;
    }

    public TarefaDTO update(String username, TarefaDTO dto) {
    return null;
    }

    public void delete(String titulo) {

    }

}
