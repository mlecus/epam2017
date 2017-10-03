package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;
import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolExtension;

public class Main {


    public static void main(String[] args) {
	// write your code here
        new CommandLineApp().launch();

        FileSystem fs = new FileSystem("C:/");
/*
        //incorrect
        try{
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file1."));
        }catch (FSInvalidSymbolExtension e){
            System.out.println(e.getMessage());
        }
        try {
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file1/"));
        }catch (FSInvalidSymbolExtension e){
            System.out.println(e.getMessage());
        }

        try {
            fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file1.exe.ere"));
        }catch (FSInvalidSymbolExtension e){
            System.out.println(e.getMessage());
        }

        try {
            fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file1.exe/folder"));
        }catch (FSInvalidSymbolExtension e){
            System.out.println(e.getMessage());
        }

        try {
            fs.fileSystemAddInstance(fs.validateInstanceName("folder1//folder11/file1"));
        }catch (FSInvalidSymbolExtension e){
            System.out.println(e.getMessage());
        }

        try {
            fs.fileSystemAddInstance(fs.validateInstanceName("folder1/.txt"));
        }catch (FSInvalidSymbolExtension e){
            System.out.println(e.getMessage());
        }

        try {
            fs.fileSystemAddInstance(fs.validateInstanceName("1"));
            fs.fileSystemAddInstance(fs.validateInstanceName("1/2"));
            fs.fileSystemAddInstance(fs.validateInstanceName("1"));
            fs.fileSystemAddInstance(fs.validateInstanceName("2"));
        }catch (FSFileAllreadyExistException e){
            System.out.println(e.getMessage());
        }
        System.out.println(fs);

        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder111/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder111/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder111/file2"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder111"));

        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder12"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder12/file1.ext"));

        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder112/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder12/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder111/file3.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder1123/folder113/file1.ext"));


        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder2/folder21/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder2/folder22/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder2/folder22"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder4/folder42/file2.ext"));
        System.out.println(fs);
*/

    }
}
