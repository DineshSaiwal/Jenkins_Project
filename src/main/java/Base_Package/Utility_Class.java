package Base_Package;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
  
public class Utility_Class extends Base_Class{
	
	private static FileInputStream file;
	public static Sheet sheet;
	public static String Actual_Message;
	
//=================================[ To fetch Excel File Data ] ============================
	
  
    
    public static String getCellData(String SheetName,int rowNumber, int columnNumber) throws IOException {
    	file = new FileInputStream(userdir+"/Files/Bid_Excel.xlsx");
    	sheet= WorkbookFactory.create(file).getSheet(SheetName);
    	Cell cell = sheet.getRow(rowNumber -1).getCell(columnNumber -1);
    	
        String cellValue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                default:
                    throw new RuntimeException("Unsupported cell type");
            }
        }
        
        file.close(); 
        return cellValue;}
    
   
    
    
//===================================[ To Upload External Files ]================================================

    public static void Upload_File(String path_Of_File) throws AWTException, InterruptedException {
    	Robot rb=new Robot();
    	StringSelection Profile = new StringSelection(path_Of_File);
    	rb.delay(2000);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Profile,null);		
    	rb.keyPress(KeyEvent.VK_CONTROL);
    	rb.keyPress(KeyEvent.VK_V);		
    	rb.keyRelease(KeyEvent.VK_CONTROL);
    	rb.keyRelease(KeyEvent.VK_V);		
    	rb.keyPress(KeyEvent.VK_ENTER);
    	rb.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
//===================================[ Screenshot to extent report ]===============================================
    
    	public static String Capture_Screenshot() {
		String Base64Code= ((TakesScreenshot) Base_Class.driver).getScreenshotAs(OutputType.BASE64);	
		return "data:image/jpg;base64, " +Base64Code ;
		}	

 //===================================[ Toast Message Validation ]=================================================
    	

    	public static void Toast_Message_Validation (String Expected_Message) throws Exception  {
    		Thread.sleep(2000);
            WebElement element = driver.findElement(By.xpath("//div[@role='alert']"));
    		Actual_Message = element.getText().replace("\n", " ").trim();
    	 	if (!Actual_Message.equals(Expected_Message.trim())){
                throw new Exception();
            }
    	}
    	
    	
   	
    
}
    	    
    	
		
    	
    	
    	

