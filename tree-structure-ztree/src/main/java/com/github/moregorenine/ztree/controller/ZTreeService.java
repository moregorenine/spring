package com.github.moregorenine.ztree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.moregorenine.ztree.domain.ZTree;
import com.github.moregorenine.ztree.repository.ZTreeRepository;

@Service
public class ZTreeService {

	@Autowired
	private ZTreeRepository zTreeRepository;

	public List<ZTree> getAllZTrees() {
		List<ZTree> zTrees = new ArrayList<>();
		zTreeRepository.findAll().forEach(zTrees::add);
		return zTrees;
	}

}
