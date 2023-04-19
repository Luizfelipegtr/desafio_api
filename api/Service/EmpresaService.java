package br.com.edusync.api.Service;
import br.com.edusync.api.Model.EmpresaModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    private List<EmpresaModel> empresas = new ArrayList<>();




    // adicionando novos funcionarios a lista FuncionarioModel
    public void adicionar(EmpresaModel empresaModel){
        empresas.add(empresaModel);
    }




    // listar os funcionarios
    public Object listartudo(){
        return empresas;
    }




    //buscar uma empresa por cpf
    public EmpresaModel buscarporcnpj(String cnpj) {
        return empresas.stream().filter(p -> cnpj.equals(p.getCnpj())).findFirst().orElseThrow();
    }




    //alterar um funcionario usando o cpf para indentificar qual empresa é
    public void update(String cnpj, EmpresaModel empresaModel) {
        remover(cnpj);
        adicionar(empresaModel);
    }




    //remover um funcionario pelo cpf
    public void remover(String cnpj) {
        EmpresaModel Empresapesquisa = buscarporcnpj(cnpj);
        if (Empresapesquisa != null) {
            empresas.remove(Empresapesquisa);
        }
    }
}
