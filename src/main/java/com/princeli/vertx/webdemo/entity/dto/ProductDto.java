package com.princeli.vertx.webdemo.entity.dto;

import java.util.Date;

import javax.ws.rs.FormParam;

/**
 * Trivial JPA entity for vertx-spring demo
 */
public class ProductDto {

	@FormParam("id")
	private Long id;

	@FormParam("productNo")
	private String productNo;

	@FormParam("productName")
	private String productName;

	@FormParam("remark")
	private String remark;

	@FormParam("createTime")
	private Date createTime;

	@FormParam("updateTime")
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
