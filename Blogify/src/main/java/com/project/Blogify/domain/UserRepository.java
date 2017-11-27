package com.project.Blogify.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {
	//all methods with return query of multiple rows:
	public List<User> findAll();
	//All methods with return query of single row:
	public User findById(long id);
	public User findByUsername(String username);
	
	 @Modifying(clearAutomatically = true)
	 @Transactional
	 @Query("UPDATE User SET username = :uname, Firstname = :Fname, Lastname = :Lname WHERE id = :userid ")
	 public int update(@Param("userid") long id, @Param("uname") String username,
			 @Param("Fname") String Firstname,@Param("Lname") String Lastname);
	
	
}
