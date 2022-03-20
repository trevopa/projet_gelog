package dtsid.ensai.gelog.strategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Extractor {
	
    private static int idTable=0;
	
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
    

    public static void tableExtractor(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements tables = doc.select("table.wikitable.sortable");

        for (Element table : tables) {
            idTable++;
            
            FileWriter fw = new FileWriter(String.format("./src/main/resources/csv/table_%d.csv", idTable));
            Elements oneTable = table.select("tr");

            for (Element line : oneTable) {
                Elements elementLigne = line.select("th, td");
                
                int j=0;		
                for (Element element : elementLigne) {
                	if (j != 0) {
                    	fw.write(";");
                    }
                	j++;
                    fw.write(element.text()); 
                }
                fw.write("\n");
            }
            fw.close();
        }
    }

}

//