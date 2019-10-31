package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

    @PutMapping("{entryId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Entry updateEntry(@PathVariable("entryId") long entryId, @RequestBody Entry entry)  {
        return entryService.updateEntry(entryId,entry);
    }

    @DeleteMapping("/{entryId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteEntry(@PathVariable("entryId") long entryId) {
        try {
            entryService.deleteEntry(entryId);
        } catch(Exception e) {
            return new ResponseEntity<>("Request Couldn't be Processed", HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>("Request was Accepted", HttpStatus.ACCEPTED);

    }
}
