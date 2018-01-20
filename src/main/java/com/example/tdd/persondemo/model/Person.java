package com.example.tdd.persondemo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tdd.persondemo.model.Person.PersonBuilder;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Persons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	public Person() {
	}

	@JsonCreator
	public Person(@JsonProperty(value = "id", defaultValue = "0L") long id,
			@JsonProperty(value = "firstName", required = true) String firstName,
			@JsonProperty(value = "lastName", required = true) String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	private Person(PersonBuilder builder) {
	    this.firstName = builder.firstName;
	    this.lastName = builder.lastName;
	}
	
	public static class PersonBuilder {
		private long id;
		private String firstName;
		private String lastName;

		public PersonBuilder id(long id) {
			this.id = id;
			return this;
		}

		public PersonBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PersonBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
	    public PersonBuilder(String firstName, String lastName) {
	      this.firstName = firstName;
	      this.lastName = lastName;
	    }
		public Person build() {
			return new Person(this);
		}
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}

//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Person {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;	
//	
//	private String firstName;
//	private String lastName;
//	
//	public Person()  {}
//
//	@JsonCreator
//	public Person(@JsonProperty(value = "id", defaultValue = "0L") long id,
//			@JsonProperty(value = "firstName", required = false) String firstName,
//			@JsonProperty(value = "lastName", required = true) String lastName) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//	
//	private Person(PersonBuilder builder) {
//		    this.firstName = builder.firstName;
//		    this.lastName = builder.lastName;
//	 }
//		
//	public static class PersonBuilder {
//	    private final String firstName;
//	    private final String lastName;
//
//	    public PersonBuilder(String firstName, String lastName) {
//	      this.firstName = firstName;
//	      this.lastName = lastName;
//	    }
//
//	    public Person build() {
//	      return new Person(this);
//	    }
//
//	  }
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//}
