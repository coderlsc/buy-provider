package com.qdu.buy.impl;
import com.qdu.buy.dao.UserDao;
import com.qdu.buy.domain.po.User;
import com.qdu.buy.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Descripition: 用户服务实现
 * @Author: xiepf
 * @Date: 2017/11/14 11:57
 */
@Slf4j
@Service("userService")
public class UserServiceImpl  implements UserService {

    @Resource
    private UserDao userDao;




    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        List<User> users = userDao.queryUserByUserName(userName);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

//    /**
//     * 添加用户
//     *
//     * @param userDto
//     */
//    @Transactional
//    @Override
//    public User addUser(UserDto userDto) {
//        //获取当前用户
//        LoginUserDto loginUserDto = this.getCurrentUser();
//        //dto转换po
//        User user = new User();
//        BeanUtils.copyProperties(userDto, user);
//        //生成密码 盐
//        String salt = RandomStringUtils.random(5, true, true);
//        //设置其他数据
//        user.setCityId(Long.parseLong(userDto.getCityId()));
//        user.setCreateUser(loginUserDto.getUserId().toString());
//        user.setSalt(salt);
//        user.setPassword(DigestUtils.md5Hex(salt + DigestUtils.md5Hex(Constants.DEFAULT_PWD)));
//        user.setStatus(Constants.Sys.UserStatusEnum.Enabled.getValue());
//        user.setFirstLogin(Constants.Sys.TrueFalseEnum.True.getValue());
//        user.setCreateTime(new Date());
//        user.setUpdateUser(loginUserDto.getUserName().toString());
//        user.setUpdateTime(new Date());
//        userDao.insertUser(user);
//        return userDao.queryUserById(user.getId()).get(0);
//    }


//
//    /**
//     * 修改用户信息
//     *
//     * @param userDto
//     */
//    @Transactional
//    @Override
//    public void modifyUser(ModifyUserDto userDto) {
//        //获取当前用户
//        LoginUserDto loginUserDto = this.getCurrentUser();
//        //dto转换po
//        User user = new User();
//        BeanUtils.copyProperties(userDto, user, "id");
//        user.setId(Long.parseLong(userDto.getId()));
//        user.setCityId(Long.parseLong(userDto.getCityId()));
//        //设置其他数据
//        user.setUpdateUser(loginUserDto.getUserName().toString());
//        user.setUpdateTime(new Date());
//        userDao.updateUserInfo(user);
//    }







    /**
     * 验证用户
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User verifyUser(String userName, String password) {
        List<User> users = userDao.queryUserByUserNameAndPwd(userName, password);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
