package com.pack.dto;

/*import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
*/
//@ApiModel(description="Book model class")
public class BookDTO {

    //@ApiModelProperty(notes="These is book id,it is id property")
	private Integer bookId;
   // @ApiModelProperty(notes="This property is Book name")
	private String name;
   // @ApiModelProperty(notes="This property is Book price")
	private Double price;
	public BookDTO() {
		super();
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", name=" + name + ", price=" + price + "]";
	}

}
