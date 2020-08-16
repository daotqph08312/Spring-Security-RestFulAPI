package com.ex7.restfulapi.controller;

import com.ex7.restfulapi.model.UserDTOToken;
import com.ex7.restfulapi.model.UsersEntity;
import com.ex7.restfulapi.service.implement.UsersService;

import com.ex7.restfulapi.service.security.JwtService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired  private    UsersService usersService;
    @Autowired private JwtService jwtService;
    @GetMapping("/listUser")
    public List<UsersEntity> getAll(){
        return usersService.getAll();
    }
    @GetMapping("/{id}")
    public UsersEntity getById(@PathVariable("id") String id)  {
        return usersService.getById(id);
    }
    @PostMapping("/add")
    public UsersEntity addWareHourse(@RequestBody UsersEntity UsersEntity){
        return usersService.create(UsersEntity);
    }
    @PutMapping("/update/{id}")
    public UsersEntity updateWareHouse(@RequestBody UsersEntity UsersEntity, @PathVariable("id")String id){
        return usersService.update(UsersEntity,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteWareHouse(@PathVariable("id") Long id){
        return usersService.delete(id);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTOToken> login(@RequestBody UsersEntity usersEntity){
    String result = "";
        UserDTOToken userDTOToken = new UserDTOToken();
        try {
            if(usersService.Login(usersEntity)){
                usersEntity = usersService.getById(usersEntity.getUserName());
                userDTOToken.setUserName(usersEntity.getUserName());
                userDTOToken.setUserPassword(usersEntity.getUserPassword());
                userDTOToken.setUserRole(usersEntity.getUserRoles());
                result = jwtService.generateTokenLogin(usersEntity.getUserName());
                userDTOToken.setToken(result);
                return new ResponseEntity<>(userDTOToken, HttpStatus.OK);
            }
        }catch (Exception ex){
        }
        return new ResponseEntity<>(userDTOToken, HttpStatus.NOT_FOUND);
    }
}
