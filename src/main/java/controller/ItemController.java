package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import repo.ItemRepo;

@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	ItemRepo itemRepo;
	
	@PostMapping("/item")
	public Item createItem(@RequestBody Item item) {
		return itemRepo.save(item);
	}
	
	@GetMapping("/item")
	public List<Item> getItems() {
		return itemRepo.findAll();
	}
	
	@DeleteMapping("/item/{id}")
	public Item deleteItem(@PathVariable String id, Item item) {
		itemRepo.delete(item);
		return item;
	}
	
	@PutMapping("/item/{id}")
	public Item updateItem(@PathVariable Long id,@RequestBody Item item) {
		for(Item it:itemRepo.findAll()) {
			if(it.getId()==item.getId()) {
				itemRepo.save(item);
			}
		}
		return item;
	}

}
