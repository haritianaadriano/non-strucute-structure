package com.data.research.service;

import com.data.research.model.File;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations gridFsOperations;

    public String addFile(MultipartFile fileUpload) throws IOException{
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", fileUpload.getSize());

        Object fileID = gridFsTemplate.store(
                fileUpload.getInputStream(),
                fileUpload.getOriginalFilename(),
                fileUpload.getContentType(),
                metadata
        );
        return fileID.toString();
    }

    public File downloadFile(String id) throws IOException{
        GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        File file = new File();

        if(gridFSFile != null && gridFSFile.getMetadata() != null){
            file.setFileName(gridFSFile.getFilename());
            file.setFileType(gridFSFile.getMetadata().get("_contentType").toString());
            file.setFileSize(gridFSFile.getMetadata().get("fileSize").toString());
            file.setFile(IOUtils.toByteArray(gridFsOperations.getResource(gridFSFile).getInputStream()));
        }

        return file;
    }
}
