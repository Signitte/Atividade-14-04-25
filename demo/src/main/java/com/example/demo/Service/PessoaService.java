package com.example.demo.Service;

import com.example.demo.Model.Pessoa;
import com.example.demo.Model.Trabalho;
import com.example.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TrabalhoService trabalhoService;


    public List<Pessoa> listPessoa(){
        return pessoaRepository.findAll();
    }

    public Pessoa listPessoaById(Long id){
        return pessoaRepository.findById(id).orElseThrow();
    }

    public Pessoa createPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa modifePessoa(Long id, Pessoa modificacao){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();

        pessoa.setNome(modificacao.getNome());
        pessoa.setCpf(modificacao.getCpf());
        pessoa.setSexo(modificacao.getSexo());
        pessoa.setIdade(modificacao.getIdade());

        return pessoaRepository.save(pessoa);


    }

    public Pessoa adicionarTrabalho(Long id, Long idTrabalho){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        Trabalho trabalho = trabalhoService.listTrabalhoById(idTrabalho);

        pessoa.getTrabalhos().add(trabalho);

        return pessoaRepository.save(pessoa);
    }

    public List<Trabalho> listarTrabalhos(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        return pessoa.getTrabalhos();
    }

    public Pessoa removerTrabalho(Long id, Long idTrabalho){

        int index = 0;
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();

        for(Trabalho trabalho : pessoa.getTrabalhos()){
            if(trabalho.getId().equals(idTrabalho)){
                pessoa.getTrabalhos().remove(index);
                return pessoaRepository.save(pessoa);
            }
            index++;
        }
        return pessoa;

    }

    public Pessoa deletePessoa(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();

        pessoaRepository.delete(pessoa);

        return pessoa;
    }
}
