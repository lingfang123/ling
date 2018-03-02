package com.yzf.repsotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yzf.pojo.BankCardMn;

public interface BankCardMnRepsotory extends JpaRepository<BankCardMn, Integer>{
	/**
	 * SELECT
	 * 	FROM
	 * 		t_bankcard bk
	 * 	WHERE
	 * 		bk.name = '凌云'
	 * AND bk.bankcardno = '6227'
	 * AND bk.phone = '15779897850'
	 * AND bk.sfbankcardno = '360734'
	 * */
	@Query("SELECT b FROM BankCardMn b WHERE b.bankcardno =:bankcardno AND b.phone =:phone AND b.sfbankcardno =:sfbankcardno AND b.name =:name")
	BankCardMn findOne(@Param("bankcardno") String bankcardno,@Param("phone") String phone,@Param("sfbankcardno") String sfbankcardno,@Param("name") String name);
	/**
	 * 根据银行卡查出银行卡信息
	 * */
	BankCardMn getByBankcardno(String bankcardno);
	
}
