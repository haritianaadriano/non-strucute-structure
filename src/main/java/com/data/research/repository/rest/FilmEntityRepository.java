package com.data.research.repository.rest;

import com.data.research.model.rest.FIlmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmEntityRepository extends JpaRepository <FIlmEntity, Integer>{
}
