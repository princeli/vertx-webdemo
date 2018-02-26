package com.princeli.vertx.webdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.princeli.vertx.webdemo.context.SpringConfiguration;
import com.princeli.vertx.webdemo.verticle.RestEasyVerticle;

import io.vertx.core.Vertx;

/**
 * Runner for the vertx-spring sample
 *
 */
public class MainRunner {

  public static void main( String[] args ) {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new RestEasyVerticle(context));
    System.out.println("Deployment done");
  }

}
