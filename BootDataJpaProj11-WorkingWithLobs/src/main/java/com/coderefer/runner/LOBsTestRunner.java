package com.coderefer.runner;

import com.coderefer.entity.MarriageSeeker;
import org.springframework.boot.CommandLineRunner;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LOBsTestRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Person name: ");
        String name = sc.next();
        System.out.println("Enter person Address: ");
        String addr = sc.next();
        System.out.println("Person's Photo path: ");
        String photoPath = sc.next();
        System.out.println("Enter Person biodata file complete path: ");
        String biodataPath = sc.next();
        System.out.println("Is Indian?");
        boolean indian = sc.nextBoolean();
//        prepare byte array representing photo file content
        int bufferSize = 8 * 1024;
        InputStream is = new BufferedInputStream(new FileInputStream(photoPath), bufferSize);


        int data = is.read();
        while(data != -1) {
            data = is.read();
        }
        is.close();
        byte[] photoContent = new byte[bufferSize];

//        prepare char[] representing biodata file content
        File file = new File(biodataPath);
        Reader reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
//        prepare Entity class Obj
//        MarriageSeeker seeker = new
//                MarriageSeeker(name, addr, photoPath, biodataPath, indian);

    }
}
