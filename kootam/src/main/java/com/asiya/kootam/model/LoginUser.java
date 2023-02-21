package com.asiya.kootam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint( name = "lu_Phone_unique", columnNames = "lu_Phone")
})
public class LoginUser {
	
	

		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		@Column(name = "lu_Id")
		private int luId;
		
		@Column(name = "lu_Name")
		private String luName;
		
		
		@Column(name = "lu_Phone",unique = true)
		private String luPhone;
		
		@Column(name = "lu_Password")
		private String luPassword;
		
		@Column(name = "lu_UserType")
		private String luUserType;

		public int getLuId() {
			return luId;
		}

		public void setLuId(int luid) {
			this.luId = luid;
		}

		public String getLuName() {
			return luName;
		}

		public void setLuName(String luName) {
			this.luName = luName;
		}

		public String getLuPassword() {
			return luPassword;
		}

		public void setLuPassword(String luPassword) {
			this.luPassword = luPassword;
		}

		public String getLuUserType() {
			return luUserType;
		}

		public void setLuUserType(String luUserType) {
			this.luUserType = luUserType;
		}

		public String getLuPhone() {
			return luPhone;
		}

		public void setLuPhone(String luPhone) {
			this.luPhone = luPhone;
		}
		
		
		
	}
