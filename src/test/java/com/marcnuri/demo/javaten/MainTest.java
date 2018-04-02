/*
 * MainTest.java
 *
 * Created on 2018-04-02, 19:04
 */
package com.marcnuri.demo.javaten;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

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

}
