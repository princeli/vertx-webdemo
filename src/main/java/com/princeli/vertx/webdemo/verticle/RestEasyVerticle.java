package com.princeli.vertx.webdemo.verticle;

import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;
import org.springframework.context.ApplicationContext;

import com.princeli.vertx.webdemo.controller.ProductController;

import io.vertx.core.AbstractVerticle;

/*
 * ly
 */
public class RestEasyVerticle extends AbstractVerticle {
	
	private final ApplicationContext context;

	public RestEasyVerticle(final ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void start() throws Exception {

		// Build the Jax-RS hello world deployment
		VertxResteasyDeployment deployment = new VertxResteasyDeployment();
		deployment.start();
		deployment.getRegistry().addSingletonResource(new ProductController(context));
		
		// Start the front end server using the Jax-RS controller
		vertx.createHttpServer().requestHandler(new VertxRequestHandler(vertx, deployment)).listen(80, ar -> {
			System.out.println("Server started on port " + ar.result().actualPort());
		});

	}
}
