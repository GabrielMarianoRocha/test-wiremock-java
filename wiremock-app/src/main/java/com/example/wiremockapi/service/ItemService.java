package com.example.wiremockapi.service;

import com.example.wiremockapi.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {
	private final RestTemplate restTemplate;
	@Value("${wiremock.base-url:http://localhost:8080}")
	private String wiremockBaseUrl;

	public ItemService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Item> fetchItems() {
		String url = wiremockBaseUrl + "/products";
		Item[] items = restTemplate.getForObject(url, Item[].class);
		return Arrays.asList(items);
	}
}