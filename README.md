# ✏️ Arabic Text Editor

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-8+-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)

A comprehensive desktop application for creating, editing, and performing **Natural Language Processing (NLP)** on Arabic text. The editor provides advanced linguistic analysis tools including word segmentation, stemming, lemmatization, POS tagging, TF-IDF scoring, and Arabic-to-English transliteration — all within a user-friendly Java Swing GUI.

---

## ✨ Features

- **📄 File Management** — Create, save, import, and navigate multi-page Arabic text documents stored in MySQL.
- **🔍 Search** — Search for specific words or phrases within documents.
- **✂️ Word Segmentation** — Tokenize Arabic text into meaningful segments using Farasa.
- **📏 Stemming & Lemmatization** — Reduce Arabic words to root forms using Snowball Stemmer and AlKhalil2 Analyzer.
- **🏷️ POS Tagging** — Part-of-speech tagging for Arabic words.
- **📊 TF-IDF, PKL & PMI** — Compute statistical text analysis scores for information retrieval and corpus analysis.
- **🔠 Transliteration** — Convert Arabic text to English transliteration using ICU Transliterator.

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 8+ |
| **GUI** | Java Swing |
| **Database** | MySQL |
| **NLP Libraries** | Farasa (Segmentation), AlKhalil2 (POS/Lemma), Snowball (Stemming) |
| **Transliteration** | ICU4J Transliterator |
| **Architecture** | Layered (BLL → DAL → DTO → PD) with DAO Pattern |

---

## 📐 Project Structure

```
Arabic-Text-Editor/
├── src/
│   ├── BLL/                        # Business Logic Layer
│   │   ├── EditorBusinessLogic.java    # Core NLP & file operations
│   │   └── IEditorBusinessLogic.java   # BLL interface
│   ├── DAL/                        # Data Access Layer
│   │   ├── Editordata.java             # Database operations
│   │   ├── IEditordata.java            # DAL interface
│   │   ├── SQLDAOEditor.java           # DAO factory
│   │   └── DataBaseConnection.java     # MySQL connection manager
│   ├── DTO/                        # Data Transfer Objects
│   │   ├── Files.java                  # File entity
│   │   └── Page.java                   # Page entity
│   ├── EditorAppMain/
│   │   └── ArabicEditorApp.java    # Application entry point
│   ├── PD/                         # Presentation Layer (GUI)
│   │   ├── EditorGUI.java             # Main editor interface
│   │   ├── NewFile.java               # New file creation dialog
│   │   ├── importfile.java            # Database file import
│   │   ├── navigatepages.java         # Page navigation
│   │   ├── searchResults.java         # Search results display
│   │   ├── selectOption.java          # Text format selection
│   │   └── WordPOS.java              # Word analysis display
│   └── config.properties          # DAO configuration
├── .gitignore
├── LICENSE
└── README.md
```

---

## 📦 Getting Started

### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- Required JAR libraries: ICU4J, Farasa, AlKhalil2, Snowball

### Database Setup

1. Create a MySQL database and set up the schema:
   ```sql
   CREATE TABLE Document (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255),
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );

   CREATE TABLE Page (
       id INT AUTO_INCREMENT PRIMARY KEY,
       document_id INT,
       content TEXT,
       page_number INT,
       FOREIGN KEY (document_id) REFERENCES Document(id)
   );
   ```

2. Update the connection details in `src/DAL/DataBaseConnection.java`.

### Running the Application

```bash
# Compile and run
javac -cp "lib/*" src/EditorAppMain/ArabicEditorApp.java
java -cp "lib/*:src" EditorAppMain.ArabicEditorApp
```

Or open the project in an IDE (IntelliJ IDEA / Eclipse) and run `ArabicEditorApp.java`.

---

## 👥 Contributors

- **Saif Ullah** — [GitHub](https://github.com/saif55045)
- **Faizan** — [GitHub](https://github.com/FAIZAN-Bor)

---

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
