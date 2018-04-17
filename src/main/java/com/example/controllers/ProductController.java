package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Product;
import com.example.repositories.ProductRepository;

@RestController    // This means that this class is a Controller
@RequestMapping("/products") // This means URL's start with /demo (after Application path)
public class ProductController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ProductRepository productRepository;

    @GetMapping(path="/all")
    //@RequestMapping(method=GET)
    public @ResponseBody Iterable<Product> GetAllProducts() {
        // This returns a JSON or XML with the users
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Product> CreateProduct(@RequestBody Product resource) {
        if (resource.getName().isEmpty() ){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Product>(productRepository.save(resource), HttpStatus.CREATED);
        }
    }
/*
    @GetMapping(path="/")
    @RequestMapping(method=POST)
    public @ResponseBody String addNewProduct (@RequestParam String name, @RequestParam Integer price, @RequestParam Date expirationDate, @RequestParam Integer category) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Product product = new Product();
        product.setName(name);
        product.setCost(price);
        product.setExpirationDate(expirationDate);
        product.setCategory(category);
        productRepository.save(product);
        return "Saved";
    }
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product FindOne(@PathVariable("id") Integer id){

        return this.productRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Product> EditProduct(@RequestBody Product resource, @PathVariable("id") Integer id){
        if (resource.getName().isEmpty() ){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }else{
            resource.setId(id);
            return new ResponseEntity<Product>(productRepository.save(resource), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Product DeleteProduct(@PathVariable("id") Integer id){
        Product p = productRepository.findById(id);
        productRepository.delete(p);
        return p;
    }




}
