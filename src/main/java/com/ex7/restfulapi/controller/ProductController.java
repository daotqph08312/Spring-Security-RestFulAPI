package com.ex7.restfulapi.controller;

import com.ex7.restfulapi.model.ProductEntity;
import com.ex7.restfulapi.model.ProductEntity;
import com.ex7.restfulapi.service.implement.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private
    ProductServiceImp productServiceImp;
    @GetMapping("")
    public ResponseEntity<List<ProductEntity>> getAll(){
        List<ProductEntity> list =productServiceImp.getAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable("id") Long id){
        ProductEntity productEntity=  productServiceImp.getById(id);
        if(productEntity != null){
            return new ResponseEntity<>(productEntity,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search/{nameProduct}")
    public ResponseEntity<List<ProductEntity>> SearchProductByName(@PathVariable("nameProduct") String nameproduct){
        List<ProductEntity> list=  productServiceImp.searchProduct(nameproduct);
        if(list.isEmpty()){
            return  new ResponseEntity<>(list,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
    @PostMapping("/add")
    public ProductEntity addWareHourse(@RequestBody ProductEntity ProductEntity){
        return productServiceImp.create(ProductEntity);
    }
    @PutMapping("/update/{id}")
    public ProductEntity updateWareHouse(@RequestBody ProductEntity ProductEntity, @PathVariable("id")Long id){
        return productServiceImp.update(ProductEntity,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteWareHouse(@PathVariable("id") Long id){
        return productServiceImp.delete(id);
    }
}
