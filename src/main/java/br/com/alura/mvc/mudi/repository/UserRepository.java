package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository< User, String>{


   User findByUserName(String username);

}
