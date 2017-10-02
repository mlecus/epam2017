package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FileAllreadyExist;

import java.util.HashMap;

public class Folder {
    HashMap <String ,File> fileHashMap;
    HashMap <String ,Folder> folderHashMap;
    private String fullPath;
    private String name;
    private Folder parentFolder;

    public Folder() {

    }

    public Folder(String fullPath) {
        this.fullPath = fullPath;
        if (fullPath.contains(FileSystem.FOLDER_DIVIDER)) {
            this.name = fullPath.substring(fullPath.lastIndexOf(FileSystem.FOLDER_DIVIDER),fullPath.length());
        }else{
            this.name=fullPath;
        }
    }

    public String getFullPath() {
        return fullPath;
    }

    public String getName() {
        return name;
    }

    public void addFile(File file){
        if (!fileHashMap.containsKey(file.getFullName())){
            throw new FileAllreadyExist ("file "+file.getFullName()+" allready exist in "+this.fullPath+" folder");
        }
        fileHashMap.put(file.getFullName(),file);
    }

    public void addFolder(Folder folder) {
        if (!folderHashMap.containsKey(folder.getFullPath())){
            throw new FileAllreadyExist ("file "+folder.getName()+" allready exist in "+this.fullPath+" folder");
        }
        folderHashMap.put(folder.getFullPath(),folder);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
