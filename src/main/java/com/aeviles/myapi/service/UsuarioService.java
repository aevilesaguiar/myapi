package com.aeviles.myapi.service;

import com.aeviles.myapi.model.Usuario;
import com.aeviles.myapi.repository.UsuarioRepository;
import com.aeviles.myapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //regras de negocios
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repository.findById(id);//findById metodo implementado pelo o próprio jpa
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ", Tipo: "+Usuario.class.getName()) );
    }

    public List<Usuario> findAll() {
        return repository.findAll();//findAll metodo implementado pelo o próprio jpa

    }

    public Usuario update(Integer id, Usuario obj) {

        //verificar se id existe na base de dados
        Usuario newObj = findById(id); //se ele encontrar esse id ele tras para o obj

        newObj.setNome(obj.getNome());
        newObj.setLogin(obj.getLogin());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj); //o método save já é implementado pelo jpa
    }


    public Usuario create(Usuario obj) {
        obj.setId(null);//será nulo por que  não poderá salvar umid em cima de outro que exista
        return repository.save(obj);
    }

    public void delete(Integer id) {

        findById(id);
        repository.deleteById(id);
    }
}
