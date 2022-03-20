from bs4 import BeautifulSoup
import requests
import pandas as pd


def basic_extractor(url):
    # avec bs4
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')
    #wikitables = soup.find_all('table', {'class': ["wikitable", "sortable"]})
    wikitables = soup.select("table.wikitable.sortable")
    list_df = []
    for table in wikitables:
        df = pd.read_html(str(table))
        df = pd.DataFrame(df[0])
        list_df.append(df)
    return list_df


