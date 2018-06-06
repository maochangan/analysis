package com.example.analysis.service.impl;

import com.example.analysis.bean.WxCnt;
import com.example.analysis.bean.WxUser;
import com.example.analysis.dao.WxCntDao;
import com.example.analysis.dao.WxUserDao;
import com.example.analysis.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxUserDao wxUserDao;

    @Autowired
    private WxCntDao wxCntDao;


    @Override
    public List<WxUser> getAllUser() {
        List<WxUser> list = wxUserDao.getAllWxUser();
        if (0 == list.size()) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public boolean checkUserRegister(String openId) {
        return wxUserDao.checkUserRegister(openId);
    }

    @Override
    public boolean insert(WxUser user) {
        int state = wxUserDao.insert(user);
        if (0 == state) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public WxUser returnWxUserByOpenId(String openid) {
        WxUser wxUser = wxUserDao.returnWxUserByOpenId(openid);
        if (null == wxUser) {
            return null;
        } else {
            return wxUser;
        }
    }

    @Override
    public boolean update(WxUser user) {
        int state = wxUserDao.update(user);
        if (state == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertCnt(WxCnt cnt) {
        int state = wxCntDao.insert(cnt);
        if (0 == state) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Integer getCntByEntity(WxCnt cnt) {
        WxCnt cnt1 = wxCntDao.selectByEntity(cnt);
        if (null == cnt) {
            return 0;
        } else {
            return cnt1.getId();
        }
    }

    @Override
    public WxCnt getCntById(Integer id) {
        return wxCntDao.selectById(id);
    }

    @Override
    public boolean updateCnt(WxCnt wxCnt) {
        return 0 != wxCntDao.update(wxCnt);
    }

    @Override
    public Integer getCntByOwnerId(WxCnt cnt) {
        WxCnt cnt1 = wxCntDao.selectByOnlyId(cnt.getOwnerId());
        if (null == cnt) {
            return 0;
        } else {
            return cnt1.getId();
        }
    }
}
