package org.example.members.adapter.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(
		name = "email",
		unique = true,
		nullable = false,
		insertable = true,
		updatable = false,
		columnDefinition = "varchar(255) default '' comment 'email'",
		length = 255
	)
	private String email;

	@Column(
		name = "password",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(255) default '' comment 'password'",
		length = 255
	)
	private String password;

	@Column(
		name = "name",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(50) default '' comment 'name'",
		length = 50
	)
	private String name;

	@Column(
		name = "zipcode",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(8) default '' comment 'zipcode'",
		length = 8
	)
	private String zipcode;

	@Column(
		name = "address1",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(255) default '' comment 'address1'",
		length = 255
	)
	private String address1;

	@Column(
		name = "address2",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(255) default '' comment 'address2'",
		length = 255
	)
	private String address2;

	@Column(
		name = "cell_phone",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(20) default '' comment 'cellPhone'",
		length = 20
	)
	private String cellPhone;

	@Column(
		name = "birth",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "date default (current_date) comment 'birth'"
	)
	private LocalDate birth;

	@Column(
		name = "created_at",
		unique = true,
		nullable = false,
		insertable = true,
		updatable = false,
		columnDefinition = "datetime default current_timestamp comment 'createdAt'"
	)
	private LocalDateTime createdAt;

	@Column(
		name = "updated_at",
		unique = true,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "datetime default current_timestamp on update current_timestamp comment 'updatedAt'"
	)
	private LocalDateTime updatedAt;
}
