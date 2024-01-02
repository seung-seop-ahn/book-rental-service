package org.example.books.adapter.out.persistence.book.mapper;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

import org.example.books.adapter.out.persistence.book.entity.BookEntity;
import org.example.books.domain.book.Book;

public class BookCategoryBitSumMapper {

	public static BigInteger toBitSum(Book book) {
		List<Long> categoryIds = book.getCategories().stream()
			.map(t -> t.getId().getId())
			.toList();

		return IntStream.range(0, 8)
			.filter(i -> i < categoryIds.size() && categoryIds.get(i) != null)
			.mapToObj(i -> BigInteger.valueOf(categoryIds.get(i)).shiftLeft(i * 8))
			.reduce(BigInteger.ZERO, BigInteger::add);
	}

	public static List<Long> toIds(BookEntity entity) {
		BigInteger categoryBitSum = entity.getCategoryBitSum();

		return IntStream.range(0, 8)
			.mapToObj(i -> categoryBitSum.shiftRight(i * 8).and(BigInteger.valueOf(255)))
			.filter(shiftedBit -> !shiftedBit.equals(BigInteger.ZERO))
			.map(BigInteger::longValue)
			.toList();
	}
}
