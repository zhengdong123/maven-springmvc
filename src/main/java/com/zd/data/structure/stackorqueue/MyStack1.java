/**
 * @ProjectName: 栈
 * @Copyright: 2016 Sunsharing Technology Co., Ltd. All Right Reserved.
 * @address: http://www.sunsharing.com.cn
 * @date: 2016年9月7日 下午7:14:26
 * @Description: 本内容仅限于厦门畅享信息技术有限公司内部使用，禁止转发.
 */
package com.zd.data.structure.stackorqueue;

import java.util.Stack;

/**
 * <p>
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小元素的操作。 要求： 1.pop、push、getMin操作的时间复杂度都是O（1）； 2.设计栈的类型可以使用现成的栈结果。
 * </p>
 * @author zhengdong 2016年9月7日 下午7:14:26
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2016年9月7日
 * @modify by reason:{方法名}:{原因}
 */
public class MyStack1 {
	
	private final Stack<Integer> stackData;
	private final Stack<Integer> stackMin;
	
	// 构造方法--------------------------------------------------------------
	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	// 公共方法--------------------------------------------------------------
	/**
	 * 压栈
	 * @author zhengdong 2016年9月13日 下午10:54:13
	 * @param newNum
	 */
	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum <= this.getmin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	
	/**
	 * 出栈
	 * @author zhengdong 2016年9月13日 下午10:54:22
	 * @return
	 */
	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty .");
		}
		int value = this.stackData.pop();
		if (value == this.getmin()) {
			this.stackMin.pop();
		}
		return value;
	}
	
	private int getmin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty . ");
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		MyStack1 myStack1 = new MyStack1();
		myStack1.push(4);
		myStack1.push(5);
		myStack1.push(3);
		myStack1.push(9);
		System.out.println(myStack1.getmin());
		
	}
}
