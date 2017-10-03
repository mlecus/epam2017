package com.sgalaktionov.homework5;

public class Main {


    public static void main(String[] args) {
	// write your code here
        //Folder root = new Folder();
        FileSystem fs = new FileSystem();
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/folder111/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/folder111/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder12/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/folder112/file1.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder12/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/folder111/file3.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/folder113/file1.ext"));

/**/
        fs.fileSystemAddInstance(fs.validateInstanceName("folder1/folder11/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder2/folder21/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder2/folder22/file2.ext"));
        fs.fileSystemAddInstance(fs.validateInstanceName("folder4/folder42/file2.ext"));
/**/
        System.out.println(fs);
    }
}
