package dtsid.ensai.gelog;


import java.io.IOException;
import java.util.List;

import dtsid.ensai.gelog.strategy.Extractor;

public class TestOnListUrls {
	
	public void test (List<String> list_URL)  throws IOException{
		
		for(String url : list_URL) {
			Extractor.tableExtractor(url);		
		}
		
	}

}
