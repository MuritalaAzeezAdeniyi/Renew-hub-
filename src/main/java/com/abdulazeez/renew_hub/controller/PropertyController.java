package com.abdulazeez.renew_hub.controller;

import com.abdulazeez.renew_hub.dto.request.UploadPropertyRequest;
import com.abdulazeez.renew_hub.dto.response.ApiResponse;
import com.abdulazeez.renew_hub.model.Property;
import com.abdulazeez.renew_hub.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/upload")
    ResponseEntity <?> uploadProperty (UploadPropertyRequest request){
        try{
            Property property = propertyService.uploadProperty(request);
            return new ResponseEntity<>(new ApiResponse(true,property), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
