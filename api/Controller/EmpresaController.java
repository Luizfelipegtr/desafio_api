package br.com.edusync.api.Controller;
import br.com.edusync.api.Model.EmpresaModel;
import br.com.edusync.api.Service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/empresas")
@RestController
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;






    //adiciona uma nova empresa
    @PostMapping(value = "/novo")
    @Operation(summary = "adicionar nova empresa",description = "metodo para cadastragem de uma nova empresa.")

    public ResponseEntity<String> adicionar(@RequestBody EmpresaModel empresaModel){
        try {
            empresaService.adicionar(empresaModel);
            return new ResponseEntity<>("cadastrado com sucesso!", HttpStatus.CREATED);
        }catch (HttpMessageNotReadableException e){
            return new ResponseEntity<>("faltam informações!", HttpStatus.OK);

        }
    }






    //listar tudo no geral
    @GetMapping
    @Operation(summary = "listar todos as empresas",description = "metodo para listar todas as empresas.")

    public ResponseEntity listartudo() {
        return new ResponseEntity<>(empresaService.listartudo(),HttpStatus.OK);
    }






    // listar através do cnpj
    @GetMapping(value = "/{cnpj}")
    @Operation(summary = "buscar por cpf",description = "metodo para buscar empresa através do cnpj.")

    public ResponseEntity buscarporcnpj(@PathVariable String cnpj){
        return new ResponseEntity(empresaService.buscarporcnpj(cnpj),HttpStatus.OK);

    }





    //alterar a empresa
    @PutMapping(value = "/{cnpj}")
    @Operation(summary = "Alterar empresa",description = "metodo para alterar uma empresa.")

    public ResponseEntity alterar(@PathVariable String cnpj, @RequestBody EmpresaModel empresaModel){
        empresaService.update(cnpj,empresaModel);
        return new ResponseEntity<>(empresaModel,HttpStatus.OK);
    }





    //apagar uma empresa através do cnpj.
    @DeleteMapping(value = "/{cnpj}")
    @Operation(summary = "remover empresa",description = "metodo para remover empresa pelo cnpj.")
    public ResponseEntity remover(@PathVariable String cnpj){
        empresaService.remover(cnpj);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}