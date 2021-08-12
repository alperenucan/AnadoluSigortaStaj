package com.example.internship.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.internship.model.User;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class XLSXReaderService {
    public static void main(String args[]) throws IOException, InvalidFormatException {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .build();
        List<User> userList= Poiji.fromExcel(new File("C:\\Users\\Alperen\\Desktop\\test.xlsx"),User.class,options);

        System.out.println(userList);
    }
}
