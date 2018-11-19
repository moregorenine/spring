package com.github.moregorenine.ztree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.moregorenine.ztree.domain.ZTree;

@Controller
public class ZTreeController {
	
	
	@Autowired
	ZTreeService zTreeService;

	@RequestMapping("ztrees")
	public String  getAllZTrees(Model model) {
		List<ZTree> ztrees = zTreeService.getAllZTrees();
		model.addAttribute(ztrees);
		return "ztree/ztrees";
	}

}
