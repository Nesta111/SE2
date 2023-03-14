package ae;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


interface UserInterface {
    public String getEmail();
    public void setEmail(String email);
    public void setPassword(String password);
}

public class User {

    private String email;
    private String password;
    private String name;
    private String role;

    public String getEmail(){
        return this.email;
    }

    public String getName(){
        return this.name;
    } 

    public String getRole(){
        return this.role;
    }

    public void setCredentials(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        writeToFile();
    }

    private int writeToFile() throws FileNotFoundException {
        HSSFWorkbook hssfUserBook = new HSSFWorkbook();
        HSSFSheet hssfSheet1 = hssfUserBook.createSheet("UserBook");

        HSSFWorkbook hssfUserBook = null;
        try {
            hssfUserBook = new HSSFWorkbook(new FileInputStream("./staff.xls"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HSSFSheet hssfSheet = hssfUserBook.getSheetAt(0);
        for (Row row : hssfSheet) {
                String name = this.name;
                String email = this.email;
                String password = this.password;
                String role = this.role;
                row.createCell(row.getLastCellNum()).setCellValue(name);
                row.createCell(row.getLastCellNum()).setCellValue(email);
                row.createCell(row.getLastCellNum()).setCellValue(password);
                row.createCell(row.getLastCellNum()).setCellValue(role);
            }
        return 1;
    }
}
