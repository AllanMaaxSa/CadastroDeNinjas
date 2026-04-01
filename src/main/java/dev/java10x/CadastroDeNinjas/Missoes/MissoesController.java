package dev.java10x.CadastroDeNinjas.Missoes;

//LOCALHOST:8080

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")

public class MissoesController {

    // GET -- Mandar uma reguisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas com sucesso";
    }

    // POST -- Mandar uma reguisição para criar as missões
    //LOCALHOST:8080/MISSOES/DELETAR
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso" ;
    }

    // PUT -- Mandar uma reguisição para incluir as missões
    //PUT altera os dados que já estão incluidos no banco de dados
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missãoi alterada com sucesso";
    }

    // DELETE -- Mandar uma reguisição para deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

}
