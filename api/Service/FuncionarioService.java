package br.com.edusync.api.Service;
import br.com.edusync.api.Model.EmpresaModel;
import br.com.edusync.api.Model.FuncionarioModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {
    // lista para adicionar novos funcionarios
    private List<FuncionarioModel> funcionarios = new ArrayList<>();




    // adicionando novos funcionarios a lista FuncionarioModel
    public void adicionar(FuncionarioModel funcionarioModel){
        funcionarios.add(funcionarioModel);
    }




    // listar os funcionarios
    public Object listartudo(){
        return funcionarios;
    }




    //buscar um funcionário por cpf
    public FuncionarioModel buscarporcpf(String cpf) {
        return funcionarios.stream().filter(p -> cpf.equals(p.getCpf())).findFirst().orElseThrow();
    }




    //alterar um funcionario usando o cpf para indentificar qual usuario é
    public void update(String cpf, FuncionarioModel funcionarioModel) {
        remover(cpf);
        adicionar(funcionarioModel);
    }




    //remover um funcionario pelo cpf
    public void remover(String cpf) {
        FuncionarioModel funcionariopesquisa = buscarporcpf(cpf);
        if (funcionariopesquisa != null) {
            funcionarios.remove(funcionariopesquisa);
        }
    }
}
