package com.pagination.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pagination.entity.Books;
import com.pagination.repository.IBookRepository;

@Service
@Transactional
public class BookService {
		@Autowired
		private IBookRepository bookRepo;
		
		public Books saveBook(Books temp) {
			Books newBook = new Books();
			String title = temp.getTitle();
			String author = temp.getAuthor();
			Integer year = temp.getYear();
			Double price = temp.getPrice();
			if(!(title == null || author == null || year == null || price == null)) {
				newBook.setTitle(title);
				newBook.setAuthor(author);
				newBook.setYear(year);
				newBook.setPrice(price);
				return bookRepo.save(newBook);
			}
			return null;
		}
		
		public Books findById(Long id) {
			if(bookRepo.existsById(id)) {
				return bookRepo.findById(id).get();
			}
			return null;
		}
		
		public Page<Books> findAllBooks(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("title")));
	        return bookRepo.findAll(pageable);
	    }
		
		public Books updateBook(Long id, Books temp){
			if(bookRepo.existsById(id)) {
				Books updateBook = bookRepo.findById(id).get();
				updateBook.setTitle(temp.getTitle());
				updateBook.setAuthor(temp.getAuthor());
				updateBook.setYear(temp.getYear());
				updateBook.setPrice(temp.getPrice());
				return bookRepo.save(updateBook);
			}
			return null;
		}
		
	    public String deleteById(Long id) {
	        if (bookRepo.existsById(id)) {
	            bookRepo.deleteById(id);
	            return "Deleted";
	        } else {
	            return "Book with the given id is not found";
	        }
	    }
	    

}
