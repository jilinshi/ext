package com.mingda.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingda.entity.Attorneyrecord;
import com.mingda.formbean.AttorneyrecordForm;
import com.mingda.service.privilege.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/main/biz")
public class UserController {

	@Autowired
	private UserService userService;// 注入业务接口

	@RequestMapping(value = "/aa.do")
	public String getUserById() {
		long id = 1224850;
		System.out.println(id);
		Attorneyrecord userInfo = userService.getById(Attorneyrecord.class, new Long(1224850));
		System.out.println(userInfo.getAId());
		Attorneyrecord userInfo1 = userService.getById(Attorneyrecord.class, new Long(1224850));
		System.out.println(userInfo1.getAId());
		return null;
	}

	@RequestMapping(value = "/aa1.do")
	public String getUserById1(@RequestParam long id) {
		id = 1224850;
		System.out.println(id);
		Attorneyrecord userInfo = userService.getById(Attorneyrecord.class, new Long(1224850));
		System.out.println(userInfo.getAId());
		return null;
	}

	@RequestMapping(value = "/aa3.do")
	public String getAttorneyrecordForm(AttorneyrecordForm attorneyrecordForm) {
		for (Attorneyrecord s : attorneyrecordForm.getAttorneyrecords()) {
			System.out.println(s.getAttorney());
		}
		return "main/biz/aa2";
	}

	@RequestMapping(value = "/aa4.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAttorneyrecordForm1(AttorneyrecordForm attorneyrecordForm) {
		Map<String, Object> maps = new HashMap<String, Object>();
		for (Attorneyrecord s : attorneyrecordForm.getAttorneyrecords()) {
			System.out.println(s.getAttorney());
			maps.put(s.getAttorney(), s.getAttorney());
		}
		JSONObject jsonObject = JSONObject.fromObject(maps);
		return jsonObject.toString();
	}

	@RequestMapping(value = "/getmenujson.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String getMenuJson() {
		String str = "{success:true,data:[{id:1,text:'我的办公桌',leaf:false,children:[{id:3,text:'二级(1)',leaf:true},{id:4,text:'二级(2)',leaf:true},{id:5,text:'二级(3)',leaf:true},{id:6,text:'二级(4)',leaf:false,children:[{id:7,text:'三级(1)',leaf:true},{id:8,text:'三级(2)',leaf:false,children:[{id:33,text:'三级(1)',leaf:true}]}]}]},{id:2,text:'系统管理',leaf:false,children:[{id:9,text:'用户管理',leaf:true}]}]}";
		return str;
	}
}