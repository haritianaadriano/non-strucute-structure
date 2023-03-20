package com.data.research.resource;

import com.data.research.model.File;
import com.data.research.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam(name = "file")MultipartFile newFIle) throws IOException{
        return new ResponseEntity<>(fileService.addFile(newFIle), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable(name = "id")String id) throws IOException{
        File file = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getFile()));
    }
}
