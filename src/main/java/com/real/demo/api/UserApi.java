package com.real.demo.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.real.demo.model.po.User;
import com.real.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName UserApi
 * @Description: TODO
 * @Author Smile
 * @Date 2021/5/10
 * @Version V1.0
 **/
@Slf4j
@RestController
@Api(value = "用户api")
@RequestMapping(value = "/user")
public class UserApi {
    @Resource
    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public User getInfo(String userId) {
        return userService.getById(userId);
    }

    @ApiOperation(value = "测试自定义sql 语句")
    @RequestMapping(value = "/gainUserByName", method = RequestMethod.GET)
    public User gainUserByName(@RequestParam("name") String name) {
        return userService.getUserByName(name);
    }

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public List<User> getList() {
        return userService.list();
    }

    @ApiOperation(value = "分页获取用户信息")
    @RequestMapping(value = "/getInfoListPage", method = RequestMethod.GET)
    public IPage<User> getInfoListPage() {
        //需要在Config配置类中配置分页插件
        IPage<User> page = new Page<>();
        page.setCurrent(5); //当前页
        page.setSize(1);    //每页条数
        page = userService.page(page);
        return page;
    }

    @ApiOperation(value = "根据指定字段获取用户列表")
    @RequestMapping(value = "/getListMap", method = RequestMethod.GET)
    public Collection<User> getListMap() {
        Map<String, Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age", 20);
        return userService.listByMap(map);
    }


    @ApiOperation(value = "新增用户信息")
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public void saveInfo() {
        User user = new User();
        user.setName("小龙");
        userService.save(user);
    }

    @ApiOperation(value = "批量新增用户信息")
    @RequestMapping(value = "/saveInfoList", method = RequestMethod.POST)
    public void saveInfoList() {
        //创建对象
        User sans = new User();
        sans.setName("Sans");
        User papyrus = new User();
        papyrus.setName("papyrus");
        //批量保存
        List<User> list = new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        userService.saveBatch(list);
    }


    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
    public void updateInfo() {
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        User user = new User();
        user.setId(1L);
        user.setName("19");
        userService.updateById(user);
    }

    @ApiOperation(value = "修改或者新增用户信息")
    @RequestMapping(value = "/saveOrUpdateInfo", method = RequestMethod.PUT)
    public void saveOrUpdate() {
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        User User = new User();
        User.setId(1L);
        User.setAge(20);
        userService.saveOrUpdate(User);
    }

    @ApiOperation(value = "删除用户信息")
    @RequestMapping(value = "/deleteInfo", method = RequestMethod.DELETE)
    public void deleteInfo(String userId) {
        userService.removeById(userId);
    }

    @ApiOperation(value = "批量删除用户信息")
    @RequestMapping(value = "/deleteInfoList", method = RequestMethod.DELETE)
    public void deleteInfoList() {
        List<String> userIdList = new ArrayList<>();
        userIdList.add("12");
        userIdList.add("13");
        userService.removeByIds(userIdList);
    }

    @ApiOperation(value = "通过部分数据删除用户信息")
    @RequestMapping(value = "/deleteInfoMap", method = RequestMethod.DELETE)
    public void deleteInfoMap() {
        //kay是字段名 value是字段值
        Map<String, Object> map = new HashMap<>();
        map.put("skill", "删除");
        map.put("fraction", 10L);
        userService.removeByMap(map);
    }

}
