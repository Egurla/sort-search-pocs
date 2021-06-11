package com.nisum.bean;
	public class Person implements Comparable<Person>{

		private int id;
		private long adharNumber;
		private String firstName;
		private String lastName;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getAdharNumber() {
			return adharNumber;
		}
		public void setAdharNumber(long adharNumber) {
			this.adharNumber = adharNumber;
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
			Person other = (Person) obj;
			if (id != other.id)
				return false;
			return true;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Person(int id, long adharNumber, String firstName, String lastName) {
			super();
			this.id = id;
			this.adharNumber = adharNumber;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public int compareTo(Person o) {
			return this.id-o.id;
		}
}
