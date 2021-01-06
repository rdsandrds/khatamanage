package com.fawad.walletapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(1)
    @NotNull(message = "amount cann't be null")
    private Double amount;
    private String description;
    @Min(1)
    @Max(3)
    private int type;//1 for Income, 2 for expense, 3 for transfer
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date transactionDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id",nullable = false)
    @JsonIgnore
    private Wallet wallet;

    @PrePersist
    public void setTransactionDate(){ this.transactionDate = new Date(); }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", description=" + description + ", type=" + type
				+ ", transactionDate=" + transactionDate + ", wallet=" + wallet + "]";
	}
    
    
    
}
