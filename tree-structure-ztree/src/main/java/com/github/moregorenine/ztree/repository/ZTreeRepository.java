package com.github.moregorenine.ztree.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.moregorenine.ztree.domain.ZTree;

public interface ZTreeRepository extends CrudRepository<ZTree, String>{
	public List<ZTree> findAllByOrderByTId();
}
