package com.github.moregorenine.ztree.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ZTree {
	@Id
	String id; // 본인 id
	String pId; // 부모 id
	String tId; // Ztree 내장 id
	String parentTId; // Ztree 내장 pId
	int grp; // grp : 같은 주제를 갖는 게시물의 고유번호. 부모글과 부모글로부터 파생된 모든 자식글은 같은 번호를 갖는다.
	int seq; // seq : 같은 그룹내 게시물의 순서
	int level; // lvl : 같은 그룹내 계층
	String name;
	String isParent;
	String url; // 메뉴에 연결할 url
	String useYn; // 메뉴 사용여부

	public ZTree() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getParentTId() {
		return parentTId;
	}

	public void setParentTId(String parentTId) {
		this.parentTId = parentTId;
	}

	public int getGrp() {
		return grp;
	}

	public void setGrp(int grp) {
		this.grp = grp;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getOpen() {
//		return open;
//	}
//
//	public void setOpen(String open) {
//		this.open = open;
//	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

//	public List<ZTree> getChildren() {
//		return children;
//	}
//
//	public void setChildren(List<ZTree> children) {
//		this.children = children;
//	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

}
