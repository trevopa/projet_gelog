#!/bin/bash

### JAVA PART
cd gelog
mvn install

export url="https://en.wikipedia.org/wiki/List_of_most_visited_websites"
java src/main/java/dtsid/ensai/gelog/strategy/Extractor.java $url
cd ..

### PYTHON PART
cd ensai-webscrapping
python3 -m venv venv
cd ../
source venv/bin/activate
pip install -r ensai-webscrapping/requirements.txt
mkdir csv
python3 ensai-webscrapping/main.py


### COMPARISON PART
file_list=()
for file in csv/*; do
    file_list+=$file
done

echo $file_list

touch diff_res
diff ${file_list[0]} ${file_list[1]} > diff_res

rm -rf csv

deactivate
