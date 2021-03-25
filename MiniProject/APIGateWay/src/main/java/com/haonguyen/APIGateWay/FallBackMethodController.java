package com.haonguyen.APIGateWay;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/importServiceFallBack")
    public ResponseEntity importServiceFallBackMethod(){
        return ResponseEntity.ok().body("No response ImportService, please try again later!");
    }

    @GetMapping("/commodityServiceFallBack")
    public ResponseEntity commodityServiceFallBackMethod(){
        return ResponseEntity.ok().body("No response CommodityService, please try again later!");
    }

    @GetMapping("/exportServiceFallBack")
    public ResponseEntity exportServiceFallBackMethod(){
        return ResponseEntity.ok().body("No response ExportService, please try again later!");
    }

    @GetMapping("/statementServiceFallBack")
    public ResponseEntity statementServiceFallBackMethod(){
        return ResponseEntity.ok().body("No response StatementService, please try again later!");
    }

}
