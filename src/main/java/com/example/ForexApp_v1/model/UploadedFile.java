package com.example.ForexApp_v1.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

// dodajemy plik do pliku rescources i css
// dodawanie pliku wyłączyć ze spring security
// plik xls -
//
//
