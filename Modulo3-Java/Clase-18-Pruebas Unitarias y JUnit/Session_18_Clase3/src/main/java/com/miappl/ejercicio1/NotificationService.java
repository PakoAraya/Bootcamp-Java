package com.miappl.ejercicio1;

public class NotificationService {
	private final EmailClient emailClient;

	//Constructor de la clase EmailClient es Dummy
	public NotificationService(EmailClient emailClient) {
		this.emailClient = emailClient;
	}

	public boolean sendNotification(String message) {
		return message != null && !message.isEmpty();
	}
}
