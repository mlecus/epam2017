package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;

import java.util.HashMap;

public class Folder {
    HashMap <String ,File> fileHashMap;
    HashMap <String ,Folder> folderHashMap;
    private String fullPath;
    private String folderName;
    //private Folder parentFolder;

    public Folder(String folderName, Folder parent) {
        this.folderName = folderName;
        if (parent != null){
            this.fullPath = parent.getFullPath() + parent.getName();
        }else{
            this.fullPath = "";
        }
        this.folderHashMap = new HashMap<String, Folder>();
        this.folderHashMap.put(FileSystem.PARENT_FOLDER, parent);
        this.fileHashMap   = new HashMap<String, File>();
    }

    public String getFullPath() {
        return fullPath;
    }

    public String getName() {
        return folderName;
    }

    public void addFile(File file){
        if (!fileHashMap.containsKey(file.getFullName())){
            throw new FSFileAllreadyExistException("file "+file.getFullName()+" allready exist in "+this.fullPath+" folder");
        }
        fileHashMap.put(file.getFullName(),file);
    }

    public void addFolder(Folder folder) {
        if (!folderHashMap.containsKey(folder.getFullPath())){
            throw new FSFileAllreadyExistException("file "+folder.getName()+" allready exist in "+this.fullPath+" folder");
        }
        folderHashMap.put(folder.getFullPath(),folder);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder space = new StringBuilder();
        //space.append("|");
        for (int i=0; i< this.fullPath.length()-1;i++){
            if (this.fullPath.charAt(i)=='/'){
                //space.append("|   ");
                space.append("|");
            }else{
                space.append(" ");
            }
        }
        //space = new StringBuilder();
        //space.append(this.fullPath);
        sb.append(space).append(this.getName()).append("\n");
        //space.append(this.getName());
        space.append("|");
        for (int i=1; i< this.getName().length();i++){
            space.append(" ");
        }
        //space.append("|   ");

        for (String key: this.folderHashMap.keySet()) {
            if (key.contentEquals(FileSystem.PARENT_FOLDER)){
                sb.append(space).append(FileSystem.PARENT_FOLDER).append("\n");
            }else {
                sb/*.append(space)*/.append(folderHashMap.get(key)/*.getName()*/).append("\n");
            }
        }
        for (File file: this.fileHashMap.values()) {
            sb.append(space).append(file).append("\n");
        }
        /*XXX*/
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
