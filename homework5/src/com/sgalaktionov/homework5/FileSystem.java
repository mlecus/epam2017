package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileSystem {
    final public static String FOLDER_DIVIDER ="/";
    final public static String EXTENSION_DIVIDER =".";

    private Folder root;
    final private String SPECIAL_SYMBOLS = FOLDER_DIVIDER+EXTENSION_DIVIDER;
    final private String VALID_SYMBOLS = "([0-9A-Za-z])\\/.";


    public FileSystem() {
        this.root = new Folder("");
    }
    public void fileSystemAddInstance(String instance){

    }

    public String validateInstanceName(String instanceName){

        Pattern pattern = null;
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
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
