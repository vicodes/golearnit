package com.golearnit.app.common.controller;

import com.golearnit.data.common.builder.GenericResponseBuilder;
import com.golearnit.data.common.dto.GenericResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CommonController {

    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<GenericResponseDto> serviceBaseUrl() {
        return GenericResponseBuilder.createSuccessResponse("golearnIt Service");

    }

}
