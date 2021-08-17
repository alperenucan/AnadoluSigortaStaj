package com.example.internship.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.example.internship.model.User;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;


public class XLSXReaderService {

    public List<User> ReadExcel(MultipartFile file) throws IOException, InvalidFormatException {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .build();
        List<User> userList= Poiji.fromExcel(convert(file),User.class,options);

        System.out.println(userList);

        return userList;

    }
    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
