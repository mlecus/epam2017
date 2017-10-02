package com.sgalaktionov.testhomework5;

import com.sgalaktionov.homework5.FileSystem;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemTest {
    @Test
    public void  testCreateFileSystem(){
        FileSystem fs = new FileSystem();
    }

    @Test
    public  void testFileSystemAddInstance(){
        FileSystem fs = new FileSystem();
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1folder2fileext"));
    }

}