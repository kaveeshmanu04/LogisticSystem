package com.devkm.app.remote;

import jakarta.ejb.Remote;

@Remote
public interface Login {
    public String login(String email, String password);
}
