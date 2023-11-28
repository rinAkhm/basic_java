package step;

import com.codeborne.pdftest.PDF;

import java.io.File;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.fail;

public class ArchiveWorkStep {
    private final static ClassLoader cl = ArchiveWorkStep.class.getClassLoader();
    private static final String ARCHIVE = "zip.zip";

    public byte[] extractedFile(ClassLoader cl, String fileName) throws Exception {
        byte[] file = null;
        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream(ARCHIVE)
        )) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                if (entry.getName().equalsIgnoreCase(fileName)) {
                    file = zip.readAllBytes();
                }
            }
            return file;
        }
    }

    private String getExtension(String file) {
        String name = new File(file).getName();
        int index = name.lastIndexOf('.');
        return index > 0 ? name.substring(index + 1) : "";
    }
}
