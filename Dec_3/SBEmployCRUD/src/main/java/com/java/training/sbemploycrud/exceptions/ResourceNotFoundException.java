package com.java.training.sbemploycrud.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
