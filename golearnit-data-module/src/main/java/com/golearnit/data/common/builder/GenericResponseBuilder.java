package com.golearnit.data.common.builder;


import com.golearnit.data.common.dto.GenericResponseDto;
import com.golearnit.data.common.dto.Meta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericResponseBuilder {
    private static Logger logger = LogManager.getLogger(GenericResponseBuilder.class);

    public static ResponseEntity<GenericResponseDto> createSuccessResponse(Object response) {
        Meta meta = new Meta();
        meta.setResponseCode(200);
        meta.setStatus("SUCCESS");
        return new ResponseEntity<>(new GenericResponseDto(meta, response), HttpStatus.OK);
    }

    public static ResponseEntity<GenericResponseDto> createNoDataFoundResponse(Object response) {
        Meta meta = new Meta();
        meta.setMessage("No data found!!");
        meta.setResponseCode(200);
        meta.setStatus("SUCCESS");
        return new ResponseEntity<>(new GenericResponseDto(meta, response), HttpStatus.OK);
    }

    public static ResponseEntity<GenericResponseDto> createErrorResponse(Object response) {
        Meta meta = new Meta();
        meta.setMessage("Error while processing request.");
        meta.setResponseCode(200);
        meta.setStatus("FAILED");
        return new ResponseEntity<>(new GenericResponseDto(meta, response), HttpStatus.OK);
    }

    public static ResponseEntity createBadRequestResponse(String message) {
        Meta meta = new Meta();
        meta.setMessage(message);
        meta.setResponseCode(400);
        meta.setStatus("FAILED");
        return new ResponseEntity<>(new GenericResponseDto(meta, null), HttpStatus.BAD_REQUEST);
    }

}
