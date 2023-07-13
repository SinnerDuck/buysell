package buysellprojoect.buysell.services;

import buysellprojoect.buysell.models.FileData;
import buysellprojoect.buysell.repositories.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

//    private FileDataRepository fileDataRepository;
//
//    public String uploadImageToFileSystem(MultipartFile file) throws IOException{
//        FileData fileData = fileDataRepository.save(FileData.builder()
//                .name(file.getOriginalFilename())
//                .contentType(file.getContentType())
//        );
//    }
}
