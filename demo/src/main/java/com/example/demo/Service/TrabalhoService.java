package com.example.demo.Service;

import com.example.demo.Model.Pessoa;
import com.example.demo.Model.Trabalho;
import com.example.demo.Repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhoService {

    @Autowired
    TrabalhoRepository trabalhoRepository;


    public List<Trabalho> listTrabalho(){
        return trabalhoRepository.findAll();
    }

    public Trabalho listTrabalhoById(Long id){
        return trabalhoRepository.findById(id).orElseThrow();
    }

    public Trabalho createTrabalho(Trabalho trabalho){
        return trabalhoRepository.save(trabalho);
    }

    public Trabalho modifeTrabalho(Long id, Trabalho modificacao){
        Trabalho trabalho = trabalhoRepository.findById(id).orElseThrow();

        trabalho.setNomeTrabalho(modificacao.getNomeTrabalho());
        trabalho.setDescricao(modificacao.getDescricao());
        trabalho.setSalario(modificacao.getSalario());

        return trabalhoRepository.save(trabalho);


    }

    public Trabalho deleteTrabalho(Long id){
        Trabalho trabalho = trabalhoRepository.findById(id).orElseThrow();

        trabalhoRepository.delete(trabalho);

        return trabalho;
    }
}
