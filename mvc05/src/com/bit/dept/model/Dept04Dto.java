package com.bit.dept.model;

public class Dept04Dto {
	private int deptno;
	private String dname, loc;
	
	public Dept04Dto(){
		
	}

	// source -> constraint using field, hashcode and equals, toString
	public Dept04Dto(int deptno, String dname, String loc) {
		super();
		this.setDeptno(deptno);
		this.setDname(dname);
		this.setLoc(loc);
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept04Dto [deptno=" + deptno + ", dname=" + dname + ", loc="
				+ loc + "]";
	}
	
	
}
