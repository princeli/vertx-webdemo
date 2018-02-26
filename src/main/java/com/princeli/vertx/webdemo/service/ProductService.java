package com.princeli.vertx.webdemo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.princeli.vertx.webdemo.entity.Product;
import com.princeli.vertx.webdemo.entity.dto.ProductDto;
import com.princeli.vertx.webdemo.repository.ProductRepository;

/**
 * Simple Spring service bean to expose the results of a trivial database call
 */
@Service
public class ProductService {

  @Autowired
  private ProductRepository repo;

  public List<Product> getAllProducts() {
    return repo.findAll();
  }
  
  /**
   * 查询列表
   * @param productDto
   * @return
   */
  public List<Product> queryList(ProductDto productDto) {
	  Product product = new Product();
	  BeanUtils.copyProperties(productDto, product);
      //创建匹配器，即如何使用查询条件
      ExampleMatcher matcher = ExampleMatcher.matching();//构建对象
      //创建实例
      Example<Product> ex = Example.of(product, matcher); 
	  return repo.findAll(ex);
  }
  
  /**
   * 查询一个
   * @param productDto
   * @return
   */
  public Product queryOne(ProductDto productDto) {
	  Product product = new Product();
	  BeanUtils.copyProperties(productDto, product);
      //创建匹配器，即如何使用查询条件
      ExampleMatcher matcher = ExampleMatcher.matching();//构建对象
      //创建实例
      Example<Product> ex = Example.of(product, matcher); 
	  return repo.findOne(ex).get();
  }
  
  /**
   * 保存
   * @param productDto
   * @return
   */
  public Product save(ProductDto productDto) {
	  Product product = new Product();
	  BeanUtils.copyProperties(productDto, product);
	  product.setCreateTime(new Date());
	  return repo.save(product);
  }

}
