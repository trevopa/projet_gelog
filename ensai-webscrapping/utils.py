import requests
import json

def make_csv_file(wiki_page):
    url = "http://127.0.0.1:5000/csv/" + wiki_page
    response = requests.get(url)
    with open("csv/" + wiki_page + ".csv", "w") as file:
        file.write(response.text)

def get_wiki_pages():
    session = requests.Session()
    url = "https://en.wikipedia.org/w/api.php"
    PARAMS = {
        "action": "query",
        "format": "json",
        "list": "allpages",
        "apfrom": "jungle",
    }

    response = session.get(url=url, params=PARAMS)
    data = response.json()
    pages = data["query"]["allpages"]
    titles = [x["title"] for x in pages]
    return titles

def scrap_pages(pages):
    for page in pages:
        make_csv_file(page)

if __name__ == "__main__":
    # make_csv_file("Comparison of digital SLRs")
    pages = get_wiki_pages()
    scrap_pages(pages)
    