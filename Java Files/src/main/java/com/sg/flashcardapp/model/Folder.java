/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import java.util.Objects;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
public class Folder {
  private int folderId;
  private String folderName;

  public Folder() {
    
  }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.folderId;
        hash = 53 * hash + Objects.hashCode(this.folderName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Folder other = (Folder) obj;
        if (this.folderId != other.folderId) {
            return false;
        }
        if (!Objects.equals(this.folderName, other.folderName)) {
            return false;
        }
        return true;
    }
  
  
    
}
