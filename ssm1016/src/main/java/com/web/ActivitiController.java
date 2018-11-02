package com.web;

import com.service.ActivitiService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ActivitiController {
    @Autowired
    private ActivitiService activitiService;
    //查询流程定义和部署信息
    @RequestMapping("/bushu/getdeploys")
    public String chaxun(ModelMap map){
        //查询部署信息
        List<Deployment> dlist=activitiService.getdeplist();
        //查询流程定义信息
        List<ProcessDefinition> prolist=activitiService.getprolist();
        map.put("dlist",dlist);
        map.put("prolist",prolist);
        return "/bushu/list";
    }
    //上传流程文件
    @RequestMapping("/bushu/adddeploy")
    public String up(MultipartFile depfile,String name){
        try {
            activitiService.add(depfile.getInputStream(),name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/bushu/getdeploys";
    }
}
