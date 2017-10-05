package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;
import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolExtension;


public class FileSystem {

    final public static char FOLDER_DIVIDER = '/';
    final public static char EXTENSION_DIVIDER = '.';
    final public static String PARENT_FOLDER_SPECIFIER = "..";

    /*final public  char FOLDER_DIVIDER;// = '/';
    final public  char EXTENSION_DIVIDER;// = '.';
    final public  String PARENT_FOLDER_SPECIFIER;// = "..";
    */
    private Folder root;
    final public static String SPECIAL_SYMBOLS = "/.";
    final public static String VALID_SYMBOLS = "([0-9A-Za-z])\\/.";
    /*final public String SPECIAL_SYMBOLS = "/.";
    final public String VALID_SYMBOLS = "([0-9A-Za-z])\\/.";
    */

    public FileSystem(String rootName /*, char folderDivider, char extensionDivider, String parentFolderSpecifier*/) {

      /*  this.EXTENSION_DIVIDER = extensionDivider;
        this.FOLDER_DIVIDER = folderDivider;
        this.PARENT_FOLDER_SPECIFIER = parentFolderSpecifier;
      */
        this.root = new Folder(rootName);
        //root.
        //this.root.fileHashMap = new HashMap<String, File>();
        //this.root.folderHashMap = new HashMap<String, Folder>();
    }

    public void validateInstanceName(String instanceName) {

        if ((instanceName == null) || (instanceName.equals(""))) {
            throw new IllegalArgumentException("nothig to do");
        }
        int length = instanceName.length();


        //check for empty extension
        if (instanceName.charAt(length - 1) == FileSystem.EXTENSION_DIVIDER) {
            throw new FSInvalidSymbolExtension("empty extension in \"" + instanceName + "\" command at " + (length - 1) + " position");
        }

        //check for empty their farest child folder name
        if (instanceName.charAt(length - 1) == FileSystem.FOLDER_DIVIDER) {
            throw new FSInvalidSymbolExtension("empty targe folder name in \"" + instanceName + "\" command at " + (length - 1) + " position");
        }

        //check for special symbols in extension
        int extensionDividerPosition = instanceName.indexOf(FileSystem.EXTENSION_DIVIDER);

        if (extensionDividerPosition != -1) {
            String extension = instanceName.substring(extensionDividerPosition + 1);
            for (char ch : FileSystem.SPECIAL_SYMBOLS.toCharArray()) {
                if (extension.indexOf(ch) != -1) {
                    throw new FSInvalidSymbolExtension("special symbol in extension " + ch + " in \" " + instanceName + "\" command at "
                            + (extensionDividerPosition + extension.indexOf(ch)) + " position");
                }
            }
        }

        //check for empty file name
        if (instanceName.contains("/.")) {
            throw new FSInvalidSymbolExtension("empty file name in \"" + instanceName + "\" command at " + instanceName.indexOf("/.") + " position");
        }

        //check for empty a subfolder folder name
        if (instanceName.contains("//")) {
            throw new FSInvalidSymbolExtension("empty subfolder name in \"" + instanceName + "\" command at " + instanceName.indexOf("//") + " position");
        }

        //return instanceName;
    }

    public void fileSystemAddInstance(String instance) {
        String name;
        String path;
        Folder currentFolder = root;
        String currentFolderName = "";

        validateInstanceName(instance);

        //if (instance.contains(FOLDER_DIVIDER)) {
        if (instance.lastIndexOf(FOLDER_DIVIDER) != -1) {
            name = instance.substring(instance.lastIndexOf(FOLDER_DIVIDER) + 1, instance.length());
            path = instance.substring(0, instance.lastIndexOf(FOLDER_DIVIDER) + 1);
        } else {
            name = instance;
            path = "";
        }

        //while(path.contains(FOLDER_DIVIDER)) {
        while (path.indexOf(FOLDER_DIVIDER) != -1) {
            String subFolderName = path.substring(0, path.indexOf(FOLDER_DIVIDER) + 1);
            path = path.substring(path.indexOf(FOLDER_DIVIDER) + 1);
            Folder subFolder = currentFolder.getSubFolder(subFolderName);
            if (subFolder == null){
                subFolder = new Folder(subFolderName);
                currentFolder.addFolder(subFolder);
            }

            currentFolder = subFolder;
        }

        //if (name.contains(EXTENSION_DIVIDER)) {
        if (name.indexOf(EXTENSION_DIVIDER) != -1)
        {
            currentFolder.addFile(new File(name));
        } else {
            name += "/";
            currentFolder.addFolder(new Folder(name));
            /*if (!currentFolder.folderHashMap.containsKey(name)) {
                currentFolder.folderHashMap.put(name, new Folder(name, currentFolder));
            } else {
                //System.out.println("folder " + name + " already exist in folder " + currentFolder.getFullPath());
                throw new FSFileAllreadyExistException("file " + name + " already exist in folder " + currentFolder.getFullPath());
            }*/

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
