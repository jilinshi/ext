package com.mingda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingda.annotation.AccessRequired;
import com.mingda.annotation.AvoidDuplicateSubmission;

@Controller
@RequestMapping(value = "/main/base")
public class BaseInfoController {
	
	@RequestMapping(value = "/baseinfoinit.do")
	@AccessRequired(viewtype = "jsp")
	@AvoidDuplicateSubmission(needSaveToken = true, viewtype = "jsp")
	public String baseInfoInit(){
		return "main/base/baseinfo";
	}
	
	@RequestMapping(value = "/createfamilyinit.do")
	@AccessRequired(viewtype = "jsp")
	@AvoidDuplicateSubmission(needSaveToken = true, viewtype = "jsp")
	public String createFamilyInit(){
		return "main/base/createfamily";
	}
}
