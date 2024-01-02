package org.example.books.adapter.out.persistence.category.entity;

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
@Table(name = "book_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
}
