package br.com.caelum.remoteassignment.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.remoteassignment.model.User;
import br.com.caelum.remoteassignment.po.UserPO;
import br.com.caelum.remoteassignment.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> list(){
		return userRepository.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> create(@Valid @RequestBody UserPO userPO, UriComponentsBuilder uriBuilder) {
		User user = userPO.converter();
		userRepository.save(user);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@GetMapping("/find/id/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return ResponseEntity.ok(user.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/email/{email}")
	public ResponseEntity<User> findByEmail(@PathVariable String email) {
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent())
			return ResponseEntity.ok(user.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/email/like/{emailPart}")
	public ResponseEntity<List<User>> findByEmailLike(@PathVariable String emailPart) {
		List<User> users = userRepository.findByEmailLike(emailPart);
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/find/name/{name}")
	public ResponseEntity<List<User>> findByName(@PathVariable String nome) {
		List<User> users = userRepository.findByName(nome);
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/find/name/like/{namePart}")
	public ResponseEntity<List<User>> findByNameLike(@PathVariable String nomePart) {
		List<User> users = userRepository.findByNameLike(nomePart);
		return ResponseEntity.ok(users);
	}
}
