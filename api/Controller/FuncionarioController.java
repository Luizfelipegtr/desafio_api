package br.com.edusync.api.Controller;

import br.com.edusync.api.Model.EmpresaModel;
import br.com.edusync.api.Model.FuncionarioModel;
import br.com.edusync.api.Service.EmpresaService;
import br.com.edusync.api.Service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/funcionarios")
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private EmpresaService empresaService;



    //criar um novo funcionario
    @PostMapping (value = "/novo")
    @Operation(summary = "adicionar novo funcionario",description = "metodo para cadastragem de um novo funcionario.")

    public ResponseEntity<String> adicionar(@RequestBody FuncionarioModel funcionarioModel,
                                            @RequestParam String cnpj){
        try {

            EmpresaModel empresaModel = empresaService.buscarporcnpj(cnpj);
            //p.getFuncionarioModelList().add(funcionarioModel);
            funcionarioModel.setEmpresa(empresaModel);
            funcionarioService.adicionar(funcionarioModel);
            return new ResponseEntity<>("cadastrado com sucesso!", HttpStatus.CREATED);
        }catch (HttpMessageNotReadableException e){
            return new ResponseEntity<>("faltam informações!", HttpStatus.OK);

        }
    }





    //listar tudo no geral
    @GetMapping
    @Operation(summary = "listar todos os funcionarios",description = "metodo para listar todos os funcionarios.")

    public ResponseEntity listartudo() {
        return new ResponseEntity<>(funcionarioService.listartudo(),HttpStatus.OK);
    }






    // listar através do cpf
    @GetMapping(value = "/{cpf}")
    @Operation(summary = "buscar por cpf",description = "metodo para listar através do cpf.")

    public ResponseEntity buscarporcpf(@PathVariable String cpf){
        return new ResponseEntity(funcionarioService.buscarporcpf(cpf),HttpStatus.OK);

    }



    @PutMapping(value = "/{cpf}")
    @Operation(summary = "Alterar funcionario",description = "metodo para alterar um funcionario.")

    public ResponseEntity alterar(@PathVariable String cpf, @RequestBody FuncionarioModel funcionarioModel){
        funcionarioService.update(cpf,funcionarioModel);
        return new ResponseEntity<>(funcionarioModel,HttpStatus.OK);
    }






    //apagar um funcionario através do código cpf
    @DeleteMapping(value = "/{cpf}")
    @Operation(summary = "remover funcionario",description = "metodo para remover funcionarios pelo cpf.")

    public ResponseEntity remover(@PathVariable String cpf){
        funcionarioService.remover(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
