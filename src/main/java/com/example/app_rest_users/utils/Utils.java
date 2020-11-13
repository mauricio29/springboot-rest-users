package com.example.app_rest_users.utils;

import java.util.regex.Pattern;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

	/**
	 * Email regex pattern.
	 */
	private static final Pattern EMAIL_PATTERN = Pattern
			// Checks using positive look ahead assertions
			// ^ Start anchor
			// (?=.{1,64}@) <- 1 character minimum, 64 maximum before @
			// [a-z0-9]+(\\.[a-z0-9]+)*@ <- alphanumeric lowercase characters before @
			// domain\\.com <- ending with specific domain
			// $ End anchor
			//
			.compile("^(?=.{1,64}@)[a-z0-9]+(\\.[a-z0-9]+)*@domain\\.com$");

	/**
	 * Password regex pattern.
	 */
	private static final Pattern PASS_PATTERN = Pattern
			// Checks using positive look ahead assertions
			// ^ Start anchor
			// (?=.*[A-Z]) Ensure string has one uppercase letter
			// (?=.*[a-z]) Ensure string has one lowercase letter
			// (?=.*[0-9].*[0-9]) Ensure string has two digits
			// .{8,} Ensure string is of length 8 or more
			// $ End anchor
			.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9].*[0-9]).{8,}$");

	/**
	 * Email validation.
	 */
	public static boolean isEmailValid(final String email) {

		boolean isValid = EMAIL_PATTERN.matcher(email).matches();

		if (!isValid) {
			log.warn("Email has invalid format: {}", email);
		}

		return isValid;
	}

	public static boolean isPasswordValid(@NonNull String password) {
		
		boolean isValid = PASS_PATTERN.matcher(password).matches();
		if (!isValid) {
			log.warn("Password has invalid format: {}", password);
		}
		return isValid;
	}

}
