from operator import index
from flask import Flask, render_template
from scrapping.basic_extractor import basic_extractor

app = Flask(__name__)

@app.route('/')
def super_endpoint():
    return 'Hello World!'

@app.route('/test/<wiki_page>')
def test_endpoint(wiki_page):
    wiki_url = "https://en.wikipedia.org/wiki/" + wiki_page
    list_df = basic_extractor(wiki_url)
    return render_template("view.html", tables=[df.to_html(classes='data') for df in list_df], titles=["tableau" for df in list_df])

@app.route('/csv/<wiki_page>', methods=['GET'])
def csv_endpoint(wiki_page):
    wiki_url = "https://en.wikipedia.org/wiki/" + wiki_page
    list_df = basic_extractor(wiki_url)
    for i in range(len(list_df)):
        filename = 'csv/' + wiki_page + '_' + str(i) + '.csv'
        list_df[i].to_csv(f'{filename}', index=False)
    return "A enregistré " + str(len(list_df)) + " fichiers csv !"