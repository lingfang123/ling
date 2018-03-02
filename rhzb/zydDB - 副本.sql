/*
Navicat MySQL Data Transfer

Source Server         : myliux
Source Server Version : 50638
Source Host           : 120.78.154.145:3306
Source Database       : zydDB

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-01-25 16:27:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exception` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `operatedate` datetime DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `remoteaddr` varchar(255) DEFAULT NULL,
  `requesturi` varchar(255) DEFAULT NULL,
  `timeout` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1250 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logsq
-- ----------------------------
DROP TABLE IF EXISTS `logsq`;
CREATE TABLE `logsq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exception` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `operatedate` datetime DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `remoteaddr` varchar(255) DEFAULT NULL,
  `requesturi` varchar(255) DEFAULT NULL,
  `timeout` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3404 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_applyfor_credit
-- ----------------------------
DROP TABLE IF EXISTS `t_applyfor_credit`;
CREATE TABLE `t_applyfor_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `applyforid` int(11) DEFAULT NULL COMMENT '贷款申请表id(借款申请表 t_loans_applyfor)',
  `marriage` int(11) DEFAULT NULL COMMENT '婚姻状况(0:已婚，1:未婚，2:离异)',
  `children` int(11) DEFAULT NULL COMMENT '有无子女(0:无子女，1:有子女)',
  `directname` varchar(100) DEFAULT NULL COMMENT '直系亲属姓名',
  `directrelation` varchar(100) DEFAULT NULL COMMENT '直系关系',
  `directphone` varchar(100) DEFAULT NULL COMMENT '直系手机号码',
  `qtname` varchar(100) DEFAULT NULL COMMENT '其他联系人姓名',
  `qtphone` varchar(100) DEFAULT NULL COMMENT '其他联系人手机号码',
  `professionzt` varchar(100) DEFAULT NULL COMMENT '职业状态',
  `unitsname` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `postname` varchar(100) DEFAULT NULL COMMENT '职位',
  `monthlyincome` decimal(18,0) DEFAULT NULL COMMENT '月收入',
  `email` varchar(100) DEFAULT NULL COMMENT '工作邮箱',
  `provinceID` int(11) DEFAULT NULL COMMENT '工作省份',
  `cityID` int(11) DEFAULT NULL COMMENT '工作城市',
  `districtID` int(11) DEFAULT NULL COMMENT '县/区',
  `address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `possesshouse` int(11) DEFAULT NULL COMMENT '是否有房(0:无房，1:有房)',
  `loanshouse` int(11) DEFAULT NULL COMMENT '有无房贷(0:无房贷，1:有房贷)',
  `possesscar` int(11) DEFAULT NULL COMMENT '是否有车(0:无车，1:有车)',
  `loanscar` int(11) DEFAULT NULL COMMENT '有无车贷(0:无车贷，1:有车贷)',
  `identitycardimg` varchar(255) DEFAULT NULL COMMENT '身份证照片',
  `employeecardimg` varchar(255) DEFAULT NULL COMMENT '工作证照片',
  `incomecardimg` varchar(255) DEFAULT NULL COMMENT '收入证明照片',
  `houseimg` varchar(255) DEFAULT NULL COMMENT '房产证照片',
  `carimg` varchar(255) DEFAULT NULL COMMENT '购车证照片',
  `educationimg` varchar(255) DEFAULT NULL COMMENT '学历证照片',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款申请(信用标)信息表';

-- ----------------------------
-- Table structure for t_applyfor_inspect
-- ----------------------------
DROP TABLE IF EXISTS `t_applyfor_inspect`;
CREATE TABLE `t_applyfor_inspect` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `applyforid` int(11) DEFAULT NULL COMMENT '贷款申请表id(借款申请表 t_loans_applyfor)',
  `swname` varchar(100) DEFAULT NULL COMMENT '实物名称',
  `swpinpai` varchar(100) DEFAULT NULL COMMENT '品牌',
  `kctime` date DEFAULT NULL COMMENT '考察时间',
  `inspectimg1` varchar(225) DEFAULT NULL COMMENT '考察图片1',
  `inspectimg2` varchar(225) DEFAULT NULL COMMENT '考察图片2',
  `inspectimg3` varchar(225) DEFAULT NULL COMMENT '考察图片3',
  `inspectimg4` varchar(225) DEFAULT NULL COMMENT '考察图片4',
  `inspectimg5` varchar(225) DEFAULT NULL COMMENT '考察图片5',
  `struts` int(11) DEFAULT NULL COMMENT '状态(1:有效，0:无效)',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='贷款申请(实地考察标)信息表 t_applyfor_inspect';

-- ----------------------------
-- Table structure for t_applyfor_kc
-- ----------------------------
DROP TABLE IF EXISTS `t_applyfor_kc`;
CREATE TABLE `t_applyfor_kc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '称呼',
  `applyforid` int(11) DEFAULT NULL COMMENT '贷款申请表id',
  `phone` varchar(30) DEFAULT NULL COMMENT '联系方式',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `struts` int(11) DEFAULT NULL COMMENT '状态(0:未联系，1:已联系，2:考察中，3:已考察)',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实地考察 t_applyfor_kc';

-- ----------------------------
-- Table structure for t_applyfor_pledge
-- ----------------------------
DROP TABLE IF EXISTS `t_applyfor_pledge`;
CREATE TABLE `t_applyfor_pledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `applyforid` int(11) DEFAULT NULL COMMENT '贷款申请表id(借款申请表 t_loans_applyfor)',
  `goodname` varchar(100) DEFAULT NULL COMMENT '抵押物品名称',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '抵押物名称',
  `detail` varchar(255) DEFAULT NULL COMMENT '物品详细描述',
  `verify_status` int(11) DEFAULT NULL COMMENT '核实状态(0:未核实,1:已核实)',
  `hstime` date DEFAULT NULL COMMENT '时间',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抵押物品表 t_applyfor_pledge';

-- ----------------------------
-- Table structure for t_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_role`;
CREATE TABLE `t_auth_role` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `r_name` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modelid` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '拥有的权限',
  `status` int(11) DEFAULT NULL COMMENT '角色状态(1启用,2禁用)',
  `remark` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=swe7 COMMENT='权限表';

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `c_id` bigint(20) NOT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `provinceID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hendname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `context` text CHARACTER SET utf8 COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1 COMMENT='公司简介表';

-- ----------------------------
-- Table structure for t_company_zj
-- ----------------------------
DROP TABLE IF EXISTS `t_company_zj`;
CREATE TABLE `t_company_zj` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_img` varchar(50) DEFAULT NULL COMMENT '证件图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='公司证件表';

-- ----------------------------
-- Table structure for t_cookie
-- ----------------------------
DROP TABLE IF EXISTS `t_cookie`;
CREATE TABLE `t_cookie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) NOT NULL,
  `cvalue` varchar(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_date
-- ----------------------------
DROP TABLE IF EXISTS `t_date`;
CREATE TABLE `t_date` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `d_name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `d_img` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '图片',
  `type` int(11) DEFAULT NULL COMMENT '类型（0轮播图，1.友情链接）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '状态（0无效1有效）',
  `empid` int(20) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=sjis COMMENT='平台数据表';

-- ----------------------------
-- Table structure for t_district
-- ----------------------------
DROP TABLE IF EXISTS `t_district`;
CREATE TABLE `t_district` (
  `d_id` bigint(20) NOT NULL,
  `districtName` varchar(50) DEFAULT NULL,
  `cityID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_employee_company
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_company`;
CREATE TABLE `t_employee_company` (
  `empid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginname` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '登陆名',
  `password` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '登入密码',
  `nickname` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  `employeeImg` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像',
  `empname` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '真实姓名',
  `identityCard` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证号',
  `empimg` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '在职照片',
  `sex` int(11) DEFAULT NULL COMMENT '性别(1--男 2--女)',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `qq` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT 'qq号',
  `phone` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `roleid` int(11) DEFAULT NULL COMMENT '权限',
  `worktime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '状态(1在职,2离职)',
  `remark` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `lastip` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '最后登入ip',
  `lasttime` datetime DEFAULT NULL COMMENT '最后登入时间',
  `employee` int(2) unsigned zerofill DEFAULT NULL COMMENT '登入状态(0未登入1以登入)',
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COMMENT='员工表';

-- ----------------------------
-- Table structure for t_finance_company
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_company`;
CREATE TABLE `t_finance_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sumMoney` decimal(18,2) DEFAULT NULL COMMENT '余额',
  `djmoney` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='公司金额表';

-- ----------------------------
-- Table structure for t_finance_companydetail
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_companydetail`;
CREATE TABLE `t_finance_companydetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `incomeType` int(11) DEFAULT NULL COMMENT '类型0--收入 1--支出',
  `transMoney` decimal(18,2) DEFAULT NULL COMMENT '操作金额',
  `useableMoney` decimal(18,2) DEFAULT NULL COMMENT '可用余额',
  `operateTime` datetime DEFAULT NULL COMMENT '操作时间',
  `remark` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='公司账户明细';

-- ----------------------------
-- Table structure for t_fund_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_fund_detail`;
CREATE TABLE `t_fund_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `money` decimal(18,2) DEFAULT NULL COMMENT '明细金额',
  `dateiltime` datetime DEFAULT NULL COMMENT '明细时间',
  `struts` int(11) DEFAULT NULL COMMENT '状态(0:充值1:提现2:手续费3:利息返还4:理财5:返还本金)',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `bychar` decimal(18,2) DEFAULT NULL COMMENT '账户余额',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=345 DEFAULT CHARSET=utf8 COMMENT='用户资金明细表';

-- ----------------------------
-- Table structure for t_help_center
-- ----------------------------
DROP TABLE IF EXISTS `t_help_center`;
CREATE TABLE `t_help_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `classify` int(11) DEFAULT NULL COMMENT '大标题(1:安全保障，2：我要投资，3：我要借款，4:我的账户，5：名词解释)',
  `issue` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '问题',
  `answer` text CHARACTER SET utf8 COMMENT '答案',
  `classifyname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1 COMMENT='帮助我们 t_help_center';

-- ----------------------------
-- Table structure for t_information
-- ----------------------------
DROP TABLE IF EXISTS `t_information`;
CREATE TABLE `t_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `companyname` varchar(200) NOT NULL COMMENT '公司全称',
  `abbreviation` varchar(100) DEFAULT NULL COMMENT '公司简称',
  `creditnumber` varchar(100) DEFAULT NULL COMMENT '统一社会信用代码',
  `zc_fund` decimal(18,2) DEFAULT NULL COMMENT '注册资金',
  `sj_fund` decimal(18,2) DEFAULT NULL COMMENT '实缴注册资金',
  `zc_address` varchar(100) DEFAULT NULL COMMENT '注册地址',
  `manage_address` varchar(100) DEFAULT NULL COMMENT '经营地址',
  `createtime` varchar(50) DEFAULT NULL COMMENT '成立时间',
  `manage_deadline` varchar(50) DEFAULT NULL COMMENT '经营期限',
  `status` int(11) DEFAULT NULL COMMENT '经营状态',
  `legal_person` varchar(50) DEFAULT NULL COMMENT '法人代表',
  `scope` varchar(100) DEFAULT NULL COMMENT '经营范围',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='组织信息表';

-- ----------------------------
-- Table structure for t_invest
-- ----------------------------
DROP TABLE IF EXISTS `t_invest`;
CREATE TABLE `t_invest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id(用户表 t_user)',
  `tmarkid` int(11) DEFAULT NULL COMMENT '标的id(发标表 t_mark_info)',
  `markid` int(11) DEFAULT NULL COMMENT '标的类型(标型表 t_mark)',
  `refundtime` datetime DEFAULT NULL COMMENT '计息时间',
  `markmoney` decimal(18,2) DEFAULT NULL COMMENT '投资金额',
  `overduemoney` decimal(18,2) DEFAULT NULL COMMENT '预期收益',
  `hbid` int(11) DEFAULT NULL COMMENT '红包id',
  `hbmoney` decimal(18,2) DEFAULT NULL COMMENT '红包金额',
  `borrowtime` varchar(30) DEFAULT NULL COMMENT '借款期限（借多少个月）',
  `bidtime` datetime DEFAULT NULL COMMENT '投标时间',
  `status` int(11) DEFAULT NULL COMMENT '状态(1:竞标中,2:流标,3:竞标成功,4:还款中,5:已完成）',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='投资记录表 t_invest';

-- ----------------------------
-- Table structure for t_invitation
-- ----------------------------
DROP TABLE IF EXISTS `t_invitation`;
CREATE TABLE `t_invitation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `yquserid` int(11) DEFAULT NULL COMMENT '被邀请人id',
  `yqtime` datetime DEFAULT NULL COMMENT '邀请时间',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='邀请表';

-- ----------------------------
-- Table structure for t_ip
-- ----------------------------
DROP TABLE IF EXISTS `t_ip`;
CREATE TABLE `t_ip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_law
-- ----------------------------
DROP TABLE IF EXISTS `t_law`;
CREATE TABLE `t_law` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `style` int(255) DEFAULT NULL COMMENT '类型（1法律政策 ；2法律声明；3资费说明）',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '问题',
  `rejoin` text CHARACTER SET utf8 COMMENT '回答',
  `stylename` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型名称（法律政策，法律声明，资费说明）',
  `backup2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1 COMMENT='与法律有关';

-- ----------------------------
-- Table structure for t_leave_word
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_word`;
CREATE TABLE `t_leave_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `createTime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `replyContent` varchar(1000) DEFAULT NULL COMMENT '回复内容',
  `adminid` int(11) DEFAULT NULL COMMENT '管理员id',
  `replyTime` varchar(30) DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_loans_applyfor
-- ----------------------------
DROP TABLE IF EXISTS `t_loans_applyfor`;
CREATE TABLE `t_loans_applyfor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `markid` int(11) DEFAULT NULL COMMENT '借款类型',
  `headline` varchar(100) DEFAULT NULL COMMENT '借款标题',
  `purpose` varchar(100) DEFAULT NULL COMMENT '借款用途',
  `applyformoney` decimal(18,2) DEFAULT NULL COMMENT '借款金额',
  `applyforTime` datetime DEFAULT NULL COMMENT '申请时间',
  `borrowtime` varchar(100) DEFAULT NULL COMMENT '贷款时间（1-24个月）',
  `deadline` varchar(100) DEFAULT NULL COMMENT '借款期限（-投标的最后日期）',
  `nhrate` decimal(18,2) DEFAULT NULL COMMENT '年化利率',
  `paymentMode` int(11) DEFAULT NULL COMMENT '还款方式(1 按月等额本息还款 2 按先息后本还款)',
  `repaymoney` decimal(18,2) DEFAULT NULL COMMENT '需还利息',
  `managemoney` decimal(18,2) DEFAULT NULL COMMENT '管理费用',
  `struts` int(11) DEFAULT NULL COMMENT '审核表(0.审核中，1.审核未通过，2.审核通过)',
  `checka` int(11) DEFAULT NULL COMMENT '审核人(后台管理员id)',
  `sktime` datetime DEFAULT NULL COMMENT '审核时间',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='借款申请表';

-- ----------------------------
-- Table structure for t_manage
-- ----------------------------
DROP TABLE IF EXISTS `t_manage`;
CREATE TABLE `t_manage` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `m_TransactionAmount` decimal(18,2) DEFAULT NULL COMMENT '累计交易金额',
  `m_sumTransactionNum` int(11) DEFAULT NULL COMMENT '累计交易总笔数',
  `m_yesterdayAmount` decimal(18,2) DEFAULT NULL COMMENT '昨日累计总额',
  `m_borrowMoney` int(11) DEFAULT NULL COMMENT '累计借款人数',
  `m_borrowLoan` int(11) DEFAULT NULL COMMENT '累计借出人数',
  `m_debitAndCredit` decimal(18,2) DEFAULT NULL COMMENT '累计借贷总额',
  `m_updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='运营信息';

-- ----------------------------
-- Table structure for t_mark
-- ----------------------------
DROP TABLE IF EXISTS `t_mark`;
CREATE TABLE `t_mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `markname` varchar(100) DEFAULT NULL COMMENT '标的名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '说明',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='标型表';

-- ----------------------------
-- Table structure for t_mark_info
-- ----------------------------
DROP TABLE IF EXISTS `t_mark_info`;
CREATE TABLE `t_mark_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id(用户表 t_user)',
  `applyforid` int(11) DEFAULT NULL COMMENT '贷款申请表id(借款申请表 t_loans_applyfor)',
  `headline` varchar(100) DEFAULT NULL COMMENT '标的标题',
  `money` decimal(18,2) DEFAULT NULL COMMENT '借款金额',
  `markid` int(11) DEFAULT NULL COMMENT '借款类型(某某标)',
  `countmoney` decimal(18,2) DEFAULT NULL COMMENT '已筹金额',
  `accrual` decimal(10,2) DEFAULT NULL COMMENT '标的投资利率（在申请表通过时计算添加）',
  `refundtypeid` int(11) DEFAULT NULL COMMENT '借款人还款类型表id',
  `paymentMode` int(11) DEFAULT NULL COMMENT '还款方式(1 按月等额本息还款 2 按先息后本还款)',
  `investmin` decimal(18,2) DEFAULT NULL COMMENT '最小投资金额（默认0）',
  `investmax` decimal(18,2) DEFAULT NULL COMMENT '最大投资金额（默认是借款金额）',
  `borrowtime` varchar(30) DEFAULT NULL COMMENT '借款期限（借多少个月）',
  `purpose` varchar(100) DEFAULT NULL COMMENT '借款用途',
  `deadline` datetime DEFAULT NULL COMMENT '筹款期限-竞标结束时间（在这个时间点前要完成）',
  `starttime` datetime DEFAULT NULL COMMENT '竞标开始时间',
  `refundstart` varchar(30) DEFAULT NULL COMMENT '还款开始时间（标完成的下一个月开始）',
  `moneyaccrual` decimal(18,2) DEFAULT NULL COMMENT '已还利息费用（借款人还了多少利息）',
  `moneybenjin` decimal(18,2) DEFAULT NULL COMMENT '已还本金（借款人还了多少本金）',
  `overduestatus` int(11) DEFAULT NULL COMMENT '是否逾期（0.逾期，1.未愈期）',
  `projectrating` varchar(50) DEFAULT NULL COMMENT '项目评级',
  `vcopinion` varchar(100) DEFAULT NULL COMMENT '风投意见',
  `vcopiniondj` int(11) DEFAULT NULL COMMENT '风险等级',
  `count` int(11) DEFAULT NULL COMMENT '投资人数',
  `struts` int(11) DEFAULT NULL COMMENT '状态(0:未开始,1:竞标中,2:流标,3:满额,4:已交付,5:还款中,6:已完成)',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='发标表 t_mark_info';

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(11) DEFAULT NULL COMMENT '类型 1短信、2邮箱',
  `hendline` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `qcontext` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '前一段内容',
  `hcontext` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '后一段内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='短信/邮箱';

-- ----------------------------
-- Table structure for t_message_info
-- ----------------------------
DROP TABLE IF EXISTS `t_message_info`;
CREATE TABLE `t_message_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '接收人',
  `account` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送账号',
  `hendline` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送标题',
  `context` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送内容',
  `createtime` datetime DEFAULT NULL COMMENT '发送时间',
  `type` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='短信/邮箱记录';

-- ----------------------------
-- Table structure for t_new_company
-- ----------------------------
DROP TABLE IF EXISTS `t_new_company`;
CREATE TABLE `t_new_company` (
  `new_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `newtitle` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '新闻标题',
  `newimage` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '新闻图片',
  `url` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'URL地址',
  `content` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '新闻内容',
  `type` int(11) DEFAULT NULL COMMENT '类型(网站新闻1行业新闻2媒体新闻3)',
  `createtiem` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '状态(有效1无效0)',
  `empid` int(11) DEFAULT NULL COMMENT '发布人id',
  `bychar` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COMMENT='新闻表';

-- ----------------------------
-- Table structure for t_notice_company
-- ----------------------------
DROP TABLE IF EXISTS `t_notice_company`;
CREATE TABLE `t_notice_company` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `newsname` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `url` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '链接',
  `content` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '内容',
  `type` int(11) DEFAULT NULL COMMENT '类型（0新闻1公告）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '状态（0无效1有效）',
  `empid` int(20) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1 COMMENT='平台公告表';

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `p_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源名称',
  `type` int(11) DEFAULT NULL COMMENT '资源类型：menu,button',
  `url` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` int(11) DEFAULT NULL COMMENT '父结点id',
  `available` int(11) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1 COMMENT='树节点/按钮表';

-- ----------------------------
-- Table structure for t_province
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `p_id` bigint(20) NOT NULL,
  `provinceName` varchar(50) DEFAULT NULL,
  `asname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_recruit
-- ----------------------------
DROP TABLE IF EXISTS `t_recruit`;
CREATE TABLE `t_recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `headline` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `rejoin` text CHARACTER SET utf8 COMMENT '回答',
  `backup1` varchar(255) DEFAULT NULL,
  `backup2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='招贤纳士';

-- ----------------------------
-- Table structure for t_redenvelopes
-- ----------------------------
DROP TABLE IF EXISTS `t_redenvelopes`;
CREATE TABLE `t_redenvelopes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `harvesttime` datetime DEFAULT NULL COMMENT '收红包时间',
  `minmoney` decimal(18,2) DEFAULT NULL COMMENT '最少投标金额',
  `tjmoney` decimal(18,2) DEFAULT NULL COMMENT '可到多少金额',
  `hbmoney` decimal(18,2) DEFAULT NULL COMMENT '红包金额',
  `expiretime` datetime DEFAULT NULL COMMENT '到期时间',
  `struts` int(11) DEFAULT NULL COMMENT '状态(0:未使用，1:已使用，2:已到期，3:已冻结)',
  `daynumber` int(11) DEFAULT NULL COMMENT '到期天数',
  `remark` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `bychar` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 COMMENT='用户红包表';

-- ----------------------------
-- Table structure for t_redinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_redinfo`;
CREATE TABLE `t_redinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `redid` int(11) NOT NULL COMMENT '红包id',
  `markid` int(11) NOT NULL COMMENT '投标id',
  `redname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '红包名称',
  `markname` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '投标名称',
  `redtime` datetime DEFAULT NULL COMMENT '兑换时间',
  `bychar` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='红包明细';

-- ----------------------------
-- Table structure for t_refund_record
-- ----------------------------
DROP TABLE IF EXISTS `t_refund_record`;
CREATE TABLE `t_refund_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id(用户表 t_user)',
  `tmarkid` int(11) DEFAULT NULL COMMENT '标的id(发标表 t_mark_info)',
  `refundtime` datetime DEFAULT NULL COMMENT '还款时间',
  `hkmoney` decimal(18,2) DEFAULT NULL COMMENT '还款金额',
  `principal` decimal(18,2) DEFAULT NULL COMMENT '还款本金',
  `interests` decimal(18,2) DEFAULT NULL COMMENT '还款利息',
  `overduestatus` int(11) DEFAULT NULL COMMENT '是否逾期（1.逾期，0.未逾期）',
  `overduedays` int(11) DEFAULT NULL COMMENT '逾期天数',
  `overduemoney` decimal(18,2) DEFAULT NULL COMMENT '逾期费用',
  `status` int(11) DEFAULT NULL COMMENT '状态（0.代还款，1.已还款，2.已过期）',
  `remark` varchar(50) DEFAULT NULL COMMENT '对该条记录添加一定的相关信息',
  `backup1` int(11) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='还款记录表 t_refund_record';

-- ----------------------------
-- Table structure for t_relation_us
-- ----------------------------
DROP TABLE IF EXISTS `t_relation_us`;
CREATE TABLE `t_relation_us` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gs_site` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司地址',
  `gs_number` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司电话',
  `dawk_number` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮政编码',
  `servicenumber` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '客服电话',
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '客服邮箱',
  `servetime` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '客服服务时间',
  `hz_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '商务合作邮箱',
  `hz_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '商务合作联系人',
  `mt_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '媒体采访联系邮箱',
  `mt_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '媒体采访联系人',
  `recruit_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '招聘邮箱',
  `recruit_name` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '招聘联系人姓名',
  `company_coord` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司坐标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='联系我们';

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role` int(11) DEFAULT NULL COMMENT '权限id',
  `permissionid` int(11) DEFAULT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1065 DEFAULT CHARSET=latin1 COMMENT='权限资源中间表';

-- ----------------------------
-- Table structure for t_shareholder
-- ----------------------------
DROP TABLE IF EXISTS `t_shareholder`;
CREATE TABLE `t_shareholder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '股东姓名',
  `companyname` text CHARACTER SET utf8 COMMENT '股东背景',
  `holdings` decimal(18,4) DEFAULT NULL COMMENT '持股份额',
  `cz_money` decimal(18,2) DEFAULT NULL COMMENT '出资金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1 COMMENT='股东信息表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '用户登入密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `userimg` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` int(11) DEFAULT NULL COMMENT '性别(0:女，1:男)',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `provinceID` int(11) DEFAULT NULL COMMENT '省份id',
  `cityID` int(11) DEFAULT NULL COMMENT '城市id',
  `districtID` int(11) DEFAULT NULL COMMENT '县id',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `createTime` date DEFAULT NULL COMMENT '注册时间',
  `moneyid` int(11) DEFAULT NULL COMMENT '用户钱包id',
  `creditid` int(11) DEFAULT NULL COMMENT '用户信用id',
  `vipid` int(11) DEFAULT NULL COMMENT '用户VIPid',
  `referrer` varchar(100) DEFAULT NULL COMMENT '推荐人',
  `referrerm` varchar(100) DEFAULT NULL COMMENT '推荐码',
  `status` int(11) DEFAULT NULL COMMENT '状态(0:禁用，1:正常)',
  `loginNumber` int(11) DEFAULT NULL COMMENT '登入次数',
  `lastIp` varchar(100) DEFAULT NULL COMMENT '最后登入ip',
  `lastTime` date DEFAULT NULL COMMENT '最后登入时间',
  `areaIp` varchar(100) DEFAULT NULL COMMENT '最后登入城市',
  `birthday` varchar(100) DEFAULT NULL COMMENT '生日',
  `reserved2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='用户表 t_user';

-- ----------------------------
-- Table structure for t_user_bankcard
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bankcard`;
CREATE TABLE `t_user_bankcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `bankcardno` varchar(100) DEFAULT NULL COMMENT '银行卡号',
  `placebank` varchar(100) DEFAULT NULL COMMENT '所属银行',
  `bindingtime` date DEFAULT NULL COMMENT '绑卡时间',
  `status` int(11) DEFAULT NULL COMMENT '状态(0:停用，1:禁止,2:使用中)',
  `reserved1` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `reserved2` varchar(100) DEFAULT NULL COMMENT '用户身份证',
  `images` varchar(255) DEFAULT NULL COMMENT '银行图标',
  `reserved3` varchar(255) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='用户银行卡 t_user_bankcard';

-- ----------------------------
-- Table structure for t_user_brokerage
-- ----------------------------
DROP TABLE IF EXISTS `t_user_brokerage`;
CREATE TABLE `t_user_brokerage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `brokeragemoney` decimal(18,0) DEFAULT NULL COMMENT '佣金金额',
  `hqtime` datetime DEFAULT NULL COMMENT '奖励时间',
  `mark` varchar(100) DEFAULT NULL COMMENT '什么标获取的佣金',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户佣金明细表';

-- ----------------------------
-- Table structure for t_user_credit
-- ----------------------------
DROP TABLE IF EXISTS `t_user_credit`;
CREATE TABLE `t_user_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `integral` int(11) DEFAULT NULL COMMENT '用户积分',
  `lineOfCredit` decimal(18,2) DEFAULT NULL COMMENT '信用额度',
  `jknumber` int(11) DEFAULT NULL COMMENT '借款笔数',
  `yqnumber` int(11) DEFAULT NULL COMMENT '逾期笔数',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='用户信用表';

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `namestatus` int(11) DEFAULT NULL COMMENT '真实姓名认证状态（1.已认证,0.未认证,3.审核中，4.认证未通过）',
  `check1` int(11) DEFAULT NULL COMMENT '审核人id(后台管理员)',
  `identityCard` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `cardstatus` int(11) DEFAULT NULL COMMENT '身份证认证状态（1.已认证,0.未认证,3.审核中，4.认证未通过）',
  `check2` int(11) DEFAULT NULL COMMENT '审核人id(后台管理员)',
  `dealPassword` varchar(100) DEFAULT NULL COMMENT '交易密码',
  `dealPassstatus` int(11) DEFAULT NULL COMMENT '密码状态（0.未设置，1.已设置）',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `emailstatus` int(11) DEFAULT NULL COMMENT '邮箱状态（0.未设置，1.已设置）',
  `exitgencystatus` int(11) DEFAULT NULL COMMENT '状态',
  `exitgencyname` varchar(100) DEFAULT NULL COMMENT '紧急联系人姓名',
  `exitgencyphone` varchar(100) DEFAULT NULL COMMENT '紧急联系人手机号码',
  `openAccount` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserved2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='用户安全信息表 t_user_info';

-- ----------------------------
-- Table structure for t_user_integral
-- ----------------------------
DROP TABLE IF EXISTS `t_user_integral`;
CREATE TABLE `t_user_integral` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `credit` int(11) DEFAULT NULL COMMENT '信用表id',
  `changeintegral` int(11) DEFAULT NULL COMMENT '积分变动',
  `changetype` varchar(200) DEFAULT NULL COMMENT '变动类型',
  `integraltime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '变动时间',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户积分明细表';

-- ----------------------------
-- Table structure for t_user_money
-- ----------------------------
DROP TABLE IF EXISTS `t_user_money`;
CREATE TABLE `t_user_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `accountMoney` decimal(18,2) DEFAULT NULL COMMENT '账户余额',
  `usableMoney` decimal(18,2) DEFAULT NULL COMMENT '可用余额',
  `zqMoney` decimal(18,2) DEFAULT NULL COMMENT '平台为用户赚取的金额',
  `freezeMoney` decimal(18,2) DEFAULT NULL COMMENT '冻结金额',
  `collectionMoney` decimal(18,2) DEFAULT NULL COMMENT '待收金额',
  `repayMoney` decimal(18,2) DEFAULT NULL COMMENT '待还金额',
  `reserved1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserved2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='用户资金表t_user_money';

-- ----------------------------
-- Table structure for t_user_recharge
-- ----------------------------
DROP TABLE IF EXISTS `t_user_recharge`;
CREATE TABLE `t_user_recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `cztime` datetime DEFAULT NULL COMMENT '充值时间',
  `rechargeType` int(11) DEFAULT NULL COMMENT '充值类型(0.管理员代充  1.银行卡)',
  `bankName` varchar(100) DEFAULT NULL COMMENT '银行名称',
  `bankcardno` varchar(100) DEFAULT NULL COMMENT '银行卡号',
  `billcode` varchar(100) DEFAULT NULL COMMENT '订单号',
  `paynumber` varchar(100) DEFAULT NULL COMMENT '流水账单号',
  `rechargeMoney` decimal(18,0) DEFAULT NULL COMMENT '充值金额',
  `ipAddress` varchar(100) DEFAULT NULL COMMENT '充值ip',
  `areaIp` varchar(100) DEFAULT NULL COMMENT '充值城市',
  `reserved1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserved2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='用户充值表 t_user_recharge';

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `roleid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COMMENT='用户权限中间表';

-- ----------------------------
-- Table structure for t_user_vip
-- ----------------------------
DROP TABLE IF EXISTS `t_user_vip`;
CREATE TABLE `t_user_vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `vipdj` int(11) DEFAULT NULL COMMENT 'VIP等级',
  `viptime` datetime DEFAULT NULL COMMENT '生成时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '说明',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='用户VIP表';

-- ----------------------------
-- Table structure for t_user_vipchange
-- ----------------------------
DROP TABLE IF EXISTS `t_user_vipchange`;
CREATE TABLE `t_user_vipchange` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `vipid` int(11) NOT NULL COMMENT '用户vip表',
  `changetime` datetime DEFAULT NULL COMMENT '变动时间',
  `ydjvip` int(11) DEFAULT NULL COMMENT '原等级',
  `bdjvip` int(11) DEFAULT NULL COMMENT '变动级别',
  `bychar` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `bystr` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='vip变动表';

-- ----------------------------
-- Table structure for t_user_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `t_user_withdraw`;
CREATE TABLE `t_user_withdraw` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `withdrawTime` datetime DEFAULT NULL COMMENT '提现时间',
  `withdrawMoney` decimal(18,2) DEFAULT NULL COMMENT '提现金额',
  `poundage` decimal(18,2) DEFAULT NULL COMMENT '提现手续费',
  `bankName` varchar(100) DEFAULT NULL COMMENT '提现银行卡',
  `bankcardno` varchar(100) DEFAULT NULL COMMENT '提现银行卡号',
  `status` int(11) DEFAULT NULL COMMENT '提现状态(0:提现失败，1:提现中，2:提现成功)',
  `empid` int(11) DEFAULT NULL COMMENT '审核人(管理员id)',
  `arriveTime` datetime DEFAULT NULL COMMENT '到账时间',
  `arriveMoney` decimal(18,2) DEFAULT NULL COMMENT '到账金额',
  `ipAddress` varchar(100) DEFAULT NULL COMMENT '提现ip',
  `areaIp` varchar(100) DEFAULT NULL COMMENT '提现城市',
  `reserved1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserved2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='用户提现表 t_user_withdraw';
