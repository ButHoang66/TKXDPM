package main.bikerental.subsystem.interbank;

import main.bikerental.common.exception.UnrecognizedException;
import main.bikerental.utils.API;

public class InterbankBoundary {

    public String query(String url, String data) {
        String response = null;
        try {
            response = API.post(url, data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new UnrecognizedException();
        }
        return response;
    }

}
