import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

public class ReadExcle {
    public static void main(String[] args) {
        String path = "E:\\QQ文件\\发票明细表1.xls";
        readExcel(path);
    }


    public static void readExcel(String path) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File file = new File(path);
        FileInputStream fis = null;
        Workbook workBook = null;
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                workBook = WorkbookFactory.create(fis);
                int numberOfSheets = workBook.getNumberOfSheets();
                // sheet工作表
                for (int s = 0; s < numberOfSheets; s++) {
                    Sheet sheetAt = workBook.getSheetAt(s);
                    //获取工作表名称
                    String sheetName = sheetAt.getSheetName();
                    System.out.println("工作表名称：" + sheetName);
                    // 获取当前Sheet的总行数
                    int rowsOfSheet = sheetAt.getPhysicalNumberOfRows();
                    System.out.println("当前表格的总行数:" + rowsOfSheet);
                    // 第一行
                    Row row0 = sheetAt.getRow(0);
                    int physicalNumberOfCells = sheetAt.getRow(0).getPhysicalNumberOfCells();
                    String[] title = new String[physicalNumberOfCells];
                    for (int i = 0; i < physicalNumberOfCells; i++) {
                        title[i] = row0.getCell(i).getStringCellValue();
                    }
                    for (int r = 1; r < rowsOfSheet; r++) {
                        Row row = sheetAt.getRow(r);
                        if (row == null) {
                            continue;
                        } else {
                            int rowNum = row.getRowNum() + 1;
                            System.out.println("当前行:" + rowNum);
                            // 总列(格)
                            //第一列
                            Cell cell1 = row.getCell(1);
                            //第二列
                            Cell cell2 = row.getCell(2);


                            if (cell1.getCellType() == CellType.STRING) {
                                String stringCellValue = cell1.getStringCellValue();
                                System.out.println(stringCellValue);
                            } else {
                                System.out.println("第" + rowNum + "行，第二列[" + title[1] + "]数据错误！");
                            }
                            if (cell2.getCellType() == CellType.NUMERIC) {
                                double doubleCellValue  = cell2.getNumericCellValue();
                                System.out.println(doubleCellValue);
                            } else {
                                System.out.println("第" + rowNum + "行，第三列[" + title[2] + "]数据错误！");
                            }
                        }
                    }
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
