package com.haonguyen.APIGateWay;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/importServiceFallBack")
    public ResponseEntity importServiceFallBackMethod(){
        return ResponseEntity.ok().body("404 error pls try again");
    }


}
