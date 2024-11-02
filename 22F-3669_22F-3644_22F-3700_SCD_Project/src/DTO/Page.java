package DTO;

public class Page {
    private int pageId;
    private int documentId;
    private String searchResult;

    public Page(int pageId, int documentId, String searchResult) {
        this.pageId = pageId;
        this.documentId = documentId;
        this.searchResult = searchResult;
    }

    public int getPageId() {
        return pageId;
    }
    public int getDocumentId() {
        return documentId;
    }
    public String getSearchResult() {
        return searchResult;
    }

    
}
