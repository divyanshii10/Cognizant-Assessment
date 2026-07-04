public abstract class DocumentFactory {
    // The factory method
    public abstract Document createDocument();

    public void manageDocument() {
        // Call the factory method to create a Document object
        Document doc = createDocument();
        // Now use the document
        doc.open();
        doc.save();
        doc.close();
    }
}
