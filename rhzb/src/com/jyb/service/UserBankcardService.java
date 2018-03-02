package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.User;
import com.jyb.pojo.UserBankcard;

public interface UserBankcardService extends BaseService<Integer, UserBankcard>{
	List<UserBankcard> findBank (Integer id);
	List<UserBankcard> findUserBank (String bankcardno);
	UserBankcard findBankNo (String bankcardno);
	
}
