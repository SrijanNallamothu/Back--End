package com.example.demo.authentication;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }
    public AuthenticationController(AuthenticationService authenticationService)
    {
        this.authenticationService = authenticationService;
    }
    record send_otp_body(String mobile_number){}
    @CrossOrigin
    @PostMapping("/send_otp")
    public String send_otp(@RequestBody send_otp_body send_otp_rec)
    {
        System.out.println("Hello?");
        return "approved";//authenticationService.send_otp(send_otp_rec.mobile_number);
    }

    record verify_otp_body(String mobile_number,String otp){}
    @CrossOrigin
    @PostMapping("/verify_otp")
    public String verify_otp(@RequestBody verify_otp_body verify_otp_rec)
    {
        return "approved";//authenticationService.verify_otp(verify_otp_rec.otp,verify_otp_rec.mobile_number);
    }
}