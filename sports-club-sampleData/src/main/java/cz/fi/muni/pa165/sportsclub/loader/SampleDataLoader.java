package cz.fi.muni.pa165.sportsclub.loader;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author Fabian Norbert
 */
public interface SampleDataLoader {

    /**
     * Loads sample data to the database.
     *
     * @throws IOException
     */
    void loadData() throws IOException, ParseException;
}
