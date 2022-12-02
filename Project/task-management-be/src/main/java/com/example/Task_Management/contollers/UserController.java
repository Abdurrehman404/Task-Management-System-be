package com.example.Task_Management.contollers;

import com.example.Task_Management.Utilities.EmailSenderUtil;
import com.example.Task_Management.Utilities.JwtTokenUtil;
import com.example.Task_Management.Utilities.RandomPasswordUtil;
import com.example.Task_Management.dto.request.AuthenticateUserReq;
import com.example.Task_Management.dto.response.JwtResponse;
import com.example.Task_Management.dto.response.UnifiedRes;
import com.example.Task_Management.entities.*;
import com.example.Task_Management.mappers.dtoToModel.DTOMappers;
import com.example.Task_Management.mappers.modelToDto.ModelMappers;
import com.example.Task_Management.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


@CrossOrigin( origins = {"http://localhost:3000"}) //  originPatterns = "http://*", allowCredentials = "false",// (origins = "http://localhost:3000", methods = {RequestMethod.GET} ,allowedHeaders = "*")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmailSenderUtil sender;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    RandomPasswordUtil rand;
    @Autowired
    ModelMappers modelToDtoMapper;
    @Autowired
    DTOMappers dtoToModelMapper;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<UnifiedRes> getAllUsers(HttpServletRequest request) { //
        return new ResponseEntity<UnifiedRes>( new UnifiedRes("",
                200,
                modelToDtoMapper.userListToAllUsersRes(userService.getUsers()
                        .stream()
                        .filter(user-> Objects.equals(user.getType(), "user"))
                        .collect(Collectors.toList())))
                ,HttpStatus.OK); // gets all users except Admin user
    }
    @RequestMapping(value = "/users/authenticate",method = RequestMethod.POST)
    public ResponseEntity<UnifiedRes> authenticateUser(@RequestBody AuthenticateUserReq usr){
        Optional<User> user  = userService.AuthenticateUser(usr.getUserName(),usr.getPassword()); // authenticate user by id and password

        if(user.isPresent()) {

            Claims claims = new DefaultClaims();
            claims.put("userName", user.get().getUserName());
            claims.put("type", user.get().getType());

            String token = jwtTokenUtil.GenerateToken(claims,user.get().getName());
            JwtResponse response = new JwtResponse(token, JwtTokenUtil.JWT_TOKEN_VALIDITY,user);
            return new ResponseEntity<UnifiedRes>(new UnifiedRes("User authentication successfully",200,response),HttpStatus.OK );
        }
        return new ResponseEntity<UnifiedRes>(new UnifiedRes("User not found",200,new JwtResponse()),HttpStatus.OK );
    }
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UnifiedRes> getUser(@PathVariable String userName) {
        Optional usr = userService.getUser(userName);
        if(usr.isPresent()) {
            return new ResponseEntity<UnifiedRes>(new UnifiedRes("User found", 200,usr.get()),HttpStatus.OK);  // gets single user
        }
        else{
            return new ResponseEntity<UnifiedRes>(new UnifiedRes("User not found", 404,null),HttpStatus.OK);  // User not found
        }
    }
    @RequestMapping(value = "/users/authenticateTemp",method = RequestMethod.POST)
    public ResponseEntity<UnifiedRes> authenticateTempUser(@RequestBody AuthenticateUserReq usr){
        Optional<UserAccess> userAccess  = userService.AuthenticateTempUser(usr.getUserName(),usr.getPassword()); // authenticate user by id and password

        return userAccess.map(access -> new ResponseEntity<>(new UnifiedRes("Temporary authentication successfull",
                200, userService.getUser(access.getUserName()).get()), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new UnifiedRes("User not found",
                200, null), HttpStatus.OK));
    }
    @RequestMapping(value = "/users/addUser",method = RequestMethod.POST)
    public ResponseEntity<UnifiedRes> addUser(@RequestBody User user){
        return new ResponseEntity<UnifiedRes>(new UnifiedRes("",200,userService.addUser(user)),HttpStatus.OK);
    }
    @RequestMapping(value ="/users/updateUser",method = RequestMethod.POST)
    public ResponseEntity<UnifiedRes> updateUser(@RequestBody User user){
        return new ResponseEntity<UnifiedRes>(new UnifiedRes("",200,userService.updateUser(user)),HttpStatus.OK); // update single user
    }
    @RequestMapping(value ="/users/deleteUser/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
    @RequestMapping(value = "/user/reset/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UnifiedRes> resetPassword(@PathVariable String userName) {
        Optional<User> user = userService.getUser(userName); // CHECK for non existent user
        if(user.isPresent()) {
            String pass = rand.generateRandomPassword(10);
            userService.resetPassword(userName, pass);

            Thread mailSender = new Thread(()->sender.sendMail(user.get().getEmail(),pass));
            mailSender.start();

            return new ResponseEntity<UnifiedRes>(new UnifiedRes("Password reset successfully",200,true),HttpStatus.OK);
        }else{
            return new ResponseEntity<UnifiedRes>(new UnifiedRes("User not found",200,false),HttpStatus.OK);
        }
    }
    @RequestMapping(value ="/users/validateToken",method = RequestMethod.POST)
    public ResponseEntity<UnifiedRes> validateToken(@RequestBody JwtResponse token) {
        return new ResponseEntity<UnifiedRes>(new UnifiedRes("",
                200,
                jwtTokenUtil.isValidToken(token.getToken()) && !jwtTokenUtil.isTokenExpired(token.getToken())),
                HttpStatus.OK);
    }
}
