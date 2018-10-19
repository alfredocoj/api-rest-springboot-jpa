package br.seap.festa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.seap.festa.model.Convidado;
import br.seap.festa.service.ConvidadoService;

@RestController
@RequestMapping(value="/")
public class ConvidadosController {
	
	@Autowired
	private ConvidadoService service;
	
	
	@RequestMapping(value="convidados",method=RequestMethod.POST)
	public Object create(@RequestBody Convidado convidado) {
		return new ResponseEntity<Object>(service.save(convidado), HttpStatus.CREATED);
	}
	
	@RequestMapping(value={"convidados"}, method=RequestMethod.GET)
	public Object read() {
		return new ResponseEntity<List<Convidado>>(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value={"convidados/{id}"}, method=RequestMethod.GET)
	public Object read(@PathVariable Long id) {
		Optional<Long> op = Optional.ofNullable(id);
		
		if(op.isPresent()) {
			return new ResponseEntity<Convidado>(service.findById(id), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Não encontrado", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@RequestMapping(value="convidados", method=RequestMethod.PUT)
	public Object update(@RequestBody Convidado convidado) {
		service.update(convidado);
		return new ResponseEntity<Convidado>(convidado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="convidados/{id}", method=RequestMethod.DELETE)
	public Object delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Object>("Convidado deletado com sucesso", HttpStatus.OK);
	}	
}
