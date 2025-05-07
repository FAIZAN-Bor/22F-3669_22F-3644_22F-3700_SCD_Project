# Arabic Text Editor

## Overview

The Arabic Text Editor is a comprehensive tool designed to facilitate the creation, editing, and analysis of Arabic text. It provides various functionalities such as text segmentation, stemming, lemmatization, and more.

## Features

* Create new files and save them to the database
* Import files from the database or local PC
* View and navigate through file pages
* Search for specific words or phrases within files
* Perform word segmentation, stemming, and lemmatization
* Calculate TF-IDF, PKL, and PMI scores for text analysis
* Transliterate Arabic text to English

## Project Structure

* `src/BLL/EditorBusinessLogic.java`: Contains the business logic for the editor, including methods for file operations, text analysis, and more.
* `src/BLL/IEditorBusinessLogic.java`: Interface for the business logic layer.
* `src/DAL/Editordata.java`: Data access layer for interacting with the database.
* `src/DAL/IEditordata.java`: Interface for the data access layer.
* `src/DAL/SQLDAOEditor.java`: Implementation of the data access object factory.
* `src/DTO/Files.java`: Data transfer object for files.
* `src/DTO/Page.java`: Data transfer object for pages.
* `src/EditorAppMain/ArabicEditorApp.java`: Main class to run the application.
* `src/PD/EditorGUI.java`: Graphical user interface for the editor.
* `src/PD/importfile.java`: GUI for importing files from the database.
* `src/PD/navigatepages.java`: GUI for navigating through file pages.
* `src/PD/NewFile.java`: GUI for creating and editing new files.
* `src/PD/searchResults.java`: GUI for displaying search results.
* `src/PD/selectOption.java`: GUI for selecting options between transliterated and Arabic text.
* `src/PD/WordPOS.java`: GUI for displaying word segmentation and POS tagging results.

## Configuration

* `src/config.properties`: Configuration file specifying the DAO factory class.

## Database

* `src/DAL/DataBaseConnection.java`: Manages the database connection.
* The database schema includes tables for `Document` and `Page`.

## Dependencies

* `com.ibm.icu.text.Transliterator`: Used for transliteration.
* `com.qcri.farasa.segmenter.Farasa`: Used for word segmentation.
* `net.oujda_nlp_team.AlKhalil2Analyzer`: Used for POS tagging and lemmatization.
* `org.tartarus.snowball.ext.arabicStemmer`: Used for stemming.

## How to Run

1. Ensure you have a MySQL database set up with the required schema.
2. Update the database connection details in `src/DAL/DataBaseConnection.java`.
3. Run the `src/EditorAppMain/ArabicEditorApp.java` to start the application.

## License

This project is licensed under the MIT License.
