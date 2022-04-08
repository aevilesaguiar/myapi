package com.aeviles.myapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")//estou dizeendo para o JPA que ele pode criar uma tabela na base dados
public class Usuario implements Serializable {
    /**
     * A serialização em Java é o processo no qual a instância de um objeto é transformada em uma sequência de bytes e
     * é útil quando precisamos enviar objetos pela rede, salvar no disco, ou comunicar de uma JVM com outra. Isso
     * porque o estado atual do objeto é “congelado” e na outra “ponta” nós podemos “descongelar” este objeto sem
     * perder nenhuma informação.
     */

    private static final long serialVersionUID=1L;

    @Id //para informar para o JPA que é uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *A anotação @GeneratedValue é utilizada para informar que a geração do valor do identificador único da entidade
     * será gerenciada pelo provedor de persistência. Essa anotação deve ser adicionada logo após a anotação @Id.
     * Quando não anotamos o campo com essa opção, significa que a responsabilidade de gerar e gerenciar as chaves
     * primárias será da aplicação, em outras palavras, do nosso código,
     */



    @NotEmpty(message = "campo NOME é mandatório")
    @Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "campo LOGIN é mandatório")
    @Length( min = 3, max = 100, message = "O nome deve ter entre 3 e 20 caracteres")
    private String login;

    @NotEmpty(message = "campo SENHA é mandatório")
    @Length( min = 8, max = 8, message = "O SENHA deve ter 8 caracteres")
    private String senha;


}
