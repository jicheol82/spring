package test.spring.model;

import java.beans.ConstructorProperties;
import java.util.Date;

public class TestBean {
	// 하나의 클래스에 변수와 메소드가 있는 일반적인 클래스
	private Integer num;
	private String name;
	private Date reg;
	
	public TestBean() {}
	public TestBean(String name) {
		this.name = name;
	}
	// 아래와 같이 하면 context.xml에서 <constructor-arg name=""~>을 사용
	// 할 수 있다. 하지만 이클립스에서는 옵션창에서 활성화 가능하므로 쓸 필요 없다
	@ConstructorProperties({"name","reg"}) // 상속시 자녀클래스에서도 선언필요
	public TestBean(String name, Date reg) {
		this.name=name; this.reg=reg;
	}
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
