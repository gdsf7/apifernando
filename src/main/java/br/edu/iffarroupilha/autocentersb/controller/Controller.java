package br.edu.iffarroupilha.autocentersb.controller;

/*
 * Controller genérico
 * @since 03/11/2025
 * */

import br.edu.iffarroupilha.autocentersb.model.Cliente;
import br.edu.iffarroupilha.autocentersb.model.service.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class Controller <E, M extends Model<E, ?>> {

    protected M model;
    public Controller(M model) {
        this.model = model;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping()
    public List<E> listarEntidades() {
        return model.buscarTodos();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping
    public void cadastrarNovaEntidade(@RequestBody E entidade) {
        model.salvar(entidade);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping
    public void atualizarEntidade(@RequestBody E entidade) {
        model.salvar(entidade);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deletarEntidade(@RequestParam Long id) {
        model.delete(id);
    }

}
