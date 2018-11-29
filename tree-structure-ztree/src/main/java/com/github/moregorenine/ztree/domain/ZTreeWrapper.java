package com.github.moregorenine.ztree.domain;

import java.util.List;

import javax.validation.Valid;

public class ZTreeWrapper {
	@Valid
	List<ZTree> zTrees;

	public List<ZTree> getzTrees() {
		return zTrees;
	}

	public void setzTrees(List<ZTree> zTrees) {
		this.zTrees = zTrees;
	}

}
