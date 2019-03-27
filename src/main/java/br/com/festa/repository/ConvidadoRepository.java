package br.com.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.festa.model.Convidado;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
