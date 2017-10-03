package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;
import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolExtension;

import java.util.HashMap;

public class FileSystem {
    //final public static String FOLDER_DIVIDER ="/";
    //final public static String EXTENSION_DIVIDER =".";

    final public static char FOLDER_DIVIDER = '/';
    final public static char EXTENSION_DIVIDER = '.';
    final public static String PARENT_FOLDER = "..";

    /*final public  char FOLDER_DIVIDER;// = '/';
    final public  char EXTENSION_DIVIDER;// = '.';
    final public  String PARENT_FOLDER;// = "..";
    */
    private Folder root;
    final public static String SPECIAL_SYMBOLS = "/.";
    final public static String VALID_SYMBOLS = "([0-9A-Za-z])\\/.";


    public FileSystem(String rootName /*, char folderDivider, char extensionDivider, String parentFolderSpecifier*/) {

      /*  this.EXTENSION_DIVIDER = extensionDivider;
        this.FOLDER_DIVIDER = folderDivider;
        this.PARENT_FOLDER = parentFolderSpecifier;
      */
        this.root = new Folder(rootName, null);
        this.root.fileHashMap = new HashMap<String, File>();
        this.root.folderHashMap = new HashMap<String, Folder>();
    }

    public String validateInstanceName(String instanceName) {

        int length = instanceName.length();


        //check for empty extension
        if (instanceName.charAt(length - 1) == FileSystem.EXTENSION_DIVIDER){
            throw new FSInvalidSymbolExtension("empty extension in \"" + instanceName + "\" command at " + (length-1) + " position");
        }

        //check for empty ther farest child folder name
        if (instanceName.charAt(length - 1) == FileSystem.FOLDER_DIVIDER) {
            throw new FSInvalidSymbolExtension("empty folder name in \"" + instanceName + "\" command at " + (length-1) + " position");
        }

        //check for special symbols in extension
        int extensionDividerPosition = instanceName.indexOf(FileSystem.EXTENSION_DIVIDER);

        if (extensionDividerPosition!=-1) {
            String extension = instanceName.substring(extensionDividerPosition+1);
            for (char ch:FileSystem.SPECIAL_SYMBOLS.toCharArray()){
                if (extension.indexOf(ch)!=-1){
                    throw new FSInvalidSymbolExtension("special symbol in extension"+ ch + "in \" " + instanceName + "\" command at "
                            + (extensionDividerPosition + extension.indexOf(ch)) + " position");
                }
            }
        }

        //check for empty file name
        if (instanceName.contains("/.")){
            throw new FSInvalidSymbolExtension("empty file name in \"" + instanceName + "\" command at " + instanceName.indexOf("/.") + " position");
        }

        //check for empty a parent folder name
        if (instanceName.contains("//")){
            throw new FSInvalidSymbolExtension("empty folder name in \"" + instanceName + "\" command at " + instanceName.indexOf("//") + " position");
        }

        return instanceName;
    }

public void fileSystemAddInstance(String instance){
    String fullName;
    String path;
    Folder currentFolder = root;
    String currentFolderName ="";

    instance = validateInstanceName(instance);

    //if (instance.contains(FOLDER_DIVIDER)) {
    if (instance.indexOf(FOLDER_DIVIDER) != -1) {
        fullName = instance.substring(instance.lastIndexOf(FOLDER_DIVIDER) + 1, instance.length());
        path = instance.substring(0, instance.lastIndexOf(FOLDER_DIVIDER)+1);
    }else{
        fullName = instance;
        path = "";
    }

    //while(path.contains(FOLDER_DIVIDER)) {
    while (path.indexOf(FOLDER_DIVIDER) != -1) {
        currentFolderName = path.substring(0,path.indexOf(FOLDER_DIVIDER)+1);
        path = path.substring(path.indexOf(FOLDER_DIVIDER)+1);
        if (!currentFolder.folderHashMap.containsKey(currentFolderName)){
            currentFolder.folderHashMap.put(currentFolderName, new Folder(currentFolderName,currentFolder));
        }
        currentFolder  = currentFolder.folderHashMap.get(currentFolderName);
    }
    //if (fullName.contains(EXTENSION_DIVIDER)) {
    if (fullName.indexOf(EXTENSION_DIVIDER) != -1) {
        //add file to folder
        if (!currentFolder.fileHashMap.containsKey(fullName)){
            currentFolder.fileHashMap.put(fullName, new File(fullName));
        }else{
            //System.out.println("file " + fullName + " already exist in folder " + currentFolder.getFullPath());
            throw new FSFileAllreadyExistException("file " + fullName + " already exist in folder " + currentFolder.getFullPath());
        }
    } else {
        //add folder to folder
        fullName+="/";
        if (!currentFolder.folderHashMap.containsKey(fullName)){
            currentFolder.folderHashMap.put(fullName, new Folder(fullName,currentFolder));
        }else{
            //System.out.println("folder " + fullName + " already exist in folder " + currentFolder.getFullPath());
            throw new FSFileAllreadyExistException("file " + fullName + " already exist in folder " + currentFolder.getFullPath());
        }

    }
}

    @Override
    public String toString() {

        //return super.toString();

        /*StringBuilder sb = new StringBuilder();
        //sb.append(this.root.getName()).append("\n");
        for (Folder folder: this.root.folderHashMap.values()) {
            sb.append(folder).append("\n");
        }
        for (File file: this.root.fileHashMap.values()) {
            sb.append(file).append("\n");
        }
        return sb.toString();*/
        return this.root.toString();
    }
}
