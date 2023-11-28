import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import model.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import step.ArchiveWorkStep;


import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileParseTest {
    private static final String CSV_FILE = "csv.csv",
            PDF_FILE = "pdf.pdf",
            XLSX_FILE = "xlsx.xlsx",
            ARCHIVE = "zip.zip",
            JSON_FILE = "json.json";

    private final static ClassLoader cl = FileParseTest.class.getClassLoader();
    private final static ObjectMapper mapper = new ObjectMapper();

    private final ArchiveWorkStep step = new ArchiveWorkStep();

    @Test
    void theZipFileShouldHaveThreeDocument() throws Exception {
        String[] files = new String[3];
        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream(ARCHIVE)
        )) {
            ZipEntry entry;
            int i = 0;
            while ((entry = zip.getNextEntry()) != null) {
                files[i] = entry.getName();
                i++;
            }
        }
        Assertions.assertEquals(files.length, 3);
        Assertions.assertEquals(CSV_FILE, files[0]);
        Assertions.assertEquals(PDF_FILE, files[1]);
        Assertions.assertEquals(XLSX_FILE, files[2]);
    }

    @Test
    void theZipFileShouldHavePdfDocument() throws Exception {
        byte[] byteText = step.extractedFile(cl, PDF_FILE);
        PDF actual = new PDF(byteText);
        Assertions.assertTrue(actual.text.contains(FileTestData.PDF_TITLE));
    }

    @Test
    void theZipFileShouldHaveCsvDocument() throws Exception {
        byte[] byteText = step.extractedFile(cl, CSV_FILE);
        CSVReader reader = new CSVReader(
                new InputStreamReader(
                        new ByteArrayInputStream(byteText)));
        var actual = reader.readAll().get(0);
        Assertions.assertAll(
                "check first line csv file",
                () -> Assertions.assertEquals(actual[0], FileTestData.CSV_GROUP.get(0), "number of row"),
                () -> Assertions.assertEquals(actual[1], FileTestData.CSV_GROUP.get(1), "lastname of student"),
                () -> Assertions.assertEquals(actual[2], FileTestData.CSV_GROUP.get(2), "group of student")
        );
    }

    @Test
    void theZipFileShouldHaveXlsxDocument() throws Exception {
        byte[] byteText = step.extractedFile(cl, XLSX_FILE);
        XLS xls = new XLS(byteText);
        var actual = xls.excel.getSheetAt(0).getRow(1);
        Assertions.assertAll(
                "check first line xlsx file",
                () -> Assertions.assertEquals(String.valueOf(actual.getCell(0).getRowIndex()), FileTestData.CSV_GROUP.get(0), "number of row"),
                () -> Assertions.assertEquals(actual.getCell(1).getStringCellValue(), FileTestData.CSV_GROUP.get(1), "lastname of student"),
                () -> Assertions.assertEquals(actual.getCell(2).getStringCellValue(), FileTestData.CSV_GROUP.get(2), "group of student")
        );
    }

    @Test
    void theJsonFileHaveThreeStudentTest() throws Exception{
        var is = cl.getResourceAsStream(JSON_FILE);
        Organization actual = mapper.readValue(is, Organization.class);
        Assertions.assertEquals(actual.getOrganization(), "School №8");
        Assertions.assertEquals(actual.getStudents().get(0).getLastname(), "Ivanov");
    }
}
