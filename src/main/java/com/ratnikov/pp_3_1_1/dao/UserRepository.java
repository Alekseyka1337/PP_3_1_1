package com.ratnikov.pp_3_1_1.dao;



import com.ratnikov.pp_3_1_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
