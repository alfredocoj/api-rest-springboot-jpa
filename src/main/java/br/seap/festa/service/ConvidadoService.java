package br.seap.festa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.seap.festa.model.Convidado;
import br.seap.festa.repository.ConvidadoRepository;

@Service
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
				}
			);
			
		} catch(Exception ex) {
			ex.printStackTrace();			
		}
		
	}
	
	public void delete(Long id) {
		Convidado entity = repository.findOne(id);
		repository.delete(entity);
	}

}
