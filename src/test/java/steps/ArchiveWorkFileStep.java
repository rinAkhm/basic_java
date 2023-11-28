package steps;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ArchiveWorkFileStep {
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
}
