package com.jyb.poi;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.pojo.Invest;
import com.jyb.pojo.MarkInfo;
import com.jyb.pojo.User;
import com.jyb.service.InvestService;
import com.jyb.service.MarkInfoService;

/**
 * 资金记录
 * */
@Controller
@RequestMapping("investPoi")
public class InvestPoi {
	@Resource(name="investServiceImpl")
	private InvestService investService;
	@Resource(name="markInfoServiceImpl")
	private MarkInfoService markInfoService;
	
	@RequestMapping("ExportExcel")
	public String ExportExcel(HttpServletResponse response,HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Invest> invests = investService.investPoi(user.getId());
		String []tableHeader={"交易时间","项目","状态","我的投资","我的收益"};
		Integer cellNumber=(Integer)tableHeader.length;//表的列数
		HSSFWorkbook workbook = new HSSFWorkbook();   //创建一个excel
        HSSFCell cell = null;                                    //Excel的列
        HSSFRow row = null;                                      //Excel的行
        HSSFCellStyle style = workbook.createCellStyle();        //设置表头的类型
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCellStyle style1 = workbook.createCellStyle();       //设置数据类型
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = workbook.createFont();                 //设置字体
        HSSFSheet sheet = workbook.createSheet("sheet1");        //创建一个sheet
        HSSFHeader header = sheet.getHeader();//设置sheet的头
        try {              
            if(invests.size() < 1 ){
                header.setCenter("查无资料");
            }else{
                header.setCenter("投资记录");
                row = sheet.createRow(0);
                row.setHeight((short)400);
                for(int k = 0;k < cellNumber;k++){
                    cell = row.createCell(k);//创建第0行第k列
                    cell.setCellValue(tableHeader[k]);//设置第0行第k列的值
                    sheet.setColumnWidth(k,4500);//设置列的宽度
                    font.setColor(HSSFFont.COLOR_NORMAL);      // 设置单元格字体的颜色.
                    font.setFontHeight((short)350); //设置单元字体高度
                    style1.setFont(font);//设置字体风格
                    cell.setCellStyle(style1);
                }
                        
                for(int i = 0 ;i < invests.size() ;i++){                            
                	Invest invest = invests.get(i);//获取student对象
                    row = sheet.createRow((short) (i + 1));//创建第i+1行
                    row.setHeight((short)400);//设置行高
                    if(invest.getBidtime()!= null){
                         cell = row.createCell(0);//创建第i+1行第0列
                         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                         cell.setCellValue(sdf.format(invest.getBidtime()));//设置第i+1行第0列的值
                         cell.setCellStyle(style);//设置风格
                    }
                    if(invest.getTmarkid()!= null){
                        cell = row.createCell(1);//创建第i+1行第0列
                        MarkInfo markInfo = markInfoService.getById(invest.getTmarkid());
                        cell.setCellValue(markInfo.getHeadline());//设置第i+1行第0列的值
                        cell.setCellStyle(style);//设置风格
                    }
                    if(invest.getStatus()!= null){
                        cell = row.createCell(2);//创建第i+1行第0列
                    	if(invest.getStatus()==1) {
                    		cell.setCellValue("竞标中");//设置第i+1行第0列的值
                    	}
                    	if(invest.getStatus()==2) {
                    		cell.setCellValue("流标");//设置第i+1行第0列的值
                    	}
                    	if(invest.getStatus()==3) {
                    		cell.setCellValue("竞标成功");//设置第i+1行第0列的值
                    	}
                    	if(invest.getStatus()==4) {
                    		cell.setCellValue("还款中");//设置第i+1行第0列的值
                    	}
                    	if(invest.getStatus()==5) {
                    		cell.setCellValue("已完成");//设置第i+1行第0列的值
                    	}
                        cell.setCellStyle(style);//设置风格
                    }
                    if(invest.getId()!= null){
                        cell = row.createCell(3);//创建第i+1行第0列
                        cell.setCellValue(invest.getMarkmoney());//设置第i+1行第0列的值
                        cell.setCellStyle(style);//设置风格
                    }
                    if(invest.getId()!= null){
                        cell = row.createCell(4);//创建第i+1行第0列
                        cell.setCellValue(invest.getOverduemoney());//设置第i+1行第0列的值
                        cell.setCellStyle(style);//设置风格
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        OutputStream out = null;//创建一个输出流对象
        try {
            out = response.getOutputStream();//
            String headerStr="";
            headerStr ="Invest";
            headerStr =new String(headerStr.getBytes("gb2312"), "ISO8859-1");//headerString为中文时转码
            response.setHeader("Content-disposition","attachment; filename="+    headerStr+".xls");//filename是下载的xls的名，建议最好用英文
            response.setContentType("application/msexcel;charset=UTF-8");//设置类型
            response.setHeader("Pragma","No-cache");//设置头
            response.setHeader("Cache-Control","no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头
            workbook.write(out);
            out.flush();
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(out!=null){
                    out.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
		return null;
	}
}
