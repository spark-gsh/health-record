package com.example.healthrecord.service;



import com.example.healthrecord.entity.SysManage;
import com.example.healthrecord.mapper.SysManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private SysManageMapper mapper;

    public Boolean save(SysManage sysManage){
        return mapper.insert(sysManage)>0?true:false;
    }

    public Boolean loginByName(String username,String pwd,String roleid){
        SysManage sysManage = mapper.searchByName(username);

        System.out.println(sysManage.getUsername());
        System.out.println(sysManage.getsDId());

        if (sysManage != null){
            if (sysManage.getUsername().equals(username)
                    && sysManage.getPassword().equals(pwd)
                    && sysManage.getsDId().equals(roleid)){
                return true;
            }
            return false;
        }

        return false;
    }

    public int searchByExampleCount(SysManage sysManage){
        return mapper.selectByExampleCount(sysManage);
    }

    public List<SysManage> searchByExampleWithPage(SysManage sysManage,int page,int limit){
        int begin = limit * (page - 1);

        List<SysManage> result = mapper.searchByExampleWithPage(sysManage,begin,limit);

        return result;
    }

    public int searchNum(){
        return mapper.searchNum();
    }

    public int updateUser(SysManage sysManage){
        return mapper.updateByPrimaryKey(sysManage);
    }

    public int deleteAll(String sMId){
        return mapper.deleteByPrimaryKey(sMId);
    }
}
