package com.github.moregorenine.ztree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.moregorenine.ztree.domain.ZTree;
import com.github.moregorenine.ztree.domain.ZTreeWrapper;
import com.github.moregorenine.ztree.repository.ZTreeRepository;

@Service
public class ZTreeService {

	@Autowired
	private ZTreeRepository zTreeRepository;

	/**
	 * zTrees 조회
	 * 
	 * @return
	 */
	public List<ZTree> getAllZTrees() {
		List<ZTree> zTrees = new ArrayList<>();
		zTrees = zTreeRepository.findAllByOrderById();
		// pId 세팅
		for (ZTree zTree : zTrees) {
			zTree.setChildren(null);
			if(zTree.getParent() == null) {
				zTree.setpId(0l);
			} else {
				zTree.setpId(zTree.getParent().getId());
			}
		}
		return zTrees;
	}

	/**
	 * zTrees All delete & All insert
	 * 
	 * @param zTreeWrapper
	 */
	@Transactional
	public void addZTrees(@Valid ZTreeWrapper zTreeWrapper) {
		this.deleteZTrees();
		for (ZTree zTree : zTreeWrapper.getzTrees()) {
			this.loopSetZTreeParent(zTree);
		}
		zTreeRepository.saveAll(zTreeWrapper.getzTrees());
	}

	/**
	 * zTreeWrapper의 parent 세팅하기 위한 재귀호출 함수
	 * 
	 * @param zTreeWrapper
	 */
	private void loopSetZTreeParent(ZTree zTree) {
		if (zTree.getChildren() != null) {
			// 자식이 존재할 경우 자식노드의 부모id 세팅
			for (ZTree childZTree : zTree.getChildren()) {
				childZTree.setParent(zTree);
				this.loopSetZTreeParent(childZTree);
			}
		}
	}

	public void deleteZTrees() {
		zTreeRepository.deleteAll();
	}

}
