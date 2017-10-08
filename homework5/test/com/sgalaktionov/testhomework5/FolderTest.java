package com.sgalaktionov.testhomework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAlreadyExistException;
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

    @Test (expected = FSFileAlreadyExistException.class)
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
        Folder subFolder1 = new Folder("folder1/");
        Folder subFolder2 = new Folder("folder2/");
        Folder subFolder3 = new Folder("folder3/");
        root.addFolder(subFolder1);
        subFolder1.addFolder(subFolder2);
        subFolder2.addFolder(subFolder3);

        assertEquals("root/folder1/folder2/",subFolder3.getFullPath());
    }

    @Test (expected = FSFileAlreadyExistException.class)
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

        Folder subFolder1= new Folder ("folder1/");
        Folder subFolder11= new Folder ("folder11/");
        Folder subFolder12= new Folder ("folder12/");
        Folder subFolder13= new Folder ("folder13/");

        Folder subFolder111= new Folder ("folder111/");
        Folder subFolder112= new Folder ("folder112/");
        Folder subFolder121= new Folder ("folder121/");
        Folder subFolder131= new Folder ("folder131/");

        Folder subFolder1111= new Folder ("folder1111/");
        Folder subFolder1112= new Folder ("folder1112/");

        Folder subFolder2= new Folder ("folder2/");
        Folder subFolder21= new Folder ("folder11/");
        Folder subFolder22= new Folder ("folder22/");

        root.addFile(new File("rootfile.ext"));

        root.addFolder(subFolder1);

        subFolder1.addFolder(subFolder11);
        subFolder1.addFolder(subFolder12);
        subFolder1.addFolder(subFolder13);

        subFolder11.addFolder(subFolder111);
        subFolder11.addFolder(subFolder112);
        subFolder12.addFolder(subFolder121);

        subFolder12.addFile(new File("file1.ext"));
        subFolder12.addFile(new File("file2.ext"));

        subFolder13.addFolder(subFolder131);

        subFolder11.addFile(new File("file1.ext"));
        subFolder11.addFile(new File("file2.ext"));
        subFolder11.addFile(new File("file3.ext"));

        subFolder111.addFolder(subFolder1111);
        subFolder111.addFolder(subFolder1112);

        root.addFolder(subFolder2);

        subFolder2.addFolder(subFolder21);
        subFolder2.addFolder(subFolder22);

        subFolder21.addFile(new File("file.ext"));

        System.out.println(root.toString());
        String expected =
                        "root/\n" +
                        "|    folder1/\n" +
                        "|    |    folder12/\n" +
                        "|    |    |    folder121/\n" +
                        "|    |    |    file2.ext\n" +
                        "|    |    |    file1.ext\n" +
                        "|    |    folder11/\n" +
                        "|    |    |    folder111/\n" +
                        "|    |    |    |    folder1112/\n" +
                        "|    |    |    |    folder1111/\n" +
                        "|    |    |    folder112/\n" +
                        "|    |    |    file3.ext\n" +
                        "|    |    |    file2.ext\n" +
                        "|    |    |    file1.ext\n" +
                        "|    |    folder13/\n" +
                        "|    |    |    folder131/\n" +
                        "|    folder2/\n" +
                        "|    |    folder11/\n" +
                        "|    |    |    file.ext\n" +
                        "|    |    folder22/\n" +
                        "|    rootfile.ext";
        assertEquals(expected,root.toString());
    }

}