/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.javamg.common.config.Global;
import com.thinkgem.javamg.common.persistence.Page;
import com.thinkgem.javamg.common.web.BaseController;
import com.thinkgem.javamg.common.utils.StringUtils;
import com.thinkgem.javamg.modules.rfb.entity.RfbUser;
import com.thinkgem.javamg.modules.rfb.service.RfbUserService;

/**
 * 用户Controller
 * @author shenming
 * @version 2020-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/rfb/rfbUser")
public class RfbUserController extends BaseController {

	@Autowired
	private RfbUserService rfbUserService;
	
	@ModelAttribute
	public RfbUser get(@RequestParam(required=false) String id) {
		RfbUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = rfbUserService.get(id);
		}
		if (entity == null){
			entity = new RfbUser();
		}
		return entity;
	}
	
	@RequiresPermissions("rfb:rfbUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(RfbUser rfbUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RfbUser> page = rfbUserService.findPage(new Page<RfbUser>(request, response), rfbUser); 
		model.addAttribute("page", page);
		return "modules/rfb/rfbUserList";
	}

	@RequiresPermissions("rfb:rfbUser:view")
	@RequestMapping(value = "form")
	public String form(RfbUser rfbUser, Model model) {
		model.addAttribute("rfbUser", rfbUser);
		return "modules/rfb/rfbUserForm";
	}

	@RequiresPermissions("rfb:rfbUser:edit")
	@RequestMapping(value = "save")
	public String save(RfbUser rfbUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, rfbUser)){
			return form(rfbUser, model);
		}
		rfbUserService.save(rfbUser);
		addMessage(redirectAttributes, "保存用户成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbUser/?repage";
	}
	
	@RequiresPermissions("rfb:rfbUser:edit")
	@RequestMapping(value = "delete")
	public String delete(RfbUser rfbUser, RedirectAttributes redirectAttributes) {
		rfbUserService.delete(rfbUser);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbUser/?repage";
	}

}