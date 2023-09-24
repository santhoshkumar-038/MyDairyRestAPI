package com.santhosh.springboot.mydairyapp.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santhosh.springboot.mydairyapp.restapi.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
	public List<Entry> findByUserid(long id);
}
