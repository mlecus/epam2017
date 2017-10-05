package com.sgalaktionov.testhomework5;

import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolExtension;
import com.sgalaktionov.homework5.FileSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemTest {


    FileSystem fs;
    @Before
    public void testSetUp(){
        fs = new FileSystem("root/");
    }

    @Test
    public void testValidateInstanceNameWithFileInRoot() throws Exception {
        fs.validateInstanceName("file1.ext");
    }

    @Test
    public void testValidateInstanceNameWithFolderInRoot() throws Exception {
        fs.validateInstanceName("folder1");
    }

    @Test
    public void testValidateInstanceNameWithFolderInSubFolder() throws Exception {
        fs.validateInstanceName("folder1/folder1");
    }

    @Test (expected = IllegalArgumentException .class)
    public void  testValidateInstanceNameWithEmptyString(){
        fs.validateInstanceName("");
    }

    @Test (expected = IllegalArgumentException .class)
    public void  testValidateInstanceNameWithNull(){
        fs.validateInstanceName(null);
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithEmptyExtension(){
        fs.validateInstanceName("folder1/folder11/file1.");
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithEmptySubfolderName(){
        fs.validateInstanceName(("folder1//folder12/file1"));
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithEmptyFolderName(){
        fs.validateInstanceName(("folder1//folder12/file1"));
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithEmptyTargetFolderName(){
        fs.validateInstanceName(("folder1/folder11//"));
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithEmptyFileName(){
        fs.validateInstanceName(("folder1/folder11/.ext"));
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithExtensionSeparatorInExtension(){
        fs.validateInstanceName("folder1/folder11/file1.ext.ext");
    }

    @Test (expected = FSInvalidSymbolExtension .class)
    public void  testValidateInstanceNameWithFolderSeparatorInExtension(){
        fs.validateInstanceName(("folder1/folder11/file1.ext/folder1"));
    }

    @After
    public void testCleanUp(){
        fs=null;
    }
}