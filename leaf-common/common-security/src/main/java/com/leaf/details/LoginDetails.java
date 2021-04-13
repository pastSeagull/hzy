package com.leaf.details;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDetails {
    private Boolean rememberMe;
    private String verifyCode;

}
