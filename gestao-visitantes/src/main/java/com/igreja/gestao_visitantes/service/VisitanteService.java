package com.igreja.gestao_visitantes.service;

import com.igreja.gestao_visitantes.model.Visitante;
import com.igreja.gestao_visitantes.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository repository;

    public Visitante salvar(Visitante visitante) {
        return repository.save(visitante);
    }

    public List<Visitante> listarTodos() {
        return repository.findAll();
    }

    public Visitante buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}