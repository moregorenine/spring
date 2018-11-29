package com.github.moregorenine.ztree.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.moregorenine.ztree.domain.ZTree;
import com.github.moregorenine.ztree.domain.ZTreeWrapper;

@Controller
public class ZTreeController {
	
	
	@Autowired
	ZTreeService zTreeService;

	@RequestMapping("ztrees")
	public String getAllZTrees(Model model) {
		List<ZTree> ztrees = zTreeService.getAllZTrees();
		model.addAttribute(ztrees);
		return "ztree/ztrees";
	}
	
	@PostMapping("ztrees")
	@ResponseBody
	public String addZTrees(@RequestBody @Valid ZTreeWrapper zTreeWrapper) {
		System.out.println("test");
		return "true";
	}

}
