package com.stmproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "M_User")
public class M_User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "No")
	private int no;

	@Id
	@Column(name = "SSO_ID",  columnDefinition = "NVARCHAR(11)",nullable = false)
	private String ssoid;

	@Column(name = "Password", columnDefinition = "NVARCHAR(11)", nullable = false)
	private String password;

	@Column(name = "User_Name_Eng", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String user_Name_Eng;

	@Column(name = "User_Name_Jp",columnDefinition = "NVARCHAR(255)", nullable = false)
	private String user_Name_Jp;

	@Column(name = "User_Email_Id", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String user_Email_Id;

	@Column(name = "User_Type", length = 1, nullable = false)
	private Character user_Type;

	@Column(name = "User_Creation_Date", nullable = false)
	private Date user_Creation_Date;

	@Column(name = "Updated_Date")
	private Date updated_Date;

	@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<STM> stms;

	public List<STM> getStms() {
		return stms;
	}

	public void setStms(List<STM> stms) {
		this.stms = stms;
	}

	public M_User(int no, String ssoid, String password, String user_Name_Eng, String user_Name_Jp,
			String user_Email_Id, Character user_Type, Date user_Creation_Date, Date updated_Date, boolean is_Deleted) {
		super();
		this.no = no;
		this.ssoid = ssoid;
		this.password = password;
		this.user_Name_Eng = user_Name_Eng;
		this.user_Name_Jp = user_Name_Jp;
		this.user_Email_Id = user_Email_Id;
		this.user_Type = user_Type;
		this.user_Creation_Date = user_Creation_Date;
		this.updated_Date = updated_Date;
		this.is_Deleted = is_Deleted;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSsoid() {
		return ssoid;
	}

	public void setSsoid(String ssoid) {
		this.ssoid = ssoid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_Name_Eng() {
		return user_Name_Eng;
	}

	public void setUser_Name_Eng(String user_Name_Eng) {
		this.user_Name_Eng = user_Name_Eng;
	}

	public String getUser_Name_Jp() {
		return user_Name_Jp;
	}

	public void setUser_Name_Jp(String user_Name_Jp) {
		this.user_Name_Jp = user_Name_Jp;
	}

	public String getUser_Email_Id() {
		return user_Email_Id;
	}

	public void setUser_Email_Id(String user_Email_Id) {
		this.user_Email_Id = user_Email_Id;
	}

	public Character getUser_Type() {
		return user_Type;
	}

	public void setUser_Type(Character user_Type) {
		this.user_Type = user_Type;
	}

	public Date getUser_Creation_Date() {
		return user_Creation_Date;
	}

	public void setUser_Creation_Date(Date user_Creation_Date) {
		this.user_Creation_Date = user_Creation_Date;
	}

	public Date getUpdated_Date() {
		return updated_Date;
	}

	public void setUpdated_Date(Date updated_Date) {
		this.updated_Date = updated_Date;
	}

	public boolean isIs_Deleted() {
		return is_Deleted;
	}

	public void setIs_Deleted(boolean is_Deleted) {
		this.is_Deleted = is_Deleted;
	}

	@Column(name = "Is_Deleted")
	private boolean is_Deleted;

	@Override
	public String toString() {
		return "M_User [no=" + no + ", ssoid=" + ssoid + ", password=" + password + ", user_Name_Eng=" + user_Name_Eng
				+ ", user_Name_Jp=" + user_Name_Jp + ", user_Email_Id=" + user_Email_Id + ", user_Type=" + user_Type
				+ ", user_Creation_Date=" + user_Creation_Date + ", updated_Date=" + updated_Date + ", is_Deleted="
				+ is_Deleted + "]";
	}

	public M_User() {
		// Default constructor
	}

}
