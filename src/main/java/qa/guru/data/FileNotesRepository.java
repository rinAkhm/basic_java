package qa.guru.data;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import qa.guru.domain.Note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileNotesRepository implements NoteRepository {
    private final Path pathToFile;


    public FileNotesRepository(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public List<Note> findAllByUsername(String username) {
        List<Note> notes = new ArrayList<>();
        try (InputStream is = Files.newInputStream(pathToFile);
             CSVReader csvReader = new CSVReader(
                     new InputStreamReader(is)
             )) {
            List<String[]> candidate = csvReader.readAll()
                    .stream()
                    .filter(row -> username.equals(row[0]))
                    .collect(Collectors.toList());
            if (candidate.size() != 0) {
                for (String[] note : candidate) {
                    notes.add(new Note(note[0], note[1]));
                }
                return notes;
            }
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Note note) throws IOException {
        Note newNote = Optional.ofNullable(note).orElseThrow();
        String[] noteAsArray = new String[]{newNote.username(), newNote.note()};
        try (OutputStream os = new FileOutputStream(pathToFile.toFile(), true);
                CSVWriter writer = new CSVWriter(
                        new OutputStreamWriter(os))


        ) {
            writer.writeNext(noteAsArray, false);
        }
    }
}
