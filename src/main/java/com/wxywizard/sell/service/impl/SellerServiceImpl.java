package com.wxywizard.sell.service.impl;

import com.wxywizard.sell.dataobject.SellerInfo;
import com.wxywizard.sell.repository.SellerInfoRepository;
import com.wxywizard.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangxy
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
