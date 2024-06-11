package com.devkm.app.remote;

import jakarta.ejb.Remote;

@Remote
public interface Deliver {
    public void time(Long id);
    public void run();
}
