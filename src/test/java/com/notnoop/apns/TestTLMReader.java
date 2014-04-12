package com.notnoop.apns;

import java.util.Date;
import java.util.Map;

public class TestTLMReader {
	public static void main(String[] args) {
		ApnsService service =
			    APNS.newService()
			    .withCert("/Users/raymond/Desktop/private-apns-tlm-reader.p12", "82Hck007")
			    .withSandboxDestination()
			    .build();
		
		String payload = APNS.newPayload().alertBody("Hello Honey Rachael").customField("title", "Holy Shit Title").build();
		
		String token = "bcc071266d685efdf144ad2e50bbca0d7d992bd78a3b9ef70d249563611f8bbd";
		service.push(token, payload);
		
		
		Map<String, Date> inactiveDevices = service.getInactiveDevices();
		for (String deviceToken : inactiveDevices.keySet()) {
		    Date inactiveAsOf = inactiveDevices.get(deviceToken);
		    System.out.println(inactiveAsOf);
		}
		
		System.out.println("Done");
	}
}