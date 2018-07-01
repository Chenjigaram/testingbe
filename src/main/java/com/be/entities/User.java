package com.be.entities;



import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Description of User.
 * 
 * @author Chenjigaram Naveen
 */
@Entity
@Table(name = "app_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "mobile_number")
	private Long mobileNumber;
	/**
	 * Description of the property employee email.
	 */
	@Column(unique = true, name = "username")
	private String userName;
	/**
	 * Description of the property First Name.
	 */
	@Column(name = "first_name")
	private String firstName;
	/**
	 * Description of the property Last Name.
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * Description of the property password.
	 */
	
	private String password;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	

	/**
	 * Description of the property Account Status.
	 */
	@Column(name = "account_status")
	private String accountStatus;
	
	@Column(name = "amount_balance")
	private Long amountBalance;

	public Long getAmountBalance() {
		return amountBalance;
	}

	public void setAmountBalance(Long amountBalance) {
		this.amountBalance = amountBalance;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", username=" + userName + ", "+ ", role=" + role.getRoleName()
				+ ", Mobile Number=" +mobileNumber+" ]";
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonIgnore
	@JsonProperty(value = "user_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}
