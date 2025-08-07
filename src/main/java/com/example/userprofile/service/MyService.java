package com.example.userprofile.service;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userprofile.dto.ProductDTO;
import com.example.userprofile.mapper.ProductMapper;
import com.example.userprofile.model.Category;
import com.example.userprofile.model.Product;
import com.example.userprofile.model.UserModel;
import com.example.userprofile.repository.CategoryRepository;
import com.example.userprofile.repository.ProductRepository;
import com.example.userprofile.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class MyService {
	
	@Autowired
	private final ProductRepository productrepository;
	
	@Autowired
	private final UserRepository userrepository;
	
	@Autowired
	private final CategoryRepository categoryrepository;
	
	@Autowired
	private final ProductMapper mapper;
	
	public MyService(ProductRepository productrepository, UserRepository userrepository,
			CategoryRepository categoryrepository, ProductMapper mapper) {
		super();
		this.productrepository = productrepository;
		this.userrepository = userrepository;
		this.categoryrepository = categoryrepository;
		this.mapper = mapper;
	}

	public String greet(String name) {
        return "Hello, " + name;
    }

    public void throwError() {
        throw new RuntimeException("Something went wrong!");
    }
    
    public UserModel addUser(UserModel user) {
    	return userrepository.save(user);
    }
//    public Product addProduct(Product product) {
//
//
//        // Check if category exists
//    	String categoryName = product.getCategory().getCategoryName();
//    	Category c1 = categoryrepository.findByCategoryName(categoryName);
//
//    	if (c1 == null) {
//    	    c1 = new Category();
//    	    c1.setCategoryName(categoryName);
//    	    c1 = categoryrepository.save(c1);
//    	}
//
//    	
//    	//add product
//    	Product p=new Product();
//    	p.setName(product.getName());
//    	p.setDescription(product.getDescription());
//    	p.setPrice(product.getPrice());
//    	p.setQuantity(product.getQuantity());
//    	p.setCategory(c1);
//    	//categoryrepository.save(c1);
//    	System.out.println(product);
//    	//return null;
//    	return productrepository.save(p);
//
//    }
    
    public List<Product> showProduct(){
    	return productrepository.findAll();
    }
    
    //add product mapper
  @Transactional 
  public ProductDTO addProduct(ProductDTO product) {

      // Check if category exists
  	String categoryName = product.getCategoryName();
  	Category c1 = categoryrepository.findByCategoryName(categoryName);

  	if (c1 == null) {
  	    c1 = new Category();
  	    c1.setCategoryName(categoryName);
  	    c1 = categoryrepository.save(c1);
  	}	
  	//add product
  	Product m1=mapper.toEntity(product);  	
  	 m1.setCategory(c1);
  	 System.out.println(product);
  	 Product p=productrepository.save(m1);
  	 return mapper.toDto(p);

  }
  
  //add category
  public Category addCategory(Category category) {
	  Category existCategory=categoryrepository.findByCategoryName(category.getCategoryName());
	  if(existCategory!=null) {
		throw new RuntimeException("category exist");
	  }
	 
	  return categoryrepository.save(category);
	
}

  public List<ProductDTO> searchproduct(String search) {
	    List<Product> allProduct=productrepository.findAll();
	    List<Product> p= allProduct.stream()
	    			.filter(i->i.getName().startsWith(search))
	    			.toList();
	    
	   return mapper.toDtoList(p);
	    
	}

}









