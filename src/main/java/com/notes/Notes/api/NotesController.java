package com.notes.Notes.api;

import com.notes.Notes.model.Labels;
import com.notes.Notes.model.Notes;
import com.notes.Notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
public class NotesController {

    @Autowired
    private NotesService notesService;


    @PostMapping("/api/v1/addNote")
    public String addNotes(@RequestBody Notes notes)
    {
        notesService.addNotes(notes);
        return "success";
    }

    @GetMapping("/allNotes")
    public String getAllNotes()
    {
        return notesService.getAllNotes();
    }

    @GetMapping("/allFavouriteNotes")
    public String getAllFavNotes()
    {
        return notesService.getAllFavouriteNotes();
    }

    @GetMapping("/notes/{notesId}")
    public Notes getNoteById(@PathVariable long notesId) throws Exception
    {
        return notesService.getNoteByID(notesId);
    }

    @PostMapping("/api/v1/updateNote")
    public String updateNote(@RequestBody Notes notes)
    {
        notesService.updateNote(notes);
        return "success";
    }

    @PostMapping("/api/v1/addFavourite")
    public String addFavourite(@RequestParam (name="notesId", required = true) long notesId)
    {
        notesService.setIsFavourite(notesId);
        return "success";
    }

    @PostMapping("/api/v1/removeFavourite")
    public String removeFavourite(@RequestParam (name="notesId", required = true) long notesId)
    {
        notesService.removeFavourite(notesId);
        return "success";
    }

    @DeleteMapping("/api/v1/deleteNote")
    public String deleteNote(@RequestParam(name="notesId",required = true)long notesId)
    {
        notesService.deleteNote(notesId);
        return "success";
    }
}
