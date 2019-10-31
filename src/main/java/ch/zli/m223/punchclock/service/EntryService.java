package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public void deleteEntry(Long id) { entryRepository.deleteById(id); }

    public Entry updateEntry(Long entryId,Entry entry) {
            Entry entry1 = entryRepository.getOne(entryId);
            entry1.setCheckIn(entry.getCheckIn());
            entry1.setCheckOut(entry.getCheckOut());
            return entryRepository.save(entry1);
    }

}
