package com.github.moregorenine.ztree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.moregorenine.ztree.domain.ZTree;
import com.github.moregorenine.ztree.domain.ZTreeWrapper;
import com.github.moregorenine.ztree.repository.ZTreeRepository;

@Service
public class ZTreeService {

	@Autowired
	private ZTreeRepository zTreeRepository;

	public List<ZTree> getAllZTrees() {
		List<ZTree> zTrees = new ArrayList<>();
		zTrees = zTreeRepository.findAllByOrderByTId();
		return zTrees;
	}

	public void addZTrees(@Valid ZTreeWrapper zTreeWrapper) {
		this.deleteZTrees();
		for(ZTree zTree : zTreeWrapper.getzTrees()) {
			this.loopSetZTreeParent(zTree);
		}		
		zTreeRepository.saveAll(zTreeWrapper.getzTrees());
	}
	
	/**
	 * zTreeWrapper의 parent 세팅하기 위한 재귀호출 함수
	 * @param zTreeWrapper
	 */
	private void loopSetZTreeParent(ZTree zTree) {
		if(zTree.getChildren()!=null) {
			for(ZTree childZTree : zTree.getChildren()) {
				childZTree.setParent(zTree);
				this.loopSetZTreeParent(childZTree);
			}
		}
	}

	public void deleteZTrees() {
		zTreeRepository.deleteAll();
	}

}
