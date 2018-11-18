package com.github.moregorenine.ztree.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ZTree {
	@Id
	@GeneratedValue
	private Long id; // 본인 id
	private String pId; // 부모 id
	private String tId; // Ztree 내장 id
	private String parentTId; // Ztree 내장 pId
	private Long grp; // grp : 같은 주제를 갖는 게시물의 고유번호. 부모글과 부모글로부터 파생된 모든 자식글은 같은 번호를 갖는다.
	private Long seq; // seq : 같은 그룹내 게시물의 순서
	private Long level; // lvl : 같은 그룹내 계층
	private String name;
	private String isParent;
	private String url; // 메뉴에 연결할 url
	private String useYn; // 메뉴 사용여부

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getGrp() {
		return grp;
	}

	public void setGrp(Long grp) {
		this.grp = grp;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

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
