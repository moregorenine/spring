package com.github.moregorenine.ztree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.moregorenine.ztree.domain.ZTree;

@RestController
public class ZTreeController {
	
	
	@Autowired
	ZTreeService zTreeService;

	@RequestMapping("/ztrees")
	public List<ZTree> getAllZTrees() {
		return zTreeService.getAllZTrees();
	}

}
