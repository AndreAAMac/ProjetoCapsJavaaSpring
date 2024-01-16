package br.com.agenda.agenda.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.agenda.agenda.modelo.AgendaModelo;
import br.com.agenda.agenda.modelo.RespostaModelo;
import br.com.agenda.agenda.repositorio.AgendaRepositorio;

@Service
public class AgendaServico {
    //Criar um OBJ e ter acesso nesta classe
    @Autowired
    private AgendaRepositorio ar;

    //Feedback para casa estiver faltando algo, mandar um msg
    @Autowired
    private RespostaModelo rm;

    //Metodo para listar todos os produtos
    public Iterable<AgendaModelo> listar(){
        return ar.findAll();
    }
    
    //Metodo para cadastrar ou alterar produtos
    public ResponseEntity<?>cadastrarAlterar(AgendaModelo am, String acao){

        if(am.getNome().equals("")){
            rm.setMensagem("O nome é obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(am.getCidade().equals("")){
            rm.setMensagem("O nome da marca é obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<AgendaModelo>(ar.save(am), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<AgendaModelo>(ar.save(am), HttpStatus.OK);
            }
        }
    }

    //Metodo para remover produtos
    public ResponseEntity<RespostaModelo>remover(long codigo){
        ar.deleteById(codigo);
        rm.setMensagem("O produto foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
