package com.ex7.restfulapi.controller;

import com.ex7.restfulapi.model.WareHourseEntity;
import com.ex7.restfulapi.service.implement.WareHouseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired private
    WareHouseServiceImp wareHouseServiceImp;
    @GetMapping("")
    public List<WareHourseEntity> getAll(){
        return wareHouseServiceImp.getAll();
    }
    @GetMapping("/{id}")
    public WareHourseEntity getById(@PathVariable("id") Long id){
        return wareHouseServiceImp.getById(id);
    }
    @PostMapping("/add")
    public WareHourseEntity addWareHourse(@RequestBody WareHourseEntity wareHourseEntity){
        return wareHouseServiceImp.create(wareHourseEntity);
    }
    @PutMapping("/update/{id}")
    public WareHourseEntity updateWareHouse(@RequestBody WareHourseEntity wareHourseEntity, @PathVariable("id")Long id){
        return wareHouseServiceImp.update(wareHourseEntity,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteWareHouse(@PathVariable("id") Long id){
        return wareHouseServiceImp.delete(id);
    }
}
