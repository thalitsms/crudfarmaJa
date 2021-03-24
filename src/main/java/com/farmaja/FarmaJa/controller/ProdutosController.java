package com.farmaja.FarmaJa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmaja.FarmaJa.model.Produtos;
import com.farmaja.FarmaJa.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutosController 
{
	@Autowired
	private ProdutosRepository repository;
	
	//metodo findall
		@GetMapping 
		public ResponseEntity<List<Produtos>> GetAll()
		{
			return ResponseEntity.ok(repository.findAll());
		}
		//aula findbyid
		@GetMapping("/{id}")
		public ResponseEntity<Produtos> GetById(@PathVariable long id)
		{
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))//tanto um objeto postagem ok
					.orElse(ResponseEntity.notFound().build());//quanto um objeto não encontrado, ou não exista ou tenha algum erro
		}
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Produtos>> GetByTitulo(@PathVariable String titulo)
		{
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		@PostMapping
		public ResponseEntity<Produtos> post (@RequestBody Produtos produtos) //endpoint
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtos));
		}
		
		@PutMapping
		public ResponseEntity<Produtos> put (@RequestBody Produtos produtos) //endpoint
		{
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(produtos));
		}
		
		@DeleteMapping("/{id}")
		public void /*nao retorna nada, só o status ok*/ delete(@PathVariable long id)
		{
			//não precisa usar return pois não retorna nada
			repository.deleteById(id);
		}
		
		
}	
