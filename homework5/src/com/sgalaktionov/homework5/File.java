package com.sgalaktionov.homework5;

public class File {
    private String name;
    private String extension;
    private String fullName;
    private Folder parentFolder;

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
