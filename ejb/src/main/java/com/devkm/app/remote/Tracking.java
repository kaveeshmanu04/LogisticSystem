package com.devkm.app.remote;

import jakarta.ejb.Remote;

@Remote
public interface Tracking {
public String cargoTracking(Long id);

}
