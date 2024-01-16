package br.com.agenda.agenda.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.agenda.modelo.AgendaModelo;
import br.com.agenda.agenda.modelo.RespostaModelo;
import br.com.agenda.agenda.servico.AgendaServico;

@RestController
@CrossOrigin(origins = "*")
public class AgendaControle {

    @Autowired
    private AgendaServico as;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo>remover(@PathVariable long codigo){
        return as.remover(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?>alterar(@RequestBody AgendaModelo am){
        return as.cadastrarAlterar(am, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastrar(@RequestBody AgendaModelo am){
        return as.cadastrarAlterar(am, "cadastrar");
    }

    @GetMapping("/listar")
    //Como se fosse uma lista
    public Iterable<AgendaModelo> listar(){
        return as.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "API Ok";
    }
}
