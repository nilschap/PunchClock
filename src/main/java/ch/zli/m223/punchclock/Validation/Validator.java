package ch.zli.m223.punchclock.Validation;
import ch.zli.m223.punchclock.domain.Entry;

public class Validator {

    public boolean validateEntry(Entry entry) {
        if(entry.getCheckOut().compareTo(entry.getCheckIn()) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
