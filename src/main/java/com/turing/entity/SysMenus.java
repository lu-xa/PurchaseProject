package com.turing.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SysMenus {
    private Long id;
    @JsonProperty("pid")
    private Long parentId;

    private Long seq;

    @JsonProperty("text")
    private String name;

    private String tip;

    private String descn;

    private String imageUrl;

    private String linkUrl;

    private String target;

    private String status;
    
    private List<SysMenus> children = new ArrayList<SysMenus>();//自己下的子节点集合

    public List<SysMenus> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenus> children) {
		this.children = children;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}