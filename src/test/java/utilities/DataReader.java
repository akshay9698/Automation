package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

    public static HashMap<String, String> storeValues = new HashMap<>();

    public static List<HashMap<String, String>> data(String filepath, String sheetName) {
        
        List<HashMap<String, String>> mydata = new ArrayList<>();
        
        try (FileInputStream fs = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<>();
                
                for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell currentCell = currentRow.getCell(j);
                    
                    if (currentCell == null) {
                        currentHash.put(headerCell.getStringCellValue(), "");
                        continue;
                    }
                    
                    switch (currentCell.getCellType()) {
                        case STRING:
                            currentHash.put(headerCell.getStringCellValue(), currentCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            currentHash.put(headerCell.getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            currentHash.put(headerCell.getStringCellValue(), String.valueOf(currentCell.getBooleanCellValue()));
                            break;
                        case BLANK:
                            currentHash.put(headerCell.getStringCellValue(), "");
                            break;
                        default:
                            System.out.println("Invalid cell type at row " + i + " column " + j);
                            currentHash.put(headerCell.getStringCellValue(), "");
                    }
                }
                mydata.add(currentHash);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mydata;
    }
}
