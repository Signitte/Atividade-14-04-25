package com.example.demo.Controller;

import com.example.demo.Model.Pessoa;
import com.example.demo.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoa")
@RestController
public class PessoaController {

    @Autowired
    PessoaService pessoaService;


    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return new ResponseEntity<>(pessoaService.listPessoa(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Pessoa> listarPessoaPorId(@PathVariable Long id){
        return new ResponseEntity<>(pessoaService.listPessoaById(id), HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        return new ResponseEntity<>(pessoaService.createPessoa(pessoa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa modificacao){
        return new ResponseEntity<>(pessoaService.modifePessoa(id,modificacao),HttpStatus.OK);
    }

    @PutMapping("/{id}/adicionarTrabalho/{idTrabalho}")
    public ResponseEntity<Pessoa> adicionarTrabalho(@PathVariable (value = "id") Long id, @PathVariable(value = "idTrabalho") Long idTrabalho){
        return new ResponseEntity<>(pessoaService.adicionarTrabalho(id,idTrabalho), HttpStatus.OK);
    }

    @PutMapping("/{id}/removerTrabalho/{idTrabalho}")
    public ResponseEntity<Pessoa> removerTrabalho(@PathVariable (value = "id") Long id, @PathVariable(value = "idTrabalho") Long idTrabalho){
        return new ResponseEntity<>(pessoaService.removerTrabalho(id,idTrabalho), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletarPessoa(@PathVariable Long id){
        return new ResponseEntity<>(pessoaService.deletePessoa(id), HttpStatus.OK);
    }
}
