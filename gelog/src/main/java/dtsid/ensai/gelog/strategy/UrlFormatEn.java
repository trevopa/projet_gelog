package dtsid.ensai.gelog.strategy;

public class UrlFormatEn implements UrlFormat {

    @Override
    public String urlCreation(String site_name) {

        String site_name_with_underscore = site_name.replace(" ", "_");
        String url = "https://en.wikipedia.org/wiki/" + site_name_with_underscore;

        return url;

    }

}
