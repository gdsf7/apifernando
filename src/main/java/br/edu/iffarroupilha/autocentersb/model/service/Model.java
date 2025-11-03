package br.edu.iffarroupilha.autocentersb.model.service;

/*
* Model genérico
* @since 03/11/2025
* */

import br.edu.iffarroupilha.autocentersb.model.Cliente;
import br.edu.iffarroupilha.autocentersb.model.ClienteRepository;
import br.edu.iffarroupilha.autocentersb.model.Servico;
import br.edu.iffarroupilha.autocentersb.model.ServicoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class Model <ENTITY, REPOSITORY extends JpaRepository<ENTITY, Long>>
{
    protected REPOSITORY repository;

    public Model(REPOSITORY repository) {
        this.repository = repository;
    }

    public ENTITY salvar(ENTITY novaEntidade){
        return repository.save(novaEntidade);
    }
    public List<ENTITY> buscarTodos(){
        return this.repository.findAll();
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
