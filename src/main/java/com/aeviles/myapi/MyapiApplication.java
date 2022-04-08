package com.aeviles.myapi;

import com.aeviles.myapi.model.Usuario;
import com.aeviles.myapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u1= new Usuario(null, "Aeviles Aguiar", "aeviles", "12345678");
		Usuario u2= new Usuario(null, "AFlavio Tavares", "flavio", "12345678");
		Usuario u3= new Usuario(null, "Inez Silva", "inez", "12345678");

		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));

	}
}
