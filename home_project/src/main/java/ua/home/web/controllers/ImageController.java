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
@RequestMapping("image")
public class ImageController {

    private static final String CONTENT_TYPE = "image/";

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity uploadImageToServer(@RequestParam("fileUpload") MultipartFile multipartFile) {
        File file = null;
        if (multipartFile.getContentType().startsWith(CONTENT_TYPE)) {
            String origname = multipartFile.getOriginalFilename();
            String extension = origname.substring(origname.lastIndexOf('.'), origname.length());

            try {
                file = new File(UUID.randomUUID().toString() + extension);
                multipartFile.transferTo(file);
            } catch (IOException e) {
                throw new ServerException("Error was invoked during upload image to server.");
            }
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(file.getAbsolutePath(), HttpStatus.CREATED);
    }
}
