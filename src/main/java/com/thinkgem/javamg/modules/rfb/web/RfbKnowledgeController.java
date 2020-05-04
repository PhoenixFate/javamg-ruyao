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
import com.thinkgem.javamg.modules.rfb.entity.RfbKnowledge;
import com.thinkgem.javamg.modules.rfb.service.RfbKnowledgeService;

/**
 * 知识库Controller
 * @author shenming
 * @version 2020-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/rfb/rfbKnowledge")
public class RfbKnowledgeController extends BaseController {

	@Autowired
	private RfbKnowledgeService rfbKnowledgeService;
	
	@ModelAttribute
	public RfbKnowledge get(@RequestParam(required=false) String id) {
		RfbKnowledge entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = rfbKnowledgeService.get(id);
		}
		if (entity == null){
			entity = new RfbKnowledge();
		}
		return entity;
	}
	
	@RequiresPermissions("rfb:rfbKnowledge:view")
	@RequestMapping(value = {"list", ""})
	public String list(RfbKnowledge rfbKnowledge, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RfbKnowledge> page = rfbKnowledgeService.findPage(new Page<RfbKnowledge>(request, response), rfbKnowledge); 
		model.addAttribute("page", page);
		return "modules/rfb/rfbKnowledgeList";
	}

	@RequiresPermissions("rfb:rfbKnowledge:view")
	@RequestMapping(value = "form")
	public String form(RfbKnowledge rfbKnowledge, Model model) {
		model.addAttribute("rfbKnowledge", rfbKnowledge);
		return "modules/rfb/rfbKnowledgeForm";
	}

	@RequiresPermissions("rfb:rfbKnowledge:edit")
	@RequestMapping(value = "save")
	public String save(RfbKnowledge rfbKnowledge, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, rfbKnowledge)){
			return form(rfbKnowledge, model);
		}
		rfbKnowledgeService.save(rfbKnowledge);
		addMessage(redirectAttributes, "保存知识库成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbKnowledge/?repage";
	}
	
	@RequiresPermissions("rfb:rfbKnowledge:edit")
	@RequestMapping(value = "delete")
	public String delete(RfbKnowledge rfbKnowledge, RedirectAttributes redirectAttributes) {
		rfbKnowledgeService.delete(rfbKnowledge);
		addMessage(redirectAttributes, "删除知识库成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbKnowledge/?repage";
	}

}