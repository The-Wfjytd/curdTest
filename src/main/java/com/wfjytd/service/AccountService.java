package com.wfjytd.service;

import com.wfjytd.pojo.Account;

import java.util.List;
import java.util.Map;

/**
 * @author wfjytd
 * @create 2021-11-21 12:32
 */
public interface AccountService {
    //增加账户
    int addAccount(Map map);
    //更新账户信息
    int updateAccount(Map map);
    //删除账户信息
    int deleteAccount(int id);
    //查询所有账户
    List<Account> getAllAccount();

    Account getAccountById(int id);
}
