package com.aeviles.myapi.controller.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {//vamos utilizar para implementar o not found exception

    private Integer status;
    private Long timestamp; //o momento que ocorre o erro;
    private  String message;

}
