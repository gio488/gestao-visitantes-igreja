package com.igreja.gestao_visitantes.controller;

import com.igreja.gestao_visitantes.model.Informativo;
import com.igreja.gestao_visitantes.service.InformativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informativos")
@CrossOrigin("*")
public class InformativoController {

    @Autowired
    private InformativoService service;

    @PostMapping
    public Informativo cadastrar(@RequestBody Informativo informativo) {
        return service.salvar(informativo);
    }

    @GetMapping
    public List<Informativo> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Informativo atualizar(@PathVariable Long id, @RequestBody Informativo informativo) {
        Informativo existente = service.buscarPorId(id);

        if (existente != null) {
            existente.setTitulo(informativo.getTitulo());

            existente.setMensagem(informativo.getMensagem());

            return service.salvar(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}