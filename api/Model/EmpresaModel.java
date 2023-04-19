package br.com.edusync.api.Model;

import lombok.Data;
import org.springframework.beans.MutablePropertyValues;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmpresaModel {
    private String nomeempresa;
    private String cnpj;

    //private List<FuncionarioModel>funcionarioModelList = new ArrayList<>();
}
