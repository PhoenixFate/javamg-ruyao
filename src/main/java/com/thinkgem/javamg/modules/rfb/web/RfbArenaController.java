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
import com.thinkgem.javamg.modules.rfb.entity.RfbArena;
import com.thinkgem.javamg.modules.rfb.service.RfbArenaService;

/**
 * 擂台赛Controller
 * @author shenming
 * @version 2020-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/rfb/rfbArena")
public class RfbArenaController extends BaseController {

	@Autowired
	private RfbArenaService rfbArenaService;
	
	@ModelAttribute
	public RfbArena get(@RequestParam(required=false) String id) {
		RfbArena entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = rfbArenaService.get(id);
		}
		if (entity == null){
			entity = new RfbArena();
		}
		return entity;
	}
	
	@RequiresPermissions("rfb:rfbArena:view")
	@RequestMapping(value = {"list", ""})
	public String list(RfbArena rfbArena, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RfbArena> page = rfbArenaService.findPage(new Page<RfbArena>(request, response), rfbArena); 
		model.addAttribute("page", page);
		return "modules/rfb/rfbArenaList";
	}

	@RequiresPermissions("rfb:rfbArena:view")
	@RequestMapping(value = "form")
	public String form(RfbArena rfbArena, Model model) {
		model.addAttribute("rfbArena", rfbArena);
		return "modules/rfb/rfbArenaForm";
	}

	@RequiresPermissions("rfb:rfbArena:edit")
	@RequestMapping(value = "save")
	public String save(RfbArena rfbArena, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, rfbArena)){
			return form(rfbArena, model);
		}
		rfbArenaService.save(rfbArena);
		addMessage(redirectAttributes, "保存擂台赛成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbArena/?repage";
	}
	
	@RequiresPermissions("rfb:rfbArena:edit")
	@RequestMapping(value = "delete")
	public String delete(RfbArena rfbArena, RedirectAttributes redirectAttributes) {
		rfbArenaService.delete(rfbArena);
		addMessage(redirectAttributes, "删除擂台赛成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbArena/?repage";
	}

}