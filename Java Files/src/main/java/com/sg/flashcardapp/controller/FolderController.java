/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.FolderRepository;
import com.sg.flashcardapp.model.Folder;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author annamaxam
 */
public class FolderController {

    @Autowired
    private FolderRepository folders;

    @GetMapping(value = "/folder/{id}")
    @ResponseBody
    public Folder getFolder(@PathVariable("id") int id) {
        return folders.findOne(id);
    }

    @PostMapping(value = "/folder")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Folder createFolder(@Valid @RequestBody Folder folder) {
        return folders.save(folder);
    }

    @DeleteMapping(value = "/folder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFolder(@PathVariable("id") int id) {
        folders.delete(id);
    }

    @PutMapping(value = "/folder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Folder updateFolder(@PathVariable("id") int id, @Valid @RequestBody Folder folder) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != folder.getFolderId()) {
            throw new UpdateIntegrityException("Contact Id on URL must match Contact Id in submitted data.");
        }
        folders.save(folder);
        
        return folder;
    }

    @GetMapping(value = "/folders")
    @ResponseBody
    public List<Folder> getAllFolders() {
        return folders.findAll();
    }

}
