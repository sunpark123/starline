package com.starline.starline.repository;

import com.starline.starline.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoginRespository extends JpaRepository<Login, Integer> {
}