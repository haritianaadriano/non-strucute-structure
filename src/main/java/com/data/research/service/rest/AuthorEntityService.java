package com.data.research.service.rest;

import com.data.research.model.rest.AuthorEntity;
import com.data.research.repository.rest.AuthorEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorEntityService {
    private AuthorEntityRepository repository;

    private List<AuthorEntity> saveAll(List<AuthorEntity> toSave){
        return repository.saveAll(toSave);
    }

    private List<AuthorEntity> getAll(){
        return repository.findAll();
    }
}
