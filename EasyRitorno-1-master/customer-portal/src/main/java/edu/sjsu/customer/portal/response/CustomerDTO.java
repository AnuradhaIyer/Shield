package edu.sjsu.customer.portal.response;

public class CustomerDTO extends GenericResponse {

	private static final long serialVersionUID = 1L;

	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String email;
	private String phone;
	
	public CustomerDTO() {
	}

	public CustomerDTO(String id, String firstName, String lastName, String address, String city,String email, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phone = phone;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", email=" + email + ", phone=" + phone + "]";
	}

	

}
