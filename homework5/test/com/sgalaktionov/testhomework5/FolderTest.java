package com.sgalaktionov.testhomework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;
import com.sgalaktionov.homework5.File;
import com.sgalaktionov.homework5.Folder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FolderTest {

    public final String rootName = "root/";
    public final  String subFolderName = "folder1/";
    public final  String fileFullName = "file.ext";

    public Folder root;
    public Folder subFolder;
    public File file;

    @Before
    public  void testSetUp(){

        root = new Folder(rootName);
        subFolder = new Folder(subFolderName);
        file = new File(fileFullName);
    }


    @Test
    public void testAddFile() throws Exception {

        root.addFile(file);
    }

    @Test (expected = FSFileAllreadyExistException.class)
    public void testAddDuplicationFile() throws Exception {

        root.addFile(file);
        root.addFile(file);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullFile() throws Exception {

        root.addFile(null);
    }

    @Test
    public void testAddFolder() throws Exception {

        root.addFolder(subFolder);
    }

    @Test (expected = FSFileAllreadyExistException.class)
    public void testAddDuplicationFolder() throws Exception {

        root.addFolder(subFolder);
        root.addFolder(subFolder);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullFolder() throws Exception {

        root.addFolder(null);
    }

    @Test
    public void getSubFolder() throws Exception {

        root.addFolder(subFolder);
        assertEquals(subFolder,root.getSubFolder(subFolderName));
    }


    @Test (expected = IllegalArgumentException.class)
    public void getSubFolderWithNullFolder() throws Exception {

        root.getSubFolder(null);
    }



    @Test
    public void testToString() throws Exception {
        root.addFolder(subFolder);
        root.addFile(file);
        root.getSubFolder(subFolderName).addFolder(new Folder(subFolderName));
        root.getSubFolder(subFolderName).addFile(new File(fileFullName));
        System.out.println(root);
        /*String expected =
                "root/"+
        assertEquals(,root.toString());*/
    }

}