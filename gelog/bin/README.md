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

### Default page

Copy the following link.
```
http://localhost:8080/hello
```

### Your own page

Copy the following link by replacing XXX by the name of the wikipedia page.
```
http://localhost:8080/hello?site=XXX
```