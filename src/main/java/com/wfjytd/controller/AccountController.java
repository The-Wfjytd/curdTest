package com.wfjytd.controller;

import com.wfjytd.pojo.Account;
import com.wfjytd.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author wfjytd
 * @create 2021-11-21 13:11
 */
@Controller
public class AccountController {

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

   @RequestMapping(value = "/list")
    public String toList(Model model){
        List<Account> allAccount = accountService.getAllAccount();
        model.addAttribute("list",allAccount);
        return "list";
    }
    @RequestMapping("/add")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("addAccount")
    public String addAccount(Account account){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name",account.getName());
        map.put("money",account.getMoney());
        int addAccount = accountService.addAccount(map);
//        return "redirect:/list";
        return "redirect:/list";
//        return "redirect:/list";
    }
    @RequestMapping("/update/{id}")
    public String toUpdate(Model model,@PathVariable("id") int id){
        Account accountById = accountService.getAccountById(id);
        model.addAttribute("account",accountById);
        return "update";
    }
    @RequestMapping("/updateAccount")
    public String updateAccount(Account account){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name",account.getName());
        map.put("money",account.getMoney());
        map.put("id",account.getId());
       accountService.updateAccount(map);
       return "redirect:/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id ){
       accountService.deleteAccount(id);
       return "redirect:/list";
    }
    @RequestMapping(value = "/deletes/{ids}",method = RequestMethod.POST)
    @ResponseBody
    public String deletes(@PathVariable("ids") String ids){
        String[] date = ids.split(",");
        System.out.println("11111111111111111111111111");
        for (int i = 0; i < date.length; i++) {
            accountService.deleteAccount(Integer.parseInt(date[i]));
        }
        return "redirect:/list";
    }




}
