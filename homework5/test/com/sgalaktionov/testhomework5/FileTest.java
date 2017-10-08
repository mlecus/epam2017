package com.sgalaktionov.testhomework5;

import com.sgalaktionov.homework5.File;
import com.sgalaktionov.homework5.Folder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileTest {
    public final String rootName = "root/";
    public final String fileFullName = "file.ext";

    public File file;
    public  Folder root;

    @Before
    public  void testSetUp(){
        root = new Folder(rootName);
        file = new File(fileFullName);
    }

    @Test
    public void testGetFullName() throws Exception {
        assertEquals("file.ext", file.getFullName());
    }

    @Test
    public void testGetParentFolderBefoAddToFolder(){

        assertEquals(null, file.getParentFolder());
    }

    @Test
    public void testGetParentFolderAfterAddToFolder(){

        root.addFile(file);
        assertEquals(root, file.getParentFolder());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("file.ext", file.getFullName());
    }

}