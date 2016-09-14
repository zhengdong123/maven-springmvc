/**
 * @ProjectName: 社会服务子应用
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月13日 下午11:06:41
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.data.structure.stackorqueue;

import java.util.Stack;

/**
 * <p>
 * 同MyStack1
 * </p>
 * 此法优点：压栈时麻烦，弹出容易。
 * @author zhengdong 2016年9月13日 下午11:06:41
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2016年9月13日
 * @modify by reason:{方法名}:{原因}
 */
public class MyStack2 {
	
	// 常量------------------------------------------------------------------
	private final Stack<Integer> stackData;
	private final Stack<Integer> stackMin;
	
	public MyStack2() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	public void push(int newnum) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newnum);
		} else if (newnum < getmin()) {
			this.stackMin.push(newnum);
		} else {
			this.stackMin.push(getmin());
		}
		this.stackData.push(newnum);
	}
	
	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your StackData Is Empty ");
		}
		this.stackMin.pop();
		return this.stackData.peek();
	}
	
	/**
	 * @author zhengdong 2016年9月13日 下午11:11:24
	 * @return
	 */
	private int getmin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException(" Your Stack is empty ");
		}
		return this.stackMin.peek();
	}
}
