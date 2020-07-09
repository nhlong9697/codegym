package com.upload.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadForm {
    private String description;
    private CommonsMultipartFile[] files;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(CommonsMultipartFile[] files) {
        this.files = files;
    }
}

