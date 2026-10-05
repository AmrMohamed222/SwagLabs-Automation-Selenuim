package utilies;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Formatter;

public class ExcelFileManager{
    public XSSFSheet sheet;
    public XSSFWorkbook workbook;

    public ExcelFileManager(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExcelFileManager (String filePath,int sheetIndex){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(sheetIndex);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int getRowsCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnsCount(){
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getFormula(int rowIndex, int colIndex){
        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
        return cell.getCellFormula();
    }

    public String getSpecificCellValue(int rowIndex, int colIndex){
        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }
}
