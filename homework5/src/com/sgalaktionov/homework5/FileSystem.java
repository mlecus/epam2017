package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolException;


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

    private void checkForNullOrEmptyInstanceName(String instanceName) {

        if ((instanceName == null) || (instanceName.equals(""))) {
            throw new IllegalArgumentException("nothig to do");
        }
    }

    private void checkForEmptyExtension(String instanceName) {

        int length = instanceName.length();
        if (instanceName.charAt(length - 1) == FileSystem.EXTENSION_DIVIDER) {
            throw new FSInvalidSymbolException("empty extension in \"" + instanceName + "\" command at " + (length - 1) + " position");
        }
    }

    private void checkForEmptyTargetFolder(String instanceName) {

        int length = instanceName.length();
        if (instanceName.charAt(length - 1) == FileSystem.FOLDER_DIVIDER) {
            throw new FSInvalidSymbolException("empty targe folder name in \"" + instanceName + "\" command at " + (length - 1) + " position");
        }
    }

    private void checkForSpecialSymbolsInExtension(String instanceName) {
        int extensionDividerPosition = instanceName.indexOf(FileSystem.EXTENSION_DIVIDER);

        if (extensionDividerPosition != -1) {
            String extension = instanceName.substring(extensionDividerPosition + 1);
            for (char ch : FileSystem.SPECIAL_SYMBOLS.toCharArray()) {
                if (extension.indexOf(ch) != -1) {
                    throw new FSInvalidSymbolException("special symbol in extension " + ch + " in \" " + instanceName + "\" command at "
                            + (extensionDividerPosition + extension.indexOf(ch)) + " position");
                }
            }
        }
    }

    private void checkForEmptyFileName(String instanceName) {
        if (instanceName.contains("/.")) {
            throw new FSInvalidSymbolException("empty file name in \"" + instanceName + "\" command at " + instanceName.indexOf("/.") + " position");
        }
    }

    private void checkForEmptyRootFileName(String instanceName) {
        if (instanceName.indexOf(".") == 0) {
            throw new FSInvalidSymbolException("empty file name in \"" + instanceName + "\" command at " + instanceName.indexOf(".") + " position");
        }
    }

    private void checkForEmptySubFolderName(String instanceName) {
        if (instanceName.contains("//")) {
            throw new FSInvalidSymbolException("empty subfolder name in \"" + instanceName + "\" command at " + instanceName.indexOf("//") + " position");
        }
    }

    private void checkForEmptyRootSubFolderName(String instanceName) {
        if (instanceName.indexOf("/") == 0) {
            throw new FSInvalidSymbolException("empty subfolder name in \"" + instanceName + "\" command at " + instanceName.indexOf("//") + " position");
        }
    }

    public void validateInstanceName(String instanceName) {

        checkForNullOrEmptyInstanceName(instanceName);
        checkForEmptyExtension(instanceName);
        checkForEmptyTargetFolder(instanceName);
        checkForSpecialSymbolsInExtension(instanceName);
        checkForEmptyFileName(instanceName);
        checkForEmptyRootFileName(instanceName);
        checkForEmptySubFolderName(instanceName);
        checkForEmptyRootSubFolderName(instanceName);
    }

    public void fileSystemAddInstance(String instance) {
        String name;
        String path;
        Folder currentFolder = root;

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
            if (subFolder == null) {
                subFolder = new Folder(subFolderName);
                currentFolder.addFolder(subFolder);
            }

            currentFolder = subFolder;
        }

        //if (name.contains(EXTENSION_DIVIDER)) {
        if (name.indexOf(EXTENSION_DIVIDER) != -1) {
            currentFolder.addFile(new File(name));
        } else {
            name += "/";
            currentFolder.addFolder(new Folder(name));
        }
    }

    public String print() {
        return this.root.toString();
    }
}
