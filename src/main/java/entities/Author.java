package entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String surname;

	@Embedded
	private Contact contact;

	@ManyToOne
	@JoinColumn
	private Style style;

	public Author() {

	}

	public Author(String name, String surname, Contact contact, Style style) {
		this.name = name;
		this.surname = surname;
		this.contact = contact;
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", contact=" + contact + ", style="
				+ style + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
