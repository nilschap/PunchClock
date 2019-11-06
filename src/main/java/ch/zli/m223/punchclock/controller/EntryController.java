package ch.zli.m223.punchclock.controller;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    /**
     * Returns all entries.
     * @returns List of entries.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }


    /**
     * Creates user.
     * @returns The added Entry.
     * @RequestBody Retrive Entry that should be added
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@RequestBody Entry entry) {
            return entryService.createEntry(entry);
    }

    /**
     * Update entry
     * @returns returns the updated entry
     * @RequestBody Gets new Entry with edited data
     * @PathVariable Gets the EntryId from the entry that will be updated
     */
    @PutMapping("/{entryId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Entry updateEntry(@PathVariable("entryId") long entryId, @RequestBody Entry entry)  {
        return entryService.updateEntry(entryId,entry);
    }


    /**
     * Delete Entry
     * @returns returns the deleted entry
     * @PathVariable Gets the EntryId from the entry that should be deleted
     */
    @DeleteMapping("/{entryId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEntry(@PathVariable("entryId") long entryId) {
            entryService.deleteEntry(entryId);
    }
}
