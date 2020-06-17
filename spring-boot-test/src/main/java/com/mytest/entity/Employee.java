package com.mytest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	 /**
     * 員工編號
     */
    @Id
    private String empId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 部門ID
     */
    private String depId;
    
    /**
     * 性別
     */
    private char gender;
    
    /**
     * 電話
     */
    private String phone;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 年齡
     */
    private Integer age;
    
    /**
     * 建立時間
     */
    private String createTime;
    
    /**
     * 最後一次修改時間
     */
    private String modifyTime;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

}
