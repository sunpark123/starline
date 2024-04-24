package com.starline.starline.repository;

import com.starline.starline.entity.user_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_infoRespository extends JpaRepository<user_info, Integer> {
}