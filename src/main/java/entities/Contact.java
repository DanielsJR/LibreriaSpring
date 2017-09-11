package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
	
	
	private String email;
	
	private int fone;

	public Contact(String email, int fone) {
		this.email = email;
		this.fone = fone;
	}

	public Contact() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}

	@Override
	public String toString() {
		return "Contact [email=" + email + ", fone=" + fone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}



}
