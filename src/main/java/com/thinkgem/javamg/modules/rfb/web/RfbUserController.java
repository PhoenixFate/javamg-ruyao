/**
 * 
 */
package com.thinkgem.javamg.modules.rfb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.javamg.common.constants.WeChatConstants;
import com.thinkgem.javamg.common.utils.R;
import com.thinkgem.javamg.common.utils.WeChatUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


	/**
	 * 登录
	 * @param
	 */
	@ResponseBody
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public R login( String code) {

		if(code==null){
			return R.error("code is null");
		}

		// 根据小程序穿过来的code想这个url发送请求
		String url = WeChatConstants.URL+"?appid=" + WeChatConstants.APPID + "&secret=" + WeChatConstants.APP_SECRET + "&js_code=" + code + "&grant_type="+WeChatConstants.GRANT_TYPE;
		System.out.println("url: "+url);
		// 发送请求，返回Json字符串
		String str = WeChatUtils.httpRequest(url, "GET", null);
		// 转成Json对象 获取openid
		JSONObject jsonObject = JSONObject.parseObject(str);

		// 我们需要的openid，在一个小程序中，openid是唯一的
		if(jsonObject.get("openid")!=null){
			String openid = jsonObject.get("openid").toString();
			//为该用户注册账号（已存在不注册）;
			RfbUser user = rfbUserService.createByOpenId(openid);
			System.out.println(openid);
			return R.ok().put("user",user);
		}
		return R.error("获取openid失败");
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

	@RequestMapping(value = "update",method = RequestMethod.POST)
	@ResponseBody
	public R update(@RequestBody RfbUser userInfo) {
		rfbUserService.updateFromWeChat(userInfo);
		return R.ok("更新成功");
	}
	
	@RequiresPermissions("rfb:rfbUser:edit")
	@RequestMapping(value = "delete")
	public String delete(RfbUser rfbUser, RedirectAttributes redirectAttributes) {
		rfbUserService.delete(rfbUser);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/rfb/rfbUser/?repage";
	}

}