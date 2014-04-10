import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class TSVProcessor {

    private static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // firstName
                new NotNull(), // lastName
                new NotNull(), // street
                new NotNull(), // city
                new NotNull(), // zip
                new NotNull(), // phone
                new NotNull(), // email
        };

        return processors;
    }

    /**
     * Using CsvMapReader.
     */
    private static void read(String fileName) throws Exception {

        ICsvMapReader mapReader = null;
        try {
            mapReader = new CsvMapReader(new FileReader(fileName), CsvPreference.TAB_PREFERENCE);

            // the header columns are used as the keys to the Map
            final String[] header = mapReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Map<String, Object> customerMap;
            while ((customerMap = mapReader.read(header, processors)) != null) {
                System.out.println(String.format("lineNo=%s, rowNo=%s, customerMap=%s", mapReader.getLineNumber(),
                        mapReader.getRowNumber(), customerMap));
            }

        } finally {
            if ( mapReader != null ) {
                mapReader.close();
            }
        }
    }

    /**
     * Using CsvMapWriter.
     */
    private static void write() throws Exception {

        final String[] header = new String[] {"firstName", "lastName", "street", "city", "zip", "phone", "email"};

        // TODO take string input from the GUI fields and put into a map

        // create the customer Maps (using the header elements for the column keys)
        final Map<String, Object> john = new HashMap<String, Object>();
//        john.put(header[0], "1");
//        john.put(header[1], "John");
//        john.put(header[2], "Dunbar");
//        john.put(header[3], new GregorianCalendar(1945, Calendar.JUNE, 13).getTime());
//        john.put(header[4], "1600 Amphitheatre Parkway\nMountain View, CA 94043\nUnited States");
//        john.put(header[5], null);
//        john.put(header[6], null);
//        john.put(header[7], "\"May the Force be with you.\" - Star Wars");
//        john.put(header[8], "jdunbar@gmail.com");
//        john.put(header[9], 0L);

        final Map<String, Object> bob = new HashMap<String, Object>();
//        bob.put(header[0], "2");
//        bob.put(header[1], "Bob");
//        bob.put(header[2], "Down");
//        bob.put(header[3], new GregorianCalendar(1919, Calendar.FEBRUARY, 25).getTime());
//        bob.put(header[4], "1601 Willow Rd.\nMenlo Park, CA 94025\nUnited States");
//        bob.put(header[5], true);
//        bob.put(header[6], 0);
//        bob.put(header[7], "\"Frankly, my dear, I don't give a damn.\" - Gone With The Wind");
//        bob.put(header[8], "bobdown@hotmail.com");
//        bob.put(header[9], 123456L);

        ICsvMapWriter mapWriter = null;
        try {
            mapWriter = new CsvMapWriter(new FileWriter("store.tsv"), CsvPreference.TAB_PREFERENCE);

            final CellProcessor[] processors = getProcessors();

            // write the header
            mapWriter.writeHeader(header);

            // write the customer maps
            mapWriter.write(john, header, processors);
            mapWriter.write(bob, header, processors);

        }
        finally {
            if (mapWriter != null) {
                mapWriter.close();
            }
        }
    }
}
