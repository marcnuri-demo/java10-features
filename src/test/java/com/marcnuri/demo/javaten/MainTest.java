/*
 * MainTest.java
 *
 * Created on 2018-04-02, 19:04
 */
package com.marcnuri.demo.javaten;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2018-04-02.
 */
@RunWith(JUnit4.class)
public class MainTest {

	@Test
	public void localVariableTypeInference_string_shouldInferOk() {
		var shouldBeString = "Hello Java 10";
		assertTrue(String.class.isInstance(shouldBeString));
	}

	@Test
	public void localVariableTypeInference_list_shouldInferOk() {
		//When
		var shouldBeList = new ArrayList<String>();

		// Then
		assertTrue(List.class.isInstance(shouldBeList));
	}

	@Test
	public void localVariableTypeInference_map_shouldInferOk() {
		//When
		var shouldBeMap = new HashMap<Integer, String>();

		// Then
		assertTrue(Map.class.isInstance(shouldBeMap));
	}

	@Test()
	public void optionalOrElseThrow_string_shouldReturnOk() {
		// Given
		final Optional<String> optional = Optional.ofNullable("Optional improvement in Java 10");

		// When
		final String string = optional.orElseThrow();

		// Then
		assertNotNull(string);
	}

	@Test(expected = NoSuchElementException.class)
	public void optionalOrElseThrow_string_shouldThrowException() {
		// Given
		final Optional<String> optional = Optional.ofNullable(null);

		// When
		final String string = optional.orElseThrow();

		// Then
		// Exception is thrown
	}

	@Test(expected = UnsupportedOperationException.class)
	public void toUnmodifiableSet_set_shouldThrowException() {
		// Given
		final Set<Integer> unmodifiableSet = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableSet());

		// When
		unmodifiableSet.add(4);

		// Exception is thrown
	}

	@Test(expected = UnsupportedOperationException.class)
	public void toUnmodifiableList_list_shouldThrowException() {
		// Given
		final List<Integer> unmodifiableList = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList());

		// When
		unmodifiableList.add(4);

		// Exception is thrown
	}

	@Test(expected = UnsupportedOperationException.class)
	public void toUnmodifiableMap_map_shouldThrowException() {
		// Given
		final Map<Integer, Integer> unmodifiableMap = Stream.of(1, 2, 3)
				.collect(Collectors.toUnmodifiableMap(Function.identity(), Function.identity()));

		// When
		unmodifiableMap.put(4, 4);

		// Exception is thrown
	}
}
