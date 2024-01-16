package br.com.agenda.agenda.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.agenda.modelo.AgendaModelo;

@Repository
public interface AgendaRepositorio extends CrudRepository<AgendaModelo, Long>{
    
}
