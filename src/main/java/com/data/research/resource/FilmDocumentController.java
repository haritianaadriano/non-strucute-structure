package com.data.research.resource;

import com.data.research.model.FilmDocument;
import com.data.research.service.FilmDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class FilmDocumentController {
    @Autowired
    private FilmDocumentService service;

    @GetMapping("/photo/{id}")
    public String getFilmDocument(
            @PathVariable(name = "id")String id,
            Model model
    ){
        FilmDocument filmDocument = service.getFilmDocument(id);
        model.addAttribute("title", filmDocument.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(filmDocument.getImage().getData()));
        return "photo";
    }

    @PostMapping("/photo")
    public String addFilmDocument(
            @RequestParam(name = "title")String title,
            @RequestParam(name = "image")MultipartFile newFilmDocument,
            Model model
    ) throws IOException {
        String id = service.insertFilmDocument(title, newFilmDocument);
        return("redirect: /photo/"+id);
    }
}
