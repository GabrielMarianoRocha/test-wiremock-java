package com.example.wiremockapi.controller;
import com.example.wiremockapi.model.Item;
import com.example.wiremockapi.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class ItemController {
private final ItemService itemService;
public ItemController(ItemService itemService) {
this.itemService = itemService;
}
@GetMapping("/items")
public List<Item> getItems() {
return itemService.fetchItems();
}
}
