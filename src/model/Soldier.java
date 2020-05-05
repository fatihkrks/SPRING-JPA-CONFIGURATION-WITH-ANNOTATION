package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_soldier")
public class Soldier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sld_id")
	private int id;
	@Column(name = "sld_name")
	private String name;
	@Column(name = "sld_surname")
	private String surname;
	@Column(name = "sld_rank")
	private int rank;

	public Soldier() {
		super();
	}

	public Soldier(String name, String surname, int rank) {
		super();
		this.name = name;
		this.surname = surname;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", rank=" + rank + "]";
	}
}
