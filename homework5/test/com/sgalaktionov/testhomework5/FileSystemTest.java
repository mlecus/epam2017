package com.sgalaktionov.testhomework5;

import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolException;
import com.sgalaktionov.homework5.FileSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithEmptyExtension(){
        fs.validateInstanceName("folder1/folder11/file1.");
    }

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithEmptyRootSubfolderName(){
        fs.validateInstanceName(("/folder12/file1.e"));
    }

    public void  testValidateInstanceNameWithEmptySubfolderName(){
        fs.validateInstanceName(("folder1//folder12/file1.e"));
    }

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithEmptyTargetFolderName(){
        fs.validateInstanceName(("folder1/folder11//"));
    }

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithEmptyRootFileName(){

        fs.validateInstanceName((".ext"));
    }

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithEmptyFileName(){

        fs.validateInstanceName(("folder1/folder11/.ext"));
    }

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithExtensionSeparatorInExtension(){
        fs.validateInstanceName("folder1/folder11/file1.ext.ext");
    }

    @Test (expected = FSInvalidSymbolException.class)
    public void  testValidateInstanceNameWithFolderSeparatorInExtension(){
        fs.validateInstanceName(("folder1/folder11/file1.ext/folder1"));
    }

    @After
    public void testCleanUp(){
        fs=null;
    }
}