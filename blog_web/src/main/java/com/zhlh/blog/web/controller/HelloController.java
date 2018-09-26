package com.zhlh.blog.web.controller;

import com.github.pagehelper.PageHelper;
import com.zhlh.blog.model.Department;
import com.zhlh.blog.service.HelloService;
import com.zhlh.blog.web.vo.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hello")
@Api(value = "/api/hello",tags = "Hello接口模块")
public class HelloController extends BaseController{

    @Autowired
    HelloService helloService;

    /**
     * (集成mybatis的分页插件pageHelper实现)
     * @param currentPage    :当前页数
     * @param pageSize        :每页显示的总记录数
     * @return
     */
    @ApiOperation(value = "根据条件查出部门列表",notes = "分页查询数据库中的部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前是第几页",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示的记录数",required = true,dataType = "String",paramType = "path"),
           /* @ApiImplicitParam(name = "department",value = "部门实体department",required = false,dataType = "Department")*/
    })
    @RequestMapping(value = "/findDept/{currentPage}/{pageSize}",method = RequestMethod.GET)
    public Object findDept(@PathVariable("currentPage")Integer currentPage,@PathVariable("pageSize")Integer pageSize,Department department){
        log.info("请求参数当前页{},每页显示的记录数{}",currentPage,pageSize);
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Department> allItems = helloService.pageList(department);//全部数据
        int countNums = helloService.pageListCount(department);//总记录数
        PageBean<Department> pageData = new PageBean<Department>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        log.info("返回数据{},{}",pageData,buildSuccJson(pageData));
        return buildSuccJson(pageData);
    }
}
