package com.traffic.police.api;

import com.traffic.police.models.ApplicationUsersEntity;
import com.traffic.police.models.CrimeDescriptionEntity;
import com.traffic.police.repos.CrimeRepo;
import com.traffic.police.services.CrimeService;
import com.traffic.police.services.UsersService;
import com.traffic.police.utils.GeneralRequest;
import com.traffic.police.utils.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/")
public class GeneralApi {
    @Autowired
    UsersService usersService;
    @Autowired
    CrimeService crimeService;
    //    @Autowired
//    OffenceService offenceService;
    @Autowired
    CrimeRepo crimeRepo;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})

    public ResponseEntity login(@RequestBody UserRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(usersService.loginUser(loginRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/addUser", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})

    public ResponseEntity createUsers(@RequestBody GeneralRequest<ApplicationUsersEntity> generalRequest, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(usersService.createUser(generalRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/getAll", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})

    public ResponseEntity getAllUsers(@RequestBody GeneralRequest<ApplicationUsersEntity> generalRequest, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(usersService.getAllUsers(generalRequest), HttpStatus.OK);
    }


    @RequestMapping(value = "/offences/getUserOffence", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})

    public ResponseEntity getOffenceById(@RequestBody GeneralRequest<CrimeDescriptionEntity> generalRequest, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(crimeService.getUserOffences(generalRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/offences/getAll", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})

    public ResponseEntity getAll(@RequestBody GeneralRequest<CrimeDescriptionEntity> generalRequest, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(crimeService.fetchAllCases(generalRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/offences/createOffence", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})

    public ResponseEntity createCrime(@RequestBody GeneralRequest<CrimeDescriptionEntity> generalRequest, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(crimeService.createCrime(generalRequest), HttpStatus.OK);
    }


}