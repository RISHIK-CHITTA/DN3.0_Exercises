package FactoryMethodPatternExample;

public class FactoryExcelDocument extends DocumentFactory {
    public Document createDocument(){
        return new ExcelDocument();
    }
}
