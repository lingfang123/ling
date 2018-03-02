package com.jyb.mapper;

import java.util.List;

import com.jyb.base.BaseDao;
import com.jyb.pojo.UserBankcard;

public interface UserBankcardMapper extends BaseDao<Integer,UserBankcard>{
	List<UserBankcard> findBank (Integer id);
	List<UserBankcard> findUserBank (String bankcardno);
	UserBankcard findBankNo (String bankcardno);
}
