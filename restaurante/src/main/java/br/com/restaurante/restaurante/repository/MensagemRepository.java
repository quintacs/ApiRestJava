package br.com.restaurante.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.restaurante.restaurante.model.MensagemModel;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemModel, Long>{
	
	
	public MensagemModel save(MensagemModel mensagemModel);
	
	public List<MensagemModel> findByConteudo(@Param("conteudo")String conteudo);
	
}
