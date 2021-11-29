package com.wfjytd.dao;

import com.wfjytd.pojo.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wfjytd
 * @create 2021-11-21 12:29
 */

public interface AccountMapper {
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
