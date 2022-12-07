package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.eam.AsseLabelPrintCodeEnum;
import com.dt.platform.constants.enums.eam.AsseLabelTableCellTypeEnum;
import com.dt.platform.domain.eam.AssetLabelLayout;
import com.dt.platform.domain.eam.meta.AssetLabelPrint;
import com.dt.platform.eam.service.IAssetLabelPrintService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.*;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 变更明细 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:14
 */
@Service("AssetLabelPrintSpecialService")
public class AssetLabelPrintSpecialService implements IAssetLabelPrintService {

	//专用打印标签
	@Override
	public AsseLabelPrintCodeEnum getCode() {
		return AsseLabelPrintCodeEnum.SPECIAL;
	}


	/**
	 * @param printData 打印数据
	 * @return 操作是否成功
	 *
	 * printData 包含:assetList,getTableWidthMM(),getTableHeightMM(),getLabel(),
	 */
	@Override
	public Result print(AssetLabelPrint printData) {

		try {
			String path = System.getProperty("java.io.tmpdir");
			List<Map<String, Object>> assetList=printData.getAssetData();
			String pdfFileName =path + File.separator+ printData.getUuid()+".pdf";
			System.out.println("pdf out file path:"+pdfFileName);
			PdfDocument pdf = new PdfDocument(new PdfWriter(pdfFileName));
			//字体设置
			PdfFont KeyFont=null;
			PdfFont valueFont=null;
			String workDir=System.getProperty("user.dir");
			System.out.println(workDir+File.separator+"bin"+File.separator+"simhei.ttf");
			String fontPath=printData.getLabel().getFontPath();
			String fontAlias=printData.getLabel().getFontType();
			File file = new File(fontPath);
			if(file.exists()){
				System.out.println("pdf Font path:"+fontPath+",pdf Font:"+fontAlias);
				PdfFontFactory.register(fontPath,fontAlias);
				KeyFont =PdfFontFactory.createRegisteredFont(fontAlias, PdfEncodings.IDENTITY_H);
				valueFont =PdfFontFactory.createRegisteredFont(fontAlias,PdfEncodings.IDENTITY_H);

			}else{
				System.out.println("pdf Font path:"+fontPath+" not exist!,pdf Font:STSong");
				KeyFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
				valueFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");

			}

			List<AssetLabelLayout> layoutList=printData.getAssetLabelLayoutList().stream().sorted(Comparator.comparing(AssetLabelLayout::getSort)).collect(Collectors.toList());

			//表格 宽高，标签宽度，字体，设置来自Label
			Float tableWidthPoint=printData.getTableWidthMM()*printData.PAGE_SIZE_A4_POINT_PER_MM;
			Float tableHeightPoint=printData.getTableHeightMM()*printData.PAGE_SIZE_A4_POINT_PER_MM;
			Float labelWidthPoint=printData.getPointByMM(Float.parseFloat(printData.getLabel().getLabelKeyWidth().toString()));
			Float valueWidthPoint=(tableWidthPoint/2-labelWidthPoint);

			//开始绘制表格
			Float keySizePoint=printData.getPointByMM(Float.parseFloat(printData.getLabel().getLabelKeyFontSize().toString()));
			Float labelSizePoint=printData.getPointByMM(Float.parseFloat(printData.getLabel().getLabelValueFontSize().toString()));

			//表格 来自LabelTpl
			Float tableMarginTop=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getLabelTableMarginTop().toString()));
			Float tableMarginBottom=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getLabelTableMarginBottom().toString()));
			Float tableMarginLeft=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getLabelTableMarginLeft().toString()));
			Float tableMarginRight=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getLabelTableMarginRight().toString()));

			//表格 来自LabelTpl
			Float imageWidth=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getImageWidth().toString()));
			Float imageHeight=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getImageHeight().toString()));
			int imageWidthInt=imageWidth.intValue();
			int imageHeightInt=imageHeight.intValue();
		 	Float imageMarginTop=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getImageMarginTop().toString()));
			Float imageMarginBottom=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getImageMarginBottom().toString()));
			Float imageMarginLeft=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getImageMarginLeft().toString()));
			Float imageMarginRight=printData.getPointByMM(Float.parseFloat(printData.getLabelTpl().getImageMarginRight().toString()));

			//表的label value 宽度
			PageSize pageSize =new PageSize(printData.getPageSizeWidth(),printData.getPageSizeHeight());
			Document document = new Document(pdf, pageSize);
			document.setMargins(0,0,0,0);

			Div div = new Div();
			div.setKeepTogether(true);
			div.setHeight(UnitValue.createPercentValue(100));
			div.setWidth(UnitValue.createPercentValue(100));
			div.setHorizontalAlignment(HorizontalAlignment.CENTER);
			div.setVerticalAlignment(VerticalAlignment.MIDDLE);
			div.setTextAlignment(TextAlignment.CENTER);
			div.setMargin(0);
			div.setPadding(0);
			Paragraph paragraphIncludeTable=null;
			System.out.println("document:"+document);
			System.out.println("print setting option list:");
			System.out.println("print page type:"+printData.getPaperType());
			System.out.println("print page columnNumber:"+printData.getPrintColumnNumber());
			System.out.println("print page width(point):"+pageSize.getWidth());
			System.out.println("print page height(point):"+pageSize.getHeight());
			System.out.println("print table width(mm):"+printData.getTableWidthMM());
			System.out.println("print table height(mm):"+printData.getTableHeightMM());
			System.out.println("print table width point:"+tableWidthPoint);
			System.out.println("print table height point:"+tableHeightPoint);
			System.out.println("print table margin top:"+tableMarginTop);
			System.out.println("print table margin bottom:"+tableMarginBottom);
			System.out.println("print table margin left:"+tableMarginLeft);
			System.out.println("print table margin right:"+tableMarginRight);
			System.out.println("print table label width point:"+labelWidthPoint);
			System.out.println("print table value width point:"+valueWidthPoint);
			System.out.println("print image width:"+imageWidthInt);
			System.out.println("print image height:"+imageHeight);
			System.out.println("print image margin top:"+imageMarginTop);
			System.out.println("print image margin bottom:"+imageMarginBottom);
			System.out.println("print image margin left:"+imageMarginLeft);
			System.out.println("print image margin right:"+imageMarginRight);
			if(assetList!=null){
				System.out.println("print asset label number:"+assetList.size());
				for(int i=0;i<assetList.size();i++){
					Map<String, Object> asset=assetList.get(i);
					String assetCode=asset.getOrDefault("assetCode","none").toString();
					System.out.println("######table asset code:"+assetCode+"######");
					if(i%printData.getPrintColumnNumber()==0){
						if(paragraphIncludeTable!=null){
							//System.out.println("i:"+i+",split");
							div.add(paragraphIncludeTable);
						}
						paragraphIncludeTable = new Paragraph();
						paragraphIncludeTable.setWidth(UnitValue.createPercentValue(100));
						paragraphIncludeTable.setHeight(UnitValue.createPercentValue(100));
						paragraphIncludeTable.setTextAlignment(TextAlignment.CENTER);
						paragraphIncludeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
						paragraphIncludeTable.setVerticalAlignment(VerticalAlignment.MIDDLE);
						paragraphIncludeTable.setMargins(0,0,0,0);
						paragraphIncludeTable.setPaddings(0,0,0,0);
					}
					//设置表格列数
					Table table = new Table(4);
					table.setWidth(tableWidthPoint);
					table.setHeight(tableHeightPoint);
					table.setKeepTogether(true);
					table.setPadding(0);
					table.setMarginBottom(0);
					table.setMarginLeft(tableMarginLeft);
					table.setMarginRight(tableMarginRight);
					table.setMarginTop(tableMarginTop);
					table.setMarginBottom(tableMarginBottom);
					System.out.println("######table layout######");
					for(int j=0;j<layoutList.size();j++){
						AssetLabelLayout cellLayout= layoutList.get(j);
						Float cellHeightPoint=printData.getPointByMM(Float.parseFloat(cellLayout.getRowHeight().toString()));
						String layoutCode=cellLayout.getColCode();
						String layoutType=cellLayout.getType();
						Cell cell=new Cell(cellLayout.getRowSpan(),cellLayout.getColSpan());
						cell.setPadding(0);
						cell.setMargin(0);
						String colValue="";
						if(AsseLabelTableCellTypeEnum.LABEL.code().equals(layoutType)){
							cell.setFontSize(keySizePoint);
							cell.setFont(KeyFont);
							cell.setHeight(cellHeightPoint);
							cell.setMinHeight(cellHeightPoint);
							cell.setMaxHeight(cellHeightPoint);
							cell.setWidth(labelWidthPoint);
							cell.setMinWidth(labelWidthPoint);
							cell.setMaxWidth(labelWidthPoint);
							cell.setTextAlignment(TextAlignment.CENTER);
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
						//	cell.setBackgroundColor(ColorConstants.YELLOW);
							colValue=layoutCode;
						}else if(AsseLabelTableCellTypeEnum.VALUE.code().equals(layoutType)){
							cell.setFontSize(labelSizePoint);
							cell.setFont(valueFont);
							cell.setHeight(cellHeightPoint);
							cell.setMinHeight(cellHeightPoint);
							cell.setMaxHeight(cellHeightPoint);
							cell.setWidth(valueWidthPoint);
							cell.setMinWidth(valueWidthPoint);
							cell.setMaxWidth(valueWidthPoint);
							cell.setTextAlignment(TextAlignment.LEFT);
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
							colValue=asset.getOrDefault(layoutCode,"").toString();

						}else if(AsseLabelTableCellTypeEnum.QR_CODE.code().equals(layoutType)){
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
							System.out.println("image current width:"+valueWidthPoint);
							System.out.println("image setting width:"+imageWidthInt+",setting < current width value");
							System.out.println("image setting height:"+imageHeightInt);
							Image img=this.createImage(AsseLabelTableCellTypeEnum.QR_CODE.code(),assetCode,imageWidthInt-5,imageHeightInt-5);
							Paragraph p=new Paragraph();
							p.setMarginTop(imageMarginTop);
							p.setMarginBottom(imageMarginBottom);
							p.setMarginLeft(imageMarginLeft);
							p.setMarginRight(imageMarginRight);
							p.add(img);
							cell.add(p);
							table.addCell(cell);
							continue;
						}else if(AsseLabelTableCellTypeEnum.BAR_CODE.code().equals(layoutType)){
							//如果是条形码，
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
							System.out.println("image setting width:"+imageWidthInt);
							System.out.println("image setting height:"+imageHeightInt);
							System.out.println("image current width:"+valueWidthPoint);
							Image img=this.createImage(AsseLabelTableCellTypeEnum.BAR_CODE.code(),assetCode,imageWidthInt-5,imageHeightInt-5);
							Paragraph p=new Paragraph();
							p.setMarginTop(imageMarginTop);
							p.setMarginBottom(imageMarginBottom);
							p.setMarginLeft(imageMarginLeft);
							p.setMarginRight(imageMarginRight);
							p.add(img);
							cell.add(p);
							table.addCell(cell);
							continue;
						}
						System.out.println("cellLayout code:"+layoutCode+",type:"+layoutType+",value:"+colValue+",rowHeightPoint:"+cellHeightPoint);
						Paragraph content=new Paragraph(colValue);
						content.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
						content.setMargin(0);
						content.setPadding(0);
						//content.setBold();
						cell.add(content);
						table.addCell(cell);
						if(cellLayout.getSort()==40){
							table.startNewRow();
						}
					}
					paragraphIncludeTable.add(table);
				}
			}
			if(paragraphIncludeTable!=null){
				div.add(paragraphIncludeTable);
			}
			if(div!=null){
				document.add(div);
			}
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorDesc.failureMessage("生成pdf失败");
		}
		return ErrorDesc.success();
	}



	private  BitMatrix reduceWhite(BitMatrix matrix, int margin) {
		int tempM = margin * 2;
		int[] rec = matrix.getEnclosingRectangle(); // 获取二维码图案的属性
		int resWidth = rec[2] + tempM;
		int resHeight = rec[3] + tempM;
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); // 按照自定义边框生成新的BitMatrix
		resMatrix.clear();
		for (int i = margin; i < resWidth - margin; i++) { // 循环，将二维码图案绘制到新的bitMatrix中
			for (int j = margin; j < resHeight - margin; j++) {
				if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
					resMatrix.set(i, j);
				}
			}
		}
		return resMatrix;
	}


	public Image createImage(String imageType,String content,int w,int h){
		//图像
		String uid= IDGenerator.getSnowflakeIdString();
		String path = System.getProperty("java.io.tmpdir");
		System.out.println("iamgeType:"+imageType+",w:"+w+",h:"+h+",path:"+path + uid+".jpg");
		BarcodeFormat format = BarcodeFormat.QR_CODE;
		if(AsseLabelTableCellTypeEnum.QR_CODE.code().equals(imageType)){
			format = BarcodeFormat.QR_CODE;
		}else if(AsseLabelTableCellTypeEnum.BAR_CODE.code().equals(imageType)){
			format = BarcodeFormat.CODE_128;
		}
		BitMatrix bitMatrix = null;
		try {
			bitMatrix =reduceWhite( new MultiFormatWriter().encode(content, format, w, h),1);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		BufferedImage buffImg = MatrixToImageWriter.toBufferedImage(bitMatrix);
		File imageFile = new File(path +File.separator+ uid+".jpg");
		Image img=null;
		try {
			ImageIO.write(buffImg,"jpg",imageFile);
			img=new Image(ImageDataFactory.create(path +File.separator+ uid+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(AsseLabelTableCellTypeEnum.QR_CODE.code().equals(imageType)){
			//二维码
			img.setHeight(w);
			img.setWidth(h);
		}else{
			//img.setHeight(25);
		}
		img.setBackgroundColor(ColorConstants.BLUE);
		img.setMargins(0,0,0,0);
		img.setPaddings(0,0,0,0);
		System.out.println("image finish,width:"+img.getWidth()+",height:"+img.getWidth());
		System.out.println("image finish,image width:"+img.getImageWidth()+",image height:"+img.getImageHeight());
		return img;
	}



}