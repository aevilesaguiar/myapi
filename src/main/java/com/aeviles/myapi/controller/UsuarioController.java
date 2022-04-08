package com.aeviles.myapi.controller;

import com.aeviles.myapi.model.Usuario;
import com.aeviles.myapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    //instanciar o UsuarioService para termos acesso ao método findById()
    @Autowired
    private UsuarioService service;

    //buscar o usuario pelo o ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Usuario obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //buscar todos os usuarios disponiveis na base de dados
    @GetMapping
    public ResponseEntity<List <Usuario>> findAll(){
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    //método update para usuario
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){

        Usuario newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);


    }

    //Método Create
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj) {
        Usuario newObj = service.create(obj);
        //QUANDO CRIAMOS UM NOVO ENDPOINT
        //POR QUESTÃO DE BOA PRATICA DEVEMOS PASSAR  A URI DE ACESSO DO NOVO OBJETO
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    //metodo delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id ){//não vamos retornar nada por isso é Void
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
