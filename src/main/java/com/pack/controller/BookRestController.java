package com.pack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.BookDTO;
import com.pack.entity.Book;
import com.pack.exception.BookDoesNotExistException;
import com.pack.repository.BookRepository;

/*import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
*/
@RestController
public class BookRestController {
//git revert check

//branch alerts

//now merge only
//master is forward than my feature branch	

//1st commit
//2nd commit
//3rd commit
	
//4th commit
//5th commit
//6th commit	

	@Autowired
	BookRepository repository;

	//@ApiOperation(value="Get All Books from Database")
	/*@ApiResponses({
		@ApiResponse(code=200,message="All Books are returned"),
		@ApiResponse(code=404,message="Check the end point url"),
		@ApiResponse(code=401,message="Authentication Failed")
	})*/
	@GetMapping(value="/books/all" ,produces="application/json")
	public ResponseEntity<List<BookDTO>> getAllBooks()
	{
		List<Book> bookList=repository.findAll();
		List<BookDTO> dtoList=new ArrayList();

		for(Book book:bookList)
		{
			BookDTO dto=new BookDTO();
			BeanUtils.copyProperties(book,dto);
			dtoList.add(dto);
		}
		return new ResponseEntity<List<BookDTO>>(dtoList,HttpStatus.OK);  
	}

	//@ApiOperation(value="get one books from database")
	@GetMapping(value="/book/{bookId}",produces= {"application/json","text/plain"})
	public List getBookById(@PathVariable Integer bookId)throws BookDoesNotExistException
	{
		List list=new ArrayList();
		boolean flag= repository.existsById(bookId);
		if(flag==true)
		{
			Optional<Book>opt=repository.findById(bookId);
			Book book=opt.get();
			BookDTO dto=new BookDTO();
			BeanUtils.copyProperties(book,dto);
			list.add(dto);
			return list;
		}
		else
		{
			System.out.println("from Bookexception");
			throw new BookDoesNotExistException();
		}
	}

	//@ApiOperation(value="To add one book to database")
	@PostMapping(value="/book/create",produces="text/plain",consumes="application/json")
	public String createBook(@RequestBody BookDTO dto)
	{
		Book book=new Book();
		BeanUtils.copyProperties(dto,book);
		boolean flag=repository.existsById(dto.getBookId());
		if(flag==true)
		{
			return "Sorry! Book aleady exist with this Id in DB";
		}
		else
		{
			repository.save(book);
			return "Book successfully added to Database";
		}
	}

	//@ApiOperation(value="To update one book on database")
	@PutMapping(value="/book/update",produces="text/palin",consumes="application/json")
	public String updateBook(@RequestBody BookDTO dto)
	{

		boolean flag=repository.existsById(dto.getBookId());
		if(flag==true)
		{
			Book book=new Book();
			BeanUtils.copyProperties(dto,book);
			repository.saveAndFlush(book);
			return "book updated successfully in data base";
		}else
		{
			return "book doesnot exist in database";
		}

	}

	//@ApiOperation(value="To Delete one book from database")
	@DeleteMapping(value="/book/delete",produces="text/plain")
	public String deleteBookById(@RequestParam Integer bookId)
	{
		boolean flag=repository.existsById(bookId);
		if(flag==true)
		{
			repository.deleteById(bookId);

			return "book deleted from database Successfully";
		}
		else
		{
			return "sorry! Book with this id doesnot exist in database";
		}

	}
	
	//master 1st commit
	//master 2nd commit
	
}






