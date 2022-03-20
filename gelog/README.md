# gelog

## Maven installation:
If you already have maven installed, skip this step.
In terminal (assuming you have debian distribution):
```
sudo apt install maven
```
## Launch springboot app

In terminal:
```
mvn spring-boot:run
```

## Scrap tables from a wikipedia page

### Welcome page

Go to the following link once you have started the app.
```
http://localhost:8080/
```

### Search page

```
http://localhost:8080/search
```

In this page you will need to fill a form that gives the name of the Wikipedia page you want to extract tables from, and the language of the page.
For now, only French and English are supported, but who knows, maybe one day there will be a lot more languages !

