package edu.umb.cs681.hw15;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Directory extends FSElement{

    public Directory(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.appendChild(this);
        }

    }

    private ConcurrentLinkedQueue<FSElement> children = new ConcurrentLinkedQueue<FSElement>();
    private LinkedList<Directory> directory = new LinkedList<Directory>();
    private LinkedList<File> file = new LinkedList<File>();

    @Override
    public boolean isDirectory() {

            if(this instanceof Directory) {
                return true;
            }
            return false;
    }


    public ConcurrentLinkedQueue<FSElement> getChildren(){

            return this.children;

    }

    public void appendChild(FSElement child ){

            this.children.add(child);

    }


    public int countChildren(){

            int countChildren = 0;
            for (FSElement f : this.children)
                countChildren += 1;
            return countChildren;

    }



    public LinkedList<Directory> getSubDirectories(){

            LinkedList<Directory> directories = new LinkedList<>();
            for (FSElement fsElement : children) {
                if (fsElement instanceof Directory)
                    directories.add((Directory) fsElement);
            }
            return directories;

    }


    public LinkedList<File> getFiles(){

            for (FSElement fsElement : children) {
                if (fsElement instanceof File)
                    file.add((File) fsElement);
            }
            return file;

    }

    public int getTotalsize(){

        int totalSize=0;
        for(FSElement f: getChildren()) {
            if(f instanceof Directory) {
                totalSize+= ((Directory)f).getTotalsize();
            }
            else {
                totalSize+= f.getSize();
            }
        }
        return totalSize;

    }

}

