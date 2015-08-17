package com.mingda.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingda.annotation.AccessRequired;
import com.mingda.annotation.AvoidDuplicateSubmission;
import com.mingda.entity.Attorneyrecord;
import com.mingda.entity.SysVUmenu;
import com.mingda.formbean.AttorneyrecordForm;
import com.mingda.service.privilege.SystemMgrService;
import com.mingda.service.privilege.UserService;
import com.mingda.util.TreeMenu;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/main/biz")
public class UserController {

	@Autowired
	private UserService userService;// 注入业务接口
	@Autowired
	private SystemMgrService systemMgrService;// 注入业务接口

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
	
	/*
	 * 页面
	 * */
	@RequestMapping(value = "/aa3.do")
	@AccessRequired(viewtype="jsp")
	@AvoidDuplicateSubmission(needSaveToken = true,viewtype="jsp")
	public String getAttorneyrecordForm(AttorneyrecordForm attorneyrecordForm) {
		/*for (Attorneyrecord s : attorneyrecordForm.getAttorneyrecords()) {
			System.out.println(s.getAttorney());
		}*/
		return "main/biz/aa2";
	}

	@RequestMapping(value = "/aa4.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	@AccessRequired(viewtype="jsp")
	@AvoidDuplicateSubmission(needRemoveToken = true,viewtype="jsp",sendpage="e1.jsp")
	public String getAttorneyrecordForm1(AttorneyrecordForm attorneyrecordForm) {
		Map<String, Object> maps = new HashMap<String, Object>();
		for (Attorneyrecord s : attorneyrecordForm.getAttorneyrecords()) {
			System.out.println(s.getAttorney());
			maps.put(s.getAttorney(), s.getAttorney());
		}
		JSONObject jsonObject = JSONObject.fromObject(maps);
		return jsonObject.toString();
	}

	private JSONArray datajson;

	@RequestMapping(value = "/getmenujson.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String getMenuJson() {

		List<SysVUmenu> menus = systemMgrService.getMenuByUser(new BigDecimal(1));

		//JSONArray menuList1 = JSONArray.fromObject(this.getCategoryList(menus, -1));

		//System.out.println(menuList1);

		JSONArray menuList = JSONArray.fromObject(menus);
		// System.out.println(menuList.toString());

		JSONObject json = new JSONObject();
		json.put("success", true);

		datajson = this.treeMenuList(menuList, -1);

		json.put("data", datajson);

		// String str =
		// "{success:true,data:[{id:1,text:'我的办公桌',leaf:false,children:[{id:3,text:'二级(1)',leaf:true},{id:4,text:'二级(2)',leaf:true},{id:5,text:'二级(3)',leaf:true},{id:6,text:'二级(4)',leaf:false,children:[{id:7,text:'三级(1)',leaf:true},{id:8,text:'三级(2)',leaf:false,children:[{id:33,text:'三级(1)',leaf:true}]}]}]},{id:2,text:'系统管理',leaf:false,children:[{id:9,text:'用户管理',leaf:true}]}]}";
		return json.toString();
	}

	public List<TreeMenu> getCategoryList(List<SysVUmenu> menus, long pid) {
		List<TreeMenu> list = new ArrayList<TreeMenu>();

		for (SysVUmenu s : menus) {
			if (s.getPmId().compareTo(new BigDecimal(pid)) == 0) {
				TreeMenu e = new TreeMenu();
				e.setLeaf("#".equals(s.getMenuurl()) ? false : true);
				e.setMenuid(s.getMenuId().longValue());
				e.setId(s.getMenuId().longValue());
				e.setPid(s.getPmId().longValue());
				e.setText(s.getMenuname());
				e.setUrl(s.getMenuurl());
				e.setChildren(getCategoryList(menus, e.getId()));
				list.add(e);
			}
		}

		return list;

	}

	public JSONArray treeMenuList(JSONArray menuList, int parentId) {
		JSONArray childMenu = new JSONArray();
		for (Object object : menuList) {
			JSONObject jsonMenu = JSONObject.fromObject(object);
			if (jsonMenu.get("menuurl").equals("#")) {
				jsonMenu.put("leaf", false);
			} else {
				jsonMenu.put("leaf", true);
			}

			jsonMenu.put("id", jsonMenu.get("menuId"));
			jsonMenu.put("text", jsonMenu.get("menuname"));
			jsonMenu.put("url", jsonMenu.get("menuurl"));

			int menuId = jsonMenu.getInt("menuId");
			int pid = jsonMenu.getInt("pmId");
			if (parentId == pid) {
				JSONArray c_node = treeMenuList(menuList, menuId);
				jsonMenu.put("children", c_node);
				childMenu.add(jsonMenu);
			}
		}
		return childMenu;
	}
}