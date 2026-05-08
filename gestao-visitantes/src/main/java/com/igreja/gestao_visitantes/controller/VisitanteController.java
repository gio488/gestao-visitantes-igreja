package com.igreja.gestao_visitantes.controller;

import com.igreja.gestao_visitantes.model.Visitante;
import com.igreja.gestao_visitantes.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitantes")
@CrossOrigin("*")
public class VisitanteController {

    @Autowired
    private VisitanteService service;

    @PostMapping
    public Visitante cadastrar(@RequestBody Visitante visitante) {
        return service.salvar(visitante);
    }

    @GetMapping
    public List<Visitante> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Visitante atualizar(@PathVariable Long id, @RequestBody Visitante visitanteAtualizado) {
        Visitante visitanteExistente = service.buscarPorId(id);
        if (visitanteExistente != null) {
            visitanteExistente.setNome(visitanteAtualizado.getNome());
            visitanteExistente.setNomeIgreja(visitanteAtualizado.getNomeIgreja());
            visitanteExistente.setEvangelico(visitanteAtualizado.isEvangelico());
            return service.salvar(visitanteExistente);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Visitante buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}