package com.example.demo.Controller;

import com.example.demo.Model.Pessoa;
import com.example.demo.Model.Trabalho;
import com.example.demo.Service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    TrabalhoService trabalhoService;

    @GetMapping
    public ResponseEntity<List<Trabalho>> listarTrabalhos(){
        return new ResponseEntity<>(trabalhoService.listTrabalho(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Trabalho> listarTrabalhoPorId(@PathVariable Long id){
        return new ResponseEntity<>(trabalhoService.listTrabalhoById(id), HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<Trabalho> criarTrabalho(@RequestBody Trabalho trabalho){
        return new ResponseEntity<>(trabalhoService.createTrabalho(trabalho), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabalho> editarTrabalho(@PathVariable Long id, @RequestBody Trabalho modificacao){
        return new ResponseEntity<>(trabalhoService.modifeTrabalho(id,modificacao),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trabalho> deletarTrabalho(@PathVariable Long id){
        return new ResponseEntity<>(trabalhoService.deleteTrabalho(id), HttpStatus.OK);
    }
}
