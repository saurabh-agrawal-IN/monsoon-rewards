package com.demo.monsoonrewards.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TRANSACTION_TABLE")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;
    
    private Double amount;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date date;
    
    @OneToOne(mappedBy = "transaction", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private Reward reward;
    
    public Transaction() {
    }

	public Transaction(Long id, User user, Double amount, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.amount = amount;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "Transaction {id: " + id + ", user: " + user + ", amount: " + amount + ", date: " + date + ", reward: " + reward + "}";
	}
}
