package com.qdu.buy.user;


import com.qdu.buy.domain.UserQuery;
import com.qdu.buy.domain.dto.ModifyUserDto;
import com.qdu.buy.domain.dto.ModifyUserStatusDto;
import com.qdu.buy.domain.dto.UserDto;
import com.qdu.buy.domain.po.User;
import com.qdu.buy.domain.vo.UserVo;
import com.qdu.buy.lang.Page;

import java.util.List;
import java.util.Map;

/**
 * @Descripition: 用户服务接口
 * @Author: xiepf
 * @Date: 2017/11/14 10:51
 */
public interface UserService {


    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
     User getUserByUserName(String userName) ;

    /**
     * 核实用户
     * @param userName
     * @param password
     * @return
     */
    User verifyUser(String userName, String password);


}
