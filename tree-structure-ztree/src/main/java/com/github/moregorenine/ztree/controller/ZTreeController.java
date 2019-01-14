package com.github.moregorenine.ztree.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.moregorenine.ztree.domain.ZTree;
import com.github.moregorenine.ztree.domain.ZTreeWrapper;

@RestController
public class ZTreeController {
	
	
	@Autowired
	ZTreeService zTreeService;

	@RequestMapping("/ztrees")
	public ModelAndView getAllZTrees(Model model) {
		List<ZTree> ztrees = zTreeService.getAllZTrees();
		String jsonZTrees = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonZTrees = mapper.writeValueAsString(ztrees);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
//		객체담기
		model.addAttribute("jsonZTrees", jsonZTrees);
		return new ModelAndView("ztree/ztrees");
	}
	
	@PostMapping("/ztrees")
	public RedirectView addZTrees(@RequestBody @Valid ZTreeWrapper zTreeWrapper) {
		zTreeService.addZTrees(zTreeWrapper);
		return new RedirectView("/ztrees");
	}
	
	@DeleteMapping("/ztrees")
	public void deleteZTrees() {
		zTreeService.deleteZTrees();
	}
	

}
