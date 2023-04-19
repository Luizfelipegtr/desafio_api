package br.com.edusync.api.Model;

import lombok.Data;

@Data
public class FuncionarioModel {
    // criando um funcionario
    private String cpf;
    private String nome;
    private Integer idade;
    private Integer salario;
    private EmpresaModel empresa;
}
