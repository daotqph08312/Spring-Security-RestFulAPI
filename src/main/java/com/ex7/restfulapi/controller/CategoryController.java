package com.ex7.restfulapi.controller;

import com.ex7.restfulapi.model.CategoryEntity;
import com.ex7.restfulapi.model.CategoryEntity;
import com.ex7.restfulapi.service.implement.CategoryServiceImp;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private
    CategoryServiceImp categoryServiceImp;
    @GetMapping("")
    public ResponseEntity<List<CategoryEntity>> getAll(){
        List<CategoryEntity> list= categoryServiceImp.getAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getById(@PathVariable("id") Long id){
        CategoryEntity categoryEntity=  categoryServiceImp.getById(id);
       if(categoryEntity != null){
           return  new ResponseEntity<>(categoryEntity,HttpStatus.OK);
       }
       return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public CategoryEntity addCategory(@RequestBody  @Valid CategoryEntity CategoryEntity){
        return categoryServiceImp.create(CategoryEntity);
    }
    @PutMapping("/update/{id}")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity CategoryEntity, @PathVariable("id")Long id){
        return categoryServiceImp.update(CategoryEntity,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        return categoryServiceImp.delete(id);
    }
}
