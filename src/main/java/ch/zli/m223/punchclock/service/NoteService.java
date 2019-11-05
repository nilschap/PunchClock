package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Note;
import ch.zli.m223.punchclock.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        noteRepository.saveAndFlush(note);
        return noteRepository.saveAndFlush(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public void deleteEntry(Long id) { noteRepository.deleteById(id); }

    public Note updateEntry(Long noteId,Note note) {
        Note note1 = noteRepository.getOne(noteId);
        note1.setText(note.getText());
        note1.setTitle(note.getTitle());
        return noteRepository.save(note1);
    }
}
