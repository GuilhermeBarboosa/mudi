package com.br.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.mudi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
