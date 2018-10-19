package br.seap.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.seap.festa.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
