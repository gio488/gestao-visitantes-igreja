package com.igreja.gestao_visitantes.service;

import com.igreja.gestao_visitantes.model.Informativo;
import com.igreja.gestao_visitantes.repository.InformativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformativoService {

    @Autowired
    private InformativoRepository repository;

    public Informativo salvar(Informativo informativo) {
        return repository.save(informativo);
    }

    public List<Informativo> listarTodos() {
        return repository.findAll();
    }

    public Informativo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
