package br.com.festa.service;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festa.model.Convidado;
import br.com.festa.repository.ConvidadoRepository;

@Service
@Slf4j
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repository;

	public Convidado save(Convidado convidado) {
		return repository.save(convidado);
	}

	public List<Convidado> findAll() {
		return repository.findAll();
	}
	
	public Convidado findById(Long id) {
		return repository.findOne(id);
	}

	public void update(Convidado convidado) {
		try {
			Optional<Convidado> entity = Optional.ofNullable(repository.findOne(convidado.getId()));
			
			entity.ifPresent( e -> {
				e.setNome(convidado.getNome());
				e.setNumeroConvidados(convidado.getNumeroConvidados());
					repository.save(e);
					log.info("Atualizado com sucesso: "+e.getId()+" - "+e.getNome());
				}
			);

			
		} catch(Exception ex) {
			ex.printStackTrace();
			log.error("Erro: "+ex.getMessage());
		}
		
	}
	
	public void delete(Long id) {
		try {
			Convidado entity = repository.findOne(id);
			repository.delete(entity);
			log.info("Deletado com sucesso: "+entity.getId()+" - "+entity.getNome());
		} catch (Exception ex){
			log.error("Erro: "+ex.getMessage());
		}

	}

}
