package br.ifpr.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpr.crud.exception.ApiException;
import br.ifpr.crud.model.Veiculo;
import br.ifpr.crud.repository.VeiculoRepository;

@RestController
@RequestMapping("/clientes")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository VeiculoRepository;
	
	@GetMapping
	public List<Veiculo> listar() {
		return VeiculoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscar(
			@PathVariable Integer id) {
		Optional<Veiculo> optCliente = 
				VeiculoRepository.findById(id);
		
		if(optCliente.isPresent())
			return new ResponseEntity<Veiculo>(
					optCliente.get(), HttpStatus.OK);
		
		return new ResponseEntity<Veiculo>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> inserir(
			@RequestBody Veiculo veiculo) {
	
		try {
			veiculo = VeiculoRepository.save(veiculo);
			return new ResponseEntity<Veiculo>(veiculo, HttpStatus.CREATED); 
		} catch (Exception e) {
			throw new ApiException("Erro ao inserir o Veiculo.");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizar(
			@PathVariable Integer id,
			@RequestBody Veiculo veiculo) {
		
		if(! VeiculoRepository.existsById(id))
			return new ResponseEntity<Veiculo>(HttpStatus.NOT_FOUND);
		
		try {
			veiculo.setId(id);
			VeiculoRepository.save(veiculo);
			
			return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiException("Erro ao atualizar o veículo.");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id) {
		if(! VeiculoRepository.existsById(id))
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		try {
			VeiculoRepository.deleteById(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiException("Erro ao remover o veiculo.");
		}
	}

}