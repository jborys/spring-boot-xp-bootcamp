package com.example.tdd.persondemo.exception;

public class PersonRepositoryClientException extends Exception {
		
		private static final long serialVersionUID = -3456841003433599168L;

		public PersonRepositoryClientException() {
		}

		public PersonRepositoryClientException(String message) {
			super(message);
		}

		public PersonRepositoryClientException(Throwable cause) {
			super(cause);
		}

		public PersonRepositoryClientException(String message, Throwable cause) {
			super(message, cause);
		}

		public PersonRepositoryClientException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

	}
