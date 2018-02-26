package com.princeli.vertx.webdemo.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;
import com.princeli.vertx.webdemo.entity.Product;
import com.princeli.vertx.webdemo.entity.dto.ProductDto;
import com.princeli.vertx.webdemo.service.ProductService;

@Path("/product")
public class ProductController {
 
	private ProductService productService;
	
	public ProductController() {
		super();
	}
	
	public ProductController(ApplicationContext context){
		super();
		productService = (ProductService) context.getBean("productService");
	}
 
	@POST
	@Path("/list")
	public Response list(@Form ProductDto productDto) {
		List<Product> list = productService.queryList(productDto);
		return Response.status(200).entity(JSON.toJSONString(list)).build();
	}
	
	@GET
	@Path("/detail/{id}")
	public Response detail(@PathParam("id") Long id) {
		ProductDto productDto = new ProductDto();
		productDto.setId(id);
		Product product = productService.queryOne(productDto);
		return Response.status(200).entity(JSON.toJSONString(product)).build();
	}
	
	@POST
	@Path("/save")
	public Response save(@Form ProductDto productDto) {
		 Product product= productService.save(productDto);
		return Response.status(200).entity(JSON.toJSONString(product)).build();
	}
 
}