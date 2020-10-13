package com.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class HomeControllerTest {

	@Inject
	@Client("/")
	private RxHttpClient client;
	
	@Test
	public void testHome() {
		HttpRequest<String> req = HttpRequest.GET("/");
		String response = client.toBlocking().retrieve(req);
		assertNotNull(response);
		assertEquals("YAY", response);
	}

}
