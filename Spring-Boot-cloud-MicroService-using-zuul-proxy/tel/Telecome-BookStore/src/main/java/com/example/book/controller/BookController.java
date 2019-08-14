package com.example.book.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	public List<Book> booklist = Arrays.asList(new Book(1,"Engineering Maths","Veerarajan"),
			new Book(2,"Qunat Apttitude","Rs aggarwal"));
	
	@GetMapping
	public ResponseEntity<List<Book>> findAllBooks()
	{
		return ResponseEntity.ok(booklist);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id)
	{
		Book b =booklist.stream().filter(d->d.getId() == id).findFirst().orElse(null);
		
		ResponseEntity<Book> resp=null;
		
		if(b!=null)
		{
			resp=new ResponseEntity<Book>(b,HttpStatus.OK);
		}
		else
		{
			resp=new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}	
		
		
		return resp;
	}
	
}
