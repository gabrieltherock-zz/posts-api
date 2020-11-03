package com.gabriel.api.services;

import com.gabriel.api.domain.Post;
import com.gabriel.api.repository.PostRepository;
import com.gabriel.api.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;

	/*
	 * Optional serve para evitar que o objeto venha como null para a variável obj
	 */
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}