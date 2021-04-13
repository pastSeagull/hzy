package com.leaf.details;


import com.leaf.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * create          2019-12-02 18:39
 * 登陆成功后返回用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResultDetails {
    private Integer status;
    private ResultDetails resultDetails;
    private User user;
}
