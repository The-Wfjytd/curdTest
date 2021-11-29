package com.wfjytd.service;

import com.wfjytd.dao.AccountMapper;
import com.wfjytd.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wfjytd
 * @create 2021-11-21 12:34
 */
public class AccountServiceImpl implements AccountService{

    private AccountMapper accountMapper;

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    public int addAccount(Map map) {
        return accountMapper.addAccount(map);
    }

    public int updateAccount(Map map) {
        return accountMapper.updateAccount(map);
    }

    public int deleteAccount(int id) {
        return accountMapper.deleteAccount(id);
    }

    public List<Account> getAllAccount() {
        List<Account> allAccount = accountMapper.getAllAccount();
        return allAccount;
    }

    public Account getAccountById(int id) {
        return accountMapper.getAccountById(id);
    }


}
