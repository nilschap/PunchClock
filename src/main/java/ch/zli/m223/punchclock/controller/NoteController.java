package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Note;
import ch.zli.m223.punchclock.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ ")
public class NoteController {

    private NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{noteId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Note updateNote(@PathVariable("noteId") long noteId, @RequestBody Note note)  {
        return noteService.updateEntry(noteId,note);
    }

    @DeleteMapping("/{noteId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteNote(@PathVariable("noteId") long noteId) {
        try {
            noteService.deleteEntry(noteId);
        } catch(Exception e) {
            return new ResponseEntity<>("Request Couldn't be Processed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Request was Accepted", HttpStatus.ACCEPTED);
    }

}
