package com.App1.App1.controll;

import com.App1.App1.model.dto.FresherDTO;
import com.App1.App1.model.response.ResponseObject;
import com.App1.App1.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/fresher")
public class FresherController {
    @Autowired
    FresherService fresherService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all fresher successfully",
                        Collections.singletonList(fresherService.getFresher()))
        );
    }
    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseObject> addFresher(@RequestBody FresherDTO fresherDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert fresher successfully",
                        fresherService.addFresher(fresherDTO))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editFresher(@RequestBody FresherDTO fresherDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change or insert fresher successfully",
                        fresherService.editFresher(fresherDTO))
        );
    }
    @DeleteMapping("/deleteFresherId")
    public ResponseEntity<ResponseObject> delete(@PathVariable String fresherId) {
        fresherService.deleteFresher(fresherId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Delete fresher successfully","")
        );
    }
    @GetMapping("/transcript")
    public ResponseEntity<ResponseObject> getTranscript(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get transcript successfully",
                        Collections.singletonList(fresherService.getTranscript()))
        );
    }
}
