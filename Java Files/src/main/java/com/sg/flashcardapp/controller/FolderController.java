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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author annamaxam
 */
public class FolderController {

    @Autowired
    private FolderRepository folders;

    @RequestMapping(value = "/folder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Folder getFolder(@PathVariable("id") int id) {
        return folders.findOne(id);
    }

    @RequestMapping(value = "/folder", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Folder createFolder(@Valid @RequestBody Folder folder) {
        return folders.save(folder);
    }

    @RequestMapping(value = "/folder/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFolder(@PathVariable("id") int id) {
        folders.delete(id);
    }

    @RequestMapping(value = "/folder/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFolder(@PathVariable("id") int id, @Valid @RequestBody Folder folder) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != folder.getFolderId()) {
            throw new UpdateIntegrityException("Contact Id on URL must match Contact Id in submitted data.");
        }
        folders.save(folder);
    }

    @RequestMapping(value = "/folders", method = RequestMethod.GET)
    @ResponseBody
    public List<Folder> getAllFolders() {
        return folders.findAll();
    }

}
