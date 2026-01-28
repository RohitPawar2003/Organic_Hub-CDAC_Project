package com.cdac.modelmvc;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="orderr")
public class Order {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long orderId;
@NotNull(message="required")
private LocalDate ordersdate;
@NotNull(message="required")
@ManyToOne
@JoinColumn(name="customer_id")
private User customer;
@NotNull(message="required")
private String status;
}
