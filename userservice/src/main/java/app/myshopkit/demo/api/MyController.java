package app.myshopkit.demo.api;

import app.myshopkit.demo.dto.UserDTO;
import app.myshopkit.demo.repository.UserRepository;
import app.myshopkit.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "get")
    public ResponseEntity<Object> getData() {
        System.out.println(userService.findAll());
        return ResponseEntity.ok(userService.findAll().toString());
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            List<String> message = new ArrayList<>();

            for (FieldError e : errors) {
                message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
            }

            return ResponseEntity.ok(message);
        }

//        System.out.println(userDTO.getFirstName());
        return ResponseEntity.ok(userService.insert(userDTO));

    }
}
