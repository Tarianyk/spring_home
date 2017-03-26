package ua.home.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.home.exception.ServerException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/image")
public class ImageController {

    private static final String CONTENT_TYPE = "image/";

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity uploadImageToServer(@RequestParam("fileUpload") MultipartFile multipartFile) {
        if (multipartFile.getContentType().startsWith(CONTENT_TYPE)) {
            String origname = multipartFile.getOriginalFilename();
            String extension = origname.substring(origname.lastIndexOf('.'), origname.length());

            try {
                multipartFile.transferTo(new File(UUID.randomUUID().toString() + extension));
            } catch (IOException e) {
                throw new ServerException("Error was invoked during upload image to server.");
            }
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
