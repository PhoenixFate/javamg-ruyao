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
import com.thinkgem.javamg.modules.rfb.entity.RfbAward;
import com.thinkgem.javamg.modules.rfb.service.RfbAwardService;

/**
 * 奖品Controller
 * @author shenming
 * @version 2020-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/rfb/rfbAward")
public class RfbAwardController extends BaseController {

	@Autowired
	private RfbAwardService rfbAwardService;
	
	@ModelAttribute
	public RfbAward get(@RequestParam(required=false) String id) {
		RfbAward entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = rfbAwardService.get(id);
		}
		if (entity == null){
			entity = new RfbAward();
		}
		return entity;
	}
	
	@RequiresPermissions("rfb:rfbAward:view")
	@RequestMapping(value = {"list", ""})
	public String list(RfbAward rfbAward, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RfbAward> page = rfbAwardService.findPage(new Page<RfbAward>(request, response), rfbAward); 
		model.addAttribute("page", page);
		return "modules/rfb/rfbAwardList";
	}

	@RequiresPermissions("rfb:rfbAward:view")
	@RequestMapping(value = "form")
	public String form(RfbAward rfbAward, Model model) {
		model.addAttribute("rfbAward", rfbAward);
		return "modules/rfb/rfbAwardForm";
	}

	@RequiresPermissions("rfb:rfbAward:edit")
	@RequestMapping(value = "save")
	public String save(RfbAward rfbAward, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, rfbAward)){
			return form(rfbAward, model);
		}
		rfbAwardService.save(rfbAward);
		addMessage(redirectAttributes, "保存奖品成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbAward/?repage";
	}
	
	@RequiresPermissions("rfb:rfbAward:edit")
	@RequestMapping(value = "delete")
	public String delete(RfbAward rfbAward, RedirectAttributes redirectAttributes) {
		rfbAwardService.delete(rfbAward);
		addMessage(redirectAttributes, "删除奖品成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbAward/?repage";
	}

}