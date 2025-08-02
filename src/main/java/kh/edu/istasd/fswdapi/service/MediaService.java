package kh.edu.istasd.fswdapi.service;


import jakarta.servlet.http.HttpServletResponse;
import kh.edu.istasd.fswdapi.dto.MediaResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {

     MediaResponse upload(MultipartFile file);

    List<MediaResponse> uploadMultiple(List<MultipartFile> files);

    ResponseEntity<Resource> downloadFileByName(String fileName);

    void deleteFileByName(String fileName);
}