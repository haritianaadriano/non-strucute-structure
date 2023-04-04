package com.data.research.repository.rest;

import com.data.research.model.rest.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEntityRepository extends JpaRepository <AuthorEntity, Integer>{
}
