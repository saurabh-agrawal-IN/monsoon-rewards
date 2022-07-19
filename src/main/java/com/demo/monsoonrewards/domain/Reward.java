package com.demo.monsoonrewards.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="REWARD_TABLE")
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@OneToOne(cascade={CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER, mappedBy="reward", orphanRemoval=true)
    private Transaction transaction;
    
    private Long points;
    
    public Reward() {
    }
    
	public Reward(Long points) {
		super();
		this.points = points;
	}    

	public Reward(Long id, Transaction transaction, Long points) {
		super();
		this.id = id;
		this.transaction = transaction;
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Reward {id: " + id + ", transaction: " + transaction + ", points: " + points + "}";
	}
}
