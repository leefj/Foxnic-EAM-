package com.dt.platform.oa.page;

import com.dt.platform.constants.enums.oa.NetDiskFileTypeEnum;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.proxy.oa.NetdiskOriginFileServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.NetdiskFileServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 文件模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:19:48
*/

@Controller("OaNetdiskFilePageController")
@RequestMapping(NetdiskFilePageController.prefix)
public class NetdiskFilePageController extends ViewController {

	public static final String prefix="business/oa/netdisk_file";

	private NetdiskFileServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NetdiskFileServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetdiskFileServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 文件 功能主页面
	 */
	@RequestMapping("/netdisk_file_list.html")
	public String list(Model model,HttpServletRequest request,String fileType) {
		
		model.addAttribute("fileType",fileType);
		return getTemplatePath(prefix,"netdisk_file_list");
	}

	/**
	 * 文件 表单页面
	 */
	@RequestMapping("/netdisk_file_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"netdisk_file_form");
	}



	/**
	 * 文件 表单页面
	 */
	@RequestMapping("/select_folder_form.html")
	public String selectFolderForm(Model model,HttpServletRequest request , String data) {
		model.addAttribute("data",data);
		return getTemplatePath(prefix,"select_folder_form");
	}


	/**
	 * 预览
	 */
	@RequestMapping("/view.html")
	public String view(Model model,HttpServletRequest request , String id,String type) {

		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		String ext=originFile.getExtValue();
		String fileType=originFile.getFileType();
		model.addAttribute("id",id);
		model.addAttribute("fd",originFile);
		model.addAttribute("type",type);
		model.addAttribute("fileExt",ext);
		if("doc".equals(ext)
				||"docx".equals(ext)
				||"xls".equals(ext)
				||"ppt".equals(ext)
				||"pptx".equals(ext)
				||"xlsx".equals(ext)){
			return getTemplatePath(prefix,"view_office_to_html");
		}
		if("pdf".equals(ext)){
			return getTemplatePath(prefix,"view_pdf");
		}

		if("mp4".equals(ext)){
			return getTemplatePath(prefix,"view_video");
		}
		if("txt".equals(ext)
				|"text".equals(ext)
				||"sql".equals(ext)
				||"sh".equals(ext)
				||"md".equals(ext)
				||"json".equals(ext)
				||"conf".equals(ext)
				||"js".equals(ext)
				||"css".equals(ext)
				||"java".equals(ext)
				||"php".equals(ext)
				||"py".equals(ext)
				||"xml".equals(ext)){
			return getTemplatePath(prefix,"view_txt");
		}
		if(NetDiskFileTypeEnum.FILE_MUSIC.code().equals(fileType)){
			return getTemplatePath(prefix,"view_music");
		}
		if(NetDiskFileTypeEnum.FILE_VIDEO.code().equals(fileType)){
			return getTemplatePath(prefix,"view_video");
		}
		if(NetDiskFileTypeEnum.FILE_PHOTO.code().equals(fileType)){
			return getTemplatePath(prefix,"view_photo");
		}
		return getTemplatePath(prefix,"view");
	}


	/**
	 * 预览
	 */
	@RequestMapping("/view_office_to_html.html")
	public String officeToHtml(Model model,HttpServletRequest request , String id,String type) {
		model.addAttribute("id",id);
		model.addAttribute("type",type);

		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		model.addAttribute("fd",originFile);
		return getTemplatePath(prefix,"view_office_to_html");
	}


	/**
	 * 预览
	 */
	@RequestMapping("/view_doc.html")
	public String viewDoc(Model model,HttpServletRequest request , String id,String type) {
		model.addAttribute("id",id);
		model.addAttribute("type",type);

		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		model.addAttribute("fd",originFile);

		return getTemplatePath(prefix,"view_doc");
	}

	/**
	 * 预览
	 */
	@RequestMapping("/view_photo.html")
	public String viewPhoto(Model model,HttpServletRequest request ,String id, String ids) {

		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		model.addAttribute("fd",originFile);

		model.addAttribute("ids",ids);
		model.addAttribute("id",id);
		return getTemplatePath(prefix,"view_photo");
	}

	/**
	 * 预览
	 */
	@RequestMapping("/view_video.html")
	public String viewVideo(Model model,HttpServletRequest request , String id,String type) {

		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		model.addAttribute("fd",originFile);


		model.addAttribute("id",id);
		model.addAttribute("type",type);
		return getTemplatePath(prefix,"view_video");
	}

	/**
	 * 预览
	 */
	@RequestMapping("/view_music.html")
	public String viewMusic(Model model,HttpServletRequest request , String id,String type) {
		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		model.addAttribute("fd",originFile);
		model.addAttribute("id",id);
		model.addAttribute("type",type);
		return getTemplatePath(prefix,"view_music");
	}

	@RequestMapping("/view_pdf.html")
	public String viewPdf(Model model,HttpServletRequest request , String id,String type) {
		Result<NetdiskOriginFile> originFileResult=NetdiskOriginFileServiceProxy.api().getById(id);
		if(!originFileResult.isSuccess()){
			model.addAttribute("message",originFileResult.getMessage());
			return getTemplatePath(prefix,"view");
		}
		NetdiskOriginFile originFile=originFileResult.getData();
		model.addAttribute("fd",originFile);
		model.addAttribute("id",id);
		model.addAttribute("type",type);
		return getTemplatePath(prefix,"view_pdf");
	}
}