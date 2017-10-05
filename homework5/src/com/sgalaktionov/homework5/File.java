package com.sgalaktionov.homework5;

public class File {

    private String fullName;
    Folder parentFolder;


    public File(String fullName) {

        this.fullName = fullName;
    }


    public void setParentFolder(Folder parentFolder) {

        this.parentFolder = parentFolder;
    }


    public Folder getParentFolder() {

        return this.parentFolder;
    }


    public String getFullName() {

        return this.fullName;
    }

    @Override
    public String toString() {

        return this.fullName;
    }
}
