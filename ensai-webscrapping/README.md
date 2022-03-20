# Wikipedia webscrapping app project

Webbscrapping application to scrap wikipedia's pages tables.

# Application purpose

Scrap wikipedia pages.

# List of pages you can test the app on

- Comparison_of_digital_SLRs
- List_of_countries_by_GDP_(nominal)
- List_of_countries_by_past_and_projected_GDP_(nominal)_per_capita
- Comparison_of_network_diagram_software 
- Comparison_of_domestic_robots
- Comparison_of_e-book_formats
- Comparison_of_e-book_readers
- Comparison_of_file_hosting_services
- Comparison_of_machine_translation_applications
- Comparison_of_numerical_analysis_software

# How to execute the app

## Dependencies

```
pip install -r requirements.txt
```

## Run the app

In root folder:

```
flask run
```

To test open a web browser to url: `127.0.0.1:5000/test/Comparison of digital SLRs`

The table of the page should show up. The way it is shown is according to the templates/view.html file.

# Design pattern used

None by now.
