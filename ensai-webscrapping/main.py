from scrapping.basic_extractor import basic_extractor
import re
import os
from PyInquirer import prompt

# save tables as csv from wiki
question = prompt([
            {
                'type': 'list',
                'name': 'choice',
                'message': 'Langue de la page wikipedia :',
                'choices': ['fr', 'en', 'abort'],
            },
        ])
lang = question['choice']
if lang == 'abort':
    print("pas de fichier à enregistrer")
else:
    wiki_page = input("titre de la page wiki:")
    wiki_url = "https://" + lang + ".wikipedia.org/wiki/" + wiki_page
    list_df = basic_extractor(wiki_url)
    for i in range(len(list_df)):
        filename = 'csv/' + wiki_page + '_' + str(i) + '.csv'
        list_df[i].to_csv(f'{filename}', index=False)
    print("A enregistré le(s) fichier(s) csv !")