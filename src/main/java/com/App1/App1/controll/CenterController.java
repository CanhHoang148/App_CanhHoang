package com.App1.App1.controll;

import com.App1.App1.model.entity.FreCen;
import com.App1.App1.model.response.ResponseObject;
import com.App1.App1.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/center") //http://localhost:8088/center
public class CenterController {
    @Autowired
    CenterService centerService;
    @GetMapping(path = "/getAll")
    public ResponseEntity<ResponseObject> getAllCenter() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all center successfully",
                        Collections.singletonList(centerService.getAllCenter()))
        );
    }
    @PostMapping(path = "/addFresher/centerCode")
    public FreCen addFresherToCenter(@PathVariable String centerCode,
                                     @RequestParam String fresherId) {
        return centerService.addFresherToCenter(centerCode,fresherId);
    }
    @GetMapping(path = "/getFresher/centerCode")
    public ResponseEntity<ResponseObject> getAllFresherOfCenter(@PathVariable String centerCode) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Get All fresher of center " + centerCode,
                        Collections.singletonList(centerService.getListFresherOfCenter(centerCode)))
        );
    }

}