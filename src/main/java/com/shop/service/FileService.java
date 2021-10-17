package com.shop.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Log
public class FileService {
    // 파일 업로드
    public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception{
        UUID uuid = UUID.randomUUID(); // 파일명 중복 방지
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 원본 파일명에서 확장자 분리
        String savedFileName = uuid.toString() + extension;

        String fileUploadFullUrl = uploadPath + "/" + savedFileName;    // 파일저장될 위치 + 파일명
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl); // 출력스트림 만들기
        fos.write(fileData); // fileData를 출력스트림에 입력
        fos.close();

        return savedFileName;
    }

    // 파일 삭제
    public void deleteFile(String filePath) throws Exception{
        File fileToDelete = new File(filePath);
        if (fileToDelete.exists()) {
            fileToDelete.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }


}
