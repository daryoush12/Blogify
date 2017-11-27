package com.project.Blogify.domain;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
	//all methods with return query of multiple rows:
	public List<Post> findAll();
	//All methods with return query of single row:
	public Post findById(long id);
	
	@Query(value = "SELECT * FROM post ORDER BY postdate", nativeQuery = true)
	public List<Post>RetrieveByDate();
}
