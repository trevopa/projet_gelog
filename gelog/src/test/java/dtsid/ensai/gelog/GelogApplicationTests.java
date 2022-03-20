package dtsid.ensai.gelog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dtsid.ensai.gelog.strategy.Extractor;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GelogApplicationTests {
	
	private static final String CSV_FILE_PATH = "./src/main/resources/csv/table_1.csv";

	@Test
	public void testNbRow() throws IOException {
		
		Extractor.tableExtractor("https://en.wikipedia.org/wiki/Comparison_of_digital_SLRs");

		try (	
				Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180
						.withDelimiter(';')
						.withHeader());) {

			// EXPECTED
			int nb_row_expected = 73;
			// RESULT
			int nb_row = csvParser.getRecords().size();
			// ASSERTION
			assertEquals(nb_row_expected, nb_row);
			}
		};
		
	@Test
	public void testNbColumn() throws IOException {
		
		Extractor.tableExtractor("https://en.wikipedia.org/wiki/Comparison_of_digital_SLRs");

		try (	
				Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180
						.withDelimiter(';')
						.withHeader());) {

			// EXPECTED
			int nb_column_expected = 22;
			// RESULT
			int nb_column = csvParser.getHeaderNames().size();
			// ASSERTION
			assertEquals(nb_column_expected, nb_column);
			}
		};
		
	@Test
	public void testHeaderName() throws IOException {
		
		Extractor.tableExtractor("https://en.wikipedia.org/wiki/Comparison_of_digital_SLRs");

		try (	
				Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.RFC4180
						.withDelimiter(';')
						.withHeader());) {

			// EXPECTED
			List<String> columns_name_expected = new ArrayList<String>();
			columns_name_expected.add("Brand");
			columns_name_expected.add("Model name");
			columns_name_expected.add("Sensor size");
			columns_name_expected.add("Effective megapixels");
			columns_name_expected.add("Lens mount");
			columns_name_expected.add("Viewfinder coverage");
			columns_name_expected.add("Metering zones");
			columns_name_expected.add("Focus points");
			columns_name_expected.add("Lowest ISO");
			columns_name_expected.add("Highest ISO");
			columns_name_expected.add("DxO score");
			columns_name_expected.add("DxO ISO[1]");
			columns_name_expected.add("Cont. shtg");
			columns_name_expected.add("LCD size");
			columns_name_expected.add("Live view");
			columns_name_expected.add("Movie mode");
			columns_name_expected.add("Memory card");
			columns_name_expected.add("Video");
			columns_name_expected.add("Dimensions (mm)");
			columns_name_expected.add("Weight (g)[2]");
			columns_name_expected.add("Announced (date)");
			columns_name_expected.add("Reference");
			// RESULT
			List<String> columns_name = csvParser.getHeaderNames();
			// ASSERTION
			assertEquals(columns_name_expected, columns_name);

		}
	}

}
