package br.com.restaurante.restaurante.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurante.restaurante.model.MensagemModel;
import br.com.restaurante.restaurante.repository.MensagemRepository;

@RestController
@RequestMapping(path="mensagem")
public class MensagemController {

	private  String template = "Ola %s";
	private  AtomicLong contador = new AtomicLong();
	
	private MensagemRepository mensagemRepository;
	
	public MensagemController(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}
	
	@PostMapping
	public ResponseEntity<MensagemModel> save(@RequestBody MensagemModel mensagemModel ){
		mensagemRepository.save(mensagemModel);
		return new ResponseEntity<>(mensagemModel,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<MensagemModel>> getAll(){
		List<MensagemModel> lstMensagemModel = new ArrayList<MensagemModel>();
		lstMensagemModel = this.mensagemRepository.findAll();
		return new ResponseEntity<List<MensagemModel>>(lstMensagemModel,HttpStatus.OK);
	}
	
	@GetMapping(path = "/id")
	public ResponseEntity<Optional<MensagemModel>>getById(@PathVariable Long id){
		Optional<MensagemModel> mensagemModel;
		try {
			mensagemModel = mensagemRepository.findById(id);
			return new ResponseEntity<Optional<MensagemModel>>(mensagemModel,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Optional<MensagemModel>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/id")
	public ResponseEntity<MensagemModel> update(@PathVariable Long id, @RequestBody MensagemModel newMensagemModel){
		return mensagemRepository.findById(id)
				.map(mensagemModel -> {
								mensagemModel.setConteudo(newMensagemModel.getConteudo());								
								MensagemModel mensagem = mensagemRepository.save(mensagemModel);
								return ResponseEntity.ok().body(mensagem);
							}
						
						).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@GetMapping("/getMensagem")
	public MensagemModel getMensagem(@RequestParam(value = "mensagem", defaultValue = "Mundo") String mensagem) {
		return  new MensagemModel(contador.getAndIncrement(), String.format(template, mensagem));
	}
	
	@GetMapping("/getMensagem2")
	public MensagemModel getMensgem2(@RequestParam(value = "mensagem", defaultValue = "Mundo2")String mensagem) {
		MensagemModel mensagemModel = new MensagemModel(mensagem);
		return mensagemModel;
	}
}
