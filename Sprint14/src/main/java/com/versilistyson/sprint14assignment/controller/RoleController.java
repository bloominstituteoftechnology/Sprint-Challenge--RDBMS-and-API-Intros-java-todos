package com.versilistyson.sprint14assignment.controller;

import com.versilistyson.sprint14assignment.model.Role;
import com.versilistyson.sprint14assignment.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping(
            consumes = "application/json"
    )
    public ResponseEntity<?> addRole(@Valid @RequestBody Role newRole) {
        newRole = roleService.saveRole(newRole);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRoleURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newRole.getId())
                .toUri();

        responseHeaders.setLocation(newRoleURI);

        return new ResponseEntity<>(
                null,
                responseHeaders,
                HttpStatus.CREATED
        );

    }

}
