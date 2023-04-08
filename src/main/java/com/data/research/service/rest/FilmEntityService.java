package com.data.research.service.rest;

import com.data.research.model.rest.FIlmEntity;
import com.data.research.repository.rest.FilmEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmEntityService {
    private FilmEntityRepository repository;

    public List<FIlmEntity> saveAll(List<FIlmEntity> toSave){
        return repository.saveAll(toSave);
    }

    public List<FIlmEntity> getAll(){
        return repository.findAll();
    }
}
