package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_help_center")
public class HelpCenter implements Serializable{
	/**
	 * 帮助提示表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("classify")
	private Integer classify;//大标题(1:安全保障，2：我要投资，3：我要借款，4:我的账户)
	@TableField("issue")
	private String issue;//问题
	@TableField("answer")
	private String answer;//答案
	public HelpCenter() {}
	public HelpCenter(Integer id, Integer classify, String issue, String answer) {
		this.id = id;
		this.classify = classify;
		this.issue = issue;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "HelpCenter [id=" + id + ", classify=" + classify + ", issue=" + issue + ", answer=" + answer + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassify() {
		return classify;
	}
	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
