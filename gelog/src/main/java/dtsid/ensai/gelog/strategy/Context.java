package dtsid.ensai.gelog.strategy;

public class Context {
    private UrlFormat strategy;

    public Context(UrlFormat strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String site_name) {
        return strategy.urlCreation(site_name);
    }
}