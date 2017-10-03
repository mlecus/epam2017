package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbol;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileSystem {
    final public static String FOLDER_DIVIDER ="/";
    final public static String EXTENSION_DIVIDER =".";
    final public static String PARENT_FOLDER ="..";

    private Folder root;
    final private String SPECIAL_SYMBOLS = FOLDER_DIVIDER+EXTENSION_DIVIDER;
    final private String VALID_SYMBOLS = "([0-9A-Za-z])\\/.";


    public FileSystem() {
        this.root = new Folder("root/",null);
        this.root.fileHashMap =   new HashMap<String ,File>();
        this.root.folderHashMap = new HashMap<String ,Folder>();
    }
    public void fileSystemAddInstance(String instance){
        String fullName;
        String path;
        Folder currentFolder = root;
        String currentFolderName ="";

        if (instance.contains(FOLDER_DIVIDER)) {
            fullName = instance.substring(instance.lastIndexOf(FOLDER_DIVIDER) + 1, instance.length());
            path = instance.substring(0, instance.lastIndexOf(FOLDER_DIVIDER)+1);
        }else{
            fullName = instance;
            path = "";
        }

        while(path.contains(FOLDER_DIVIDER)) {
            currentFolderName = path.substring(0,path.indexOf(FOLDER_DIVIDER)+1);
            path = path.substring(path.indexOf(FOLDER_DIVIDER)+1);
            if (!currentFolder.folderHashMap.containsKey(currentFolderName)){
                currentFolder.folderHashMap.put(currentFolderName, new Folder(currentFolderName,currentFolder));
            }
            currentFolder  = currentFolder.folderHashMap.get(currentFolderName);
        }
        if (fullName.contains(EXTENSION_DIVIDER)) {
                //add file to folder
            if (!currentFolder.fileHashMap.containsKey(fullName)){
                currentFolder.fileHashMap.put(fullName, new File(fullName));
            }else{
                System.out.println("file " + fullName + "allready exist in folder " + currentFolder.getFullPath());
            }
            } else {
                //add folder to folder
            if (!currentFolder.folderHashMap.containsKey(fullName)){
                currentFolder.folderHashMap.put(currentFolderName, new Folder(currentFolderName,currentFolder));
            }else{
                System.out.println("folder " + fullName + "allready exist in filder " + currentFolder.getFullPath());
            }

            }
    }

    public String validateInstanceName(String instanceName){

        /*Pattern pattern = null;
        try
        {
            pattern = Pattern.compile(VALID_SYMBOLS);
        }
        catch(PatternSyntaxException e)
        {
            e.printStackTrace();
        }
        if(pattern == null)
        {
            //return false;
        }
        final Matcher regexp = pattern.matcher(instanceName);
        if (regexp.matches()){
            return instanceName;
        }else{
            throw new FSInvalidSymbol("invalid symbol");
        }*/
        return instanceName;
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
