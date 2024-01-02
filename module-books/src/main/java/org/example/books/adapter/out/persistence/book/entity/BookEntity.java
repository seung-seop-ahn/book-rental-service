package org.example.books.adapter.out.persistence.book.entity;

import java.math.BigInteger;

import org.example.books.domain.book.vo.BookStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(
		name = "title",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(50) default '' comment 'title'",
		length = 50
	)
	private String title;

	@Column(
		name = "author",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(50) default '' comment 'author'",
		length = 50
	)
	private String author;

	@Column(
		name = "publisher",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "varchar(50) default '' comment 'publisher'",
		length = 50
	)
	private String publisher;

	@Enumerated(EnumType.STRING)
	@Column(
		name = "status",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "enum('borrowable', 'unborrowable') default 'borrowable' comment 'status'"
	)
	private BookStatus status;

	@Column(
		name = "category_bit_sum",
		unique = false,
		nullable = false,
		insertable = true,
		updatable = true,
		columnDefinition = "bigint default '0' comment 'categoryBitSum (max category 8)'"
	)
	private BigInteger categoryBitSum;
}
