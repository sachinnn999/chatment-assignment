package com.sachinnn.facts.controller;

import com.sachinnn.facts.helper.JwtTokenUtil;
import com.sachinnn.facts.model.dao.AnimalFactsLog;
import com.sachinnn.facts.model.dto.AuthRequest;
import com.sachinnn.facts.service.AnimalFactLogService;
import com.sachinnn.facts.service.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <h1>BaseController</h1>
 * @author sachinnn
 * @since 16.06.2022
 */
@RestController
@RequestMapping(value = "/")
public class BaseController {

    private final AnimalFactLogService animalFactLogService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public BaseController(AnimalFactLogService animalFactLogService, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.animalFactLogService = animalFactLogService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    /**
     *
     * @return String
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "<h1>hello facts</h1>";
    }

    /**
     * <h3>fetching jwt token</h3>
     * @param request AuthRequest
     * @return jwt
     * @throws Exception
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }

    /**
     * <h3>returning the /facts/animal api request log</h3>
     * @return List<AnimalFactsLog>
     */
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public List<AnimalFactsLog> getLog( ){
        System.out.println();
        return animalFactLogService.getAll();
    }
}
