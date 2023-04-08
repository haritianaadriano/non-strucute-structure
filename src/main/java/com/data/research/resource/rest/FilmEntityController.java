package com.data.research.resource.rest;

import com.data.research.model.rest.FIlmEntity;
import com.data.research.service.rest.FilmEntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FilmEntityController {
    private FilmEntityService service;

    @GetMapping("/films")
    public List<FIlmEntity> getFilms(){
        return service.getAll();
    }

    @PostMapping("/films")
    public List<FIlmEntity> saveFilms(List<FIlmEntity> toSave){
        return service.saveAll(toSave);
    }
}
