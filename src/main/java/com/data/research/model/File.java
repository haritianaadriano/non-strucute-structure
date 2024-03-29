package com.data.research.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class File {
    private String fileName;
    private String fileType;
    private String fileSize;
    private byte[] file;
}
