package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;

import java.util.HashMap;

public class Folder {
    private HashMap<String, File> fileHashMap;
    private HashMap<String, Folder> folderHashMap;
    private String fullPath = "";
    private String folderName;
    private Folder parentFolder;

    protected final String nullFolderMessage = "null folder received ";
    protected final String nullFileMessage = "null file received ";

    public Folder(String folderName) {
        this.folderName = folderName;
        this.folderHashMap = new HashMap<String, Folder>();
        //this.folderHashMap.put(FileSystem.PARENT_FOLDER_SPECIFIER, this);
        this.fileHashMap = new HashMap<String, File>();
    }

    public String getFullPath() {

        return this.fullPath;
    }

    public String getName() {

        return this.folderName;
    }

    public Folder getParentFolder() {

        return this.parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {

        if (parentFolder == null) {
            throw new IllegalArgumentException(nullFolderMessage + "as parent folder");
        }
        this.parentFolder = parentFolder;
        this.fullPath = parentFolder.getFullPath() + parentFolder.getName();
    }

    public File getFile(String fileName) {

        return this.fileHashMap.getOrDefault(fileName, null);
    }

    public boolean containsFile(File file) {

        if (file == null) {
            throw new IllegalArgumentException("null file name received for find in folder");
        }
        File gettedFile = this.getFile(file.getFullName());
        return !(gettedFile == null);
    }

    public void addFile(File file) {

        if (file == null) {
            throw new IllegalArgumentException(nullFileMessage + " for add to folder");
        }
        if (this.containsFile(file)) {
            throw new FSFileAllreadyExistException("file " + file.getFullName() + " allready exist in " + this.fullPath + " folder");
        }
        file.setParentFolder(this);
        this.fileHashMap.put(file.getFullName(), file);
    }

    public Folder getSubFolder(String folderName) {

        /*if (this.folderHashMap.containsKey(folderName)) {
            return this.folderHashMap.get(folderName);
        } else {
            return null;
        }*/
        if (folderName == null) {
            throw new IllegalArgumentException("null folder name received for find as subfolder");
        }
        Folder result = this.folderHashMap.getOrDefault(folderName, null);
        return result;
    }

    private boolean containsFolder(Folder folder) {

        if (folder == null) {
            throw new IllegalArgumentException(nullFolderMessage + "for find as subfolder");
        }
        Folder subFolder = this.getSubFolder(folder.folderName);
        return (!(subFolder == null));
    }

    public void addFolder(Folder folder) {

        /*if (this.folderHashMap.containsKey(folder.getName())) {
            String message = "file " + folder.getName()
                    + " already exist in " + this.fullPath + " folder";
            throw new FSFileAllreadyExistException(message);
        }*/
        if (folder == null) {
            throw new IllegalArgumentException(nullFolderMessage + "for add to folder");
        }
        if (this.containsFolder(folder)) {
            throw new FSFileAllreadyExistException("folder " + folder.getName() + " allready exist in " + this.fullPath + " folder");
        }
        folder.setParentFolder(this);
        //folder.fullPath = this.fullPath + this.folderName;
        this.folderHashMap.put(folder.getName(), folder);
    }


    @Override
    public String toString() {

  /*      StringBuilder sb = new StringBuilder();
        StringBuilder space = new StringBuilder();

        //if (!(this.fullPath == null)) {

        //space.append("|");
        for (int i = 0; i < this.fullPath.length()-1; i++) {
            if (this.fullPath.charAt(i) == '/') {
                //space.append("|   ");
                space.append("|");
            } else {
                space.append(" ");
            }
        }
        //}else{
        //  space.append("|   ");
        //}
        sb.append(space).append(this.getName()).append("\n");
        //space.append("|   ");

*/
        StringBuilder sb = new StringBuilder();
        StringBuilder space = new StringBuilder();
        sb.append(this.getName());
        //sb.append("|   ").append(this.getName()).append("\n");
        //space.append("|");
        for (int i=0; i< this.getFullPath().length();i++) {
            if (this.getFullPath().charAt(i) == FileSystem.FOLDER_DIVIDER){
                //space.append("|");
                space.append("    |");
            }else {
                //space.append(" ");
            }
        }
        /*for (int i=0; i< this.getName().length()-1;i++) {
            space.append(" ");
        }*/
        space.append("    ");

        for (String key : this.folderHashMap.keySet()) {
            if (key.contentEquals(FileSystem.PARENT_FOLDER_SPECIFIER)) {
                sb.append(space).append(FileSystem.PARENT_FOLDER_SPECIFIER).append("\n");
            } else {
                sb.append("\n|").append(space).append(this.getSubFolder(key));
            }
        }
        for (File file : this.fileHashMap.values()) {

            sb.append("\n|").append(space).append(file);
        }
        //XXX
        //sb.deleteCharAt(sb.length() - 1);//.append("|");

        return sb.toString();


    }


}
