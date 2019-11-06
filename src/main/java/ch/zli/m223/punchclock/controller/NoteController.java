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


    /**
     * Returns all Notes.
     * @returns List of Notes.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }


    /**
     * Creates note.
     * @returns The added note.
     * @RequestBody Retrive Note that should be added
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    /**
     * Update Note
     * @returns returns the updated Note
     * @RequestBody Gets new Note with edited data
     * @PathVariable Gets the NoteId from the Note that will be updated
     */
    @PutMapping("/{noteId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Note updateNote(@PathVariable("noteId") long noteId, @RequestBody Note note)  {
        return noteService.updateEntry(noteId,note);
    }

    /**
     * Delete Note
     * @returns returns the deleted Note
     * @PathVariable Gets the NoteId from the entry that should be deleted
     */
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
