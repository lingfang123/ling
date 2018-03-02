package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_leave_word")
public class LeaveWord implements Serializable{

	/**
	 * 消息表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("content")
	private String content;//内容
	@TableField("userid")
	private Integer userid;//用户id
	@TableField("createTime")
	private String createTime;//创建时间
	@TableField("replyContent")
	private String replyContent;//回复内容
	@TableField("adminid")
	private Integer adminid;//管理员id
	@TableField("replyTime")
	private String replyTime;//回复时间
	public LeaveWord() {}
	public LeaveWord(Integer id, String content, Integer userid, String createTime, String replyContent,
			Integer adminid, String replyTime) {
		this.id = id;
		this.content = content;
		this.userid = userid;
		this.createTime = createTime;
		this.replyContent = replyContent;
		this.adminid = adminid;
		this.replyTime = replyTime;
	}
	@Override
	public String toString() {
		return "LeaveWord [id=" + id + ", content=" + content + ", userid=" + userid + ", createTime=" + createTime
				+ ", replyContent=" + replyContent + ", adminid=" + adminid + ", replyTime=" + replyTime + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
}
