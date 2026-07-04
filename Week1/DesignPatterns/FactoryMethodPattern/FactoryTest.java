public class FactoryTest {
    public static void main(String[] args) {
        System.out.println("Testing Word Document Factory:");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.manageDocument();
        System.out.println();

        System.out.println("Testing PDF Document Factory:");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.manageDocument();
        System.out.println();

        System.out.println("Testing Excel Document Factory:");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.manageDocument();
    }
}
