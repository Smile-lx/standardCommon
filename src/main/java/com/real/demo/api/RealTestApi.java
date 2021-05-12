package com.real.demo.api;

import com.real.demo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RealTestApi
 * @Description: TODO
 * @Author Smile
 * @Date 2021/4/7
 * @Version V1.0
 **/
@Api(value = "xpl 测试专用")
@RestController
@RequestMapping(value = "/real")
@Slf4j
public class RealTestApi {
    @Resource
    UserMapper userMapper;

    /**
     * 查询所有的用户
     * api :localhost:8099/users
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户列表，目前没有分页")
    public String findAll() {
        return "new ResponseEntity<>(userService.listUsers(), HttpStatus.OK)";
    }

    /**
     * 通过id 查找用户
     * api :localhost:8099/users/1
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通过id获取用户信息", notes = "返回用户信息")
    public String getUserById(@PathVariable Integer id) {
        return "new ResponseEntity<>(userService.getUserById(Long.valueOf(id)), HttpStatus.OK)";
    }


    /**
     * 通过spring data jpa 调用方法
     * api :localhost:8099/users/byname?username=xxx
     * 通过用户名查找用户
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/byname", method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", dataType = "string")
    @ApiOperation(value = "通过用户名获取用户信息", notes = "返回用户信息")
    public String getUserByUserName(HttpServletRequest request) {
        return "ddd";
    }

    /**
     * 通过spring data jpa 调用方法
     * api :localhost:8099/users/byUserNameContain?username=xxx
     * 通过用户名模糊查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/byUserNameContain", method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", dataType = "string")
    @ApiOperation(value = "通过用户名模糊搜索用户信息", notes = "返回用户信息")
    public String getUsers(HttpServletRequest request) {
        return "new ResponseEntity<>(userService.getByUsernameContaining(username), HttpStatus.OK)";
    }


    /**
     * 添加用户啊
     * api :localhost:8099/users
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ApiModelProperty(value = "user", notes = "用户信息的json串")
    @ApiOperation(value = "新增用户", notes = "返回新增的用户信息")
    public String saveUser(@RequestBody String user) {
        return "new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK)";
    }

    /**
     * 修改用户信息
     * api :localhost:8099/users
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    @ApiModelProperty(value = "user", notes = "修改后用户信息的json串")
    @ApiOperation(value = "新增用户", notes = "返回新增的用户信息")
    public String updateUser() {
        return "new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK)";
    }

    /**
     * 通过ID删除用户
     * api :localhost:8099/users/2
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "通过id删除用户信息", notes = "返回删除状态1 成功 0 失败")
    public String deleteUser(@PathVariable Integer id) {
        return "new ResponseEntity<>(userService.removeUser(id.longValue()), HttpStatus.OK)";
    }
}
