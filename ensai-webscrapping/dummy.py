from scrapping.basic_extractor import basic_extractor
import pandas
import os


# clean the csv directory
if True:
    for dir in os.listdir("csv"):
        os.remove("csv" + str(dir))

# read wikiurl.txt file
with open("data/wikiurl.txt") as file:
    data = file.readlines()

# remove \n from the pages names
for i, page in enumerate(data):
    data[i] = page[:-1]

# write the extracted csv table in a csv file
pages_wo_tables = []
for page in data:
    try:
        df = basic_extractor("https://en.wikipedia.org/wiki/" + page)
    except ValueError:
        pages_wo_tables.append(page)
    csv = df.to_csv()
    """with open("csv/" + page + ".csv", "w") as f:
        f.write(csv)"""

