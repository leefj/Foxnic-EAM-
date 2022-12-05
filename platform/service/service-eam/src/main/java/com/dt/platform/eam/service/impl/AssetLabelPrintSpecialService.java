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
import org.checkerframework.checker.tainting.qual.Untainted;
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
			String fontPath=workDir+File.separator+"bin"+File.separator+"simhei.ttf";
			File file = new File(fontPath);
			if(file.exists()){
				System.out.println("pdf Font path:"+fontPath+",pdf Font:simhei");
				PdfFontFactory.register(fontPath,"SIM_HEI");
				KeyFont =PdfFontFactory.createRegisteredFont("SIM_HEI", PdfEncodings.IDENTITY_H);
				valueFont =PdfFontFactory.createRegisteredFont("SIM_HEI",PdfEncodings.IDENTITY_H);
			}else{
				System.out.println("pdf Font path:"+fontPath+" not exist!,pdf Font:STSong");
				KeyFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
				valueFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
			}

			List<AssetLabelLayout> layoutList=printData.getAssetLabelLayoutList().stream().sorted(Comparator.comparing(AssetLabelLayout::getSort)).collect(Collectors.toList());
			Float tableWidthPoint=printData.getTableWidthMM()*printData.PAGE_SIZE_A4_POINT_PER_MM;
			Float tableHeightPoint=printData.getTableHeightMM()*printData.PAGE_SIZE_A4_POINT_PER_MM;
			Float labelWidthPoint=printData.getPointByMM(Float.parseFloat(printData.getLabel().getLabelKeyWidth().toString()));
			Float valueWidthPoint=(tableWidthPoint/2-labelWidthPoint);

			Float imageMarginTop=printData.getPointByMM(Float.parseFloat(printData.getLabel().getImageMarginTop().toString()));
			Float imageMarginBottom=printData.getPointByMM(Float.parseFloat(printData.getLabel().getImageMarginBottom().toString()));

			//表的label value 宽度
			PageSize pageSize =new PageSize(printData.getPageSizeWidth(),printData.getPageSizeHeight());
			Document document = new Document(pdf, pageSize);
			document.setMargins(0,0,0,0);
			Div div = new Div();
			div.setKeepTogether(true);
			div.setWidth(UnitValue.createPercentValue(100));
			div.setHorizontalAlignment(HorizontalAlignment.CENTER);
			div.setVerticalAlignment(VerticalAlignment.MIDDLE);
			div.setMargin(0);
			div.setPadding(0);
			Paragraph paragraphIncludeTable=null;

			System.out.println("document:"+document);
			System.out.println("print setting option list:");
			System.out.println("print page type:"+printData.getPaperType());
			System.out.println("print page columnNumber:"+printData.getPrintColumnNumber());
			System.out.println("print page width(point):"+pageSize.getWidth());
			System.out.println("print page height(point):"+pageSize.getHeight());


			if(assetList!=null){
				System.out.println("print asset label number:"+assetList.size());
				for(int i=0;i<assetList.size();i++){
					Map<String, Object> asset=assetList.get(i);
					String assetCode=asset.getOrDefault("assetCode","none").toString();
					System.out.println("######table asset code:"+assetCode+"######");
					if(i%printData.getPrintColumnNumber()==0){
						if(paragraphIncludeTable!=null){
							System.out.println("i:"+i+",split");
							div.add(paragraphIncludeTable);
						}
						paragraphIncludeTable = new Paragraph();
						paragraphIncludeTable.setTextAlignment(TextAlignment.CENTER);
						paragraphIncludeTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
						paragraphIncludeTable.setVerticalAlignment(VerticalAlignment.MIDDLE);
						paragraphIncludeTable.setMargins(0,0,0,0);
						paragraphIncludeTable.setPaddings(0,0,0,0);
					}

					//设置表格列数
					Table table = new Table(4);
					//table.setFixedLayout();
					table.setWidth(UnitValue.createPointValue(printData.getPointByMM(printData.getTableWidthMM())));
					table.setHeight(UnitValue.createPointValue(printData.getPointByMM(printData.getTableHeightMM())));
					table.setKeepTogether(true);
					table.setPadding(0);
					table.setMarginTop(0);
					table.setMarginBottom(0);
					table.setMarginLeft(printData.getPointByMM(printData.getTableMarginLeftMM()));
					table.setMarginRight(printData.getPointByMM(printData.getTableMarginLeftMM()));
					table.setMarginTop(printData.getPointByMM(printData.getTableMarginTopMM()));
					table.setMarginBottom(printData.getPointByMM(printData.getTableMarginBottomMM()));
					System.out.println("######table layout######");
					System.out.println("print table width mm:"+printData.getTableWidthMM());
					System.out.println("print table height mm:"+printData.getTableHeightMM());
					System.out.println("print table width point:"+tableWidthPoint);
					System.out.println("print table height point:"+tableHeightPoint);
					System.out.println("print table width setting:"+table.getWidth());
					System.out.println("print table height setting:"+table.getHeight());
					System.out.println("print table label width point:"+labelWidthPoint);
					System.out.println("print table value width point:"+valueWidthPoint);
					System.out.println("print table margin top:"+table.getMarginTop());
					System.out.println("print table margin bottom:"+table.getMarginBottom());
					System.out.println("print table margin left:"+table.getPaddingLeft());
					System.out.println("print table margin right:"+table.getPaddingRight());

					//开始绘制表格
					Float keySizePoint=printData.getPointByMM(Float.parseFloat(printData.getLabel().getLabelKeyFontSize().toString()));
					Float labelSizePoint=printData.getPointByMM(Float.parseFloat(printData.getLabel().getLabelValueFontSize().toString()));
					for(int j=0;j<layoutList.size();j++){
						AssetLabelLayout cellLayout= layoutList.get(j);
						Float cellHeightPoint=printData.getPointByMM(Float.parseFloat(cellLayout.getRowHeight().toString()));
						System.out.println("cellHeightPoint:"+cellHeightPoint+",row_span:"+cellLayout.getRowSpan()+",col_span:"+cellLayout.getColSpan());
						String layoutCode=cellLayout.getColCode();
						String layoutType=cellLayout.getType();
						Cell cell=new Cell(cellLayout.getRowSpan(),cellLayout.getColSpan());
						cell.setPadding(0);
						cell.setMargin(0);
						String colValue="";
						if(AsseLabelTableCellTypeEnum.LABEL.code().equals(layoutType)){
							cell.setHeight(cellHeightPoint);
							cell.setMinHeight(cellHeightPoint);
							cell.setMaxHeight(cellHeightPoint);
							cell.setWidth(labelWidthPoint);
							cell.setTextAlignment(TextAlignment.CENTER);
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
						//	cell.setBackgroundColor(ColorConstants.YELLOW);
							colValue=layoutCode;
						}else if(AsseLabelTableCellTypeEnum.VALUE.code().equals(layoutType)){
							cell.setHeight(cellHeightPoint);
							cell.setMinHeight(cellHeightPoint);
							cell.setMaxHeight(cellHeightPoint);
							cell.setWidth(valueWidthPoint);
							cell.setTextAlignment(TextAlignment.LEFT);
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
						//	cell.setBackgroundColor(ColorConstants.YELLOW);
							colValue=asset.getOrDefault(layoutCode,"").toString();

						}else if(AsseLabelTableCellTypeEnum.QR_CODE.code().equals(layoutType)){
							//如果是二维码,高度就是设置的高度
//							cell.setHeight(cellHeightPoint);
//							cell.setMinHeight(cellHeightPoint);
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
							cell.setWidth(valueWidthPoint);
							BigDecimal settingImageWidth=new BigDecimal(valueWidthPoint.toString());
							int w=settingImageWidth.intValue();
							BigDecimal cellImageWidth=new BigDecimal(cellHeightPoint.toString());
							int h=cellImageWidth.intValue();
							int v=w>h?w:h;
							System.out.println(" settingImageWidth width:"+settingImageWidth.toString()+",after:"+w);
							System.out.println("  cellImageWidth width:"+h);
							Image img=this.createImage(AsseLabelTableCellTypeEnum.QR_CODE.code(),assetCode,v-5,v-5);
							Paragraph p=new Paragraph();
							p.setMarginTop(0);
							p.setMarginTop(imageMarginTop);
							p.setMarginBottom(imageMarginBottom);
							p.add(img);
							cell.add(p);
							table.addCell(cell);
					//		table.startNewRow();
							continue;
						}else if(AsseLabelTableCellTypeEnum.BAR_CODE.code().equals(layoutType)){
							//如果是二维码,高度就是设置的高度
							cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
							cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
							BigDecimal wBig=new BigDecimal(valueWidthPoint.toString());
							int w=wBig.intValue();
							BigDecimal hBig=new BigDecimal(cellHeightPoint.toString());
							int h=hBig.intValue();
							System.out.println("value width:"+wBig.toString()+",after:"+w);
							Image img=this.createImage(AsseLabelTableCellTypeEnum.QR_CODE.code(),assetCode,w-2,h-2);
							Paragraph p=new Paragraph();
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
						content.setFont(KeyFont);
						content.setFontSize(labelSizePoint);
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