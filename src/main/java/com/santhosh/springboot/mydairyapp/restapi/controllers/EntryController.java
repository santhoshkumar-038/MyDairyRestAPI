package com.santhosh.springboot.mydairyapp.restapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.springboot.mydairyapp.restapi.entity.Entry;
import com.santhosh.springboot.mydairyapp.restapi.service.EntryService;

import jakarta.websocket.server.PathParam;

@RestController
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	@GetMapping("/entries/")
	public List<Entry> findAllEntry() {
		List<Entry> entries = entryService.findAll();
		return entries;
	}
	
	@PostMapping("/entries/")
	public Entry saveEntry(@RequestBody Entry entry) {
		Entry savedEntry = entryService.saveEntry(entry);
		return savedEntry;
	}
	
	@PutMapping("/entries/")
	public Entry updateEntry(@RequestBody Entry entry) {
		Entry updatedEntry = entryService.updateEntry(entry);
		return updatedEntry;
	}
	
	@PutMapping("/entries/{id}")
	public Entry updateEntry1(@PathVariable("id") int id, @RequestBody Entry entry) {
		Entry entry1 = entryService.findById(id); //entry1 data is from DB
		//we are setting data to entry1 with entry data provided through request body
		entry1.setDescription(entry.getDescription());
		entry1.setEntrydate(entry.getEntrydate());
		entry1.setUserid(entry.getUserid());
		
		Entry updatedEntry = entryService.updateEntry(entry1);
		return updatedEntry;
	}
	
	@PatchMapping("/entries/{id}")
	public Entry updateEntry2(@PathVariable("id") int id, @RequestBody Entry entry) {
		Entry entry1 = entryService.findById(id); //entry1 data is from DB
		//we are setting data to entry1 with entry data provided through request body
		
		String desc = entry.getDescription();
		Date date = entry.getEntrydate();
		long userid = entry.getUserid();
		
		if (desc!=null && desc.length() > 0) {
			entry1.setDescription(entry.getDescription());
		}
		
		if (date != null) {
			entry1.setEntrydate(entry.getEntrydate());
		}
		
		if (userid > 0) {
			entry1.setUserid(entry.getUserid());
		}
		
		Entry updatedEntry = entryService.updateEntry(entry1);
		return updatedEntry;
	}
	
	@GetMapping("/entries/{id}")
	public Entry findEntry(@PathVariable("id") int id) {
		Entry entry = entryService.findById(id);
		return entry;
	}
	
	@DeleteMapping(("/entries/{id}"))
	public void deleteEntry(@PathVariable("id") int id) {
		Entry entry = entryService.findById(id);
		entryService.deleteEntry(entry);
	}
}
