package com.devkm.app.remote;

import com.devkm.app.entity.CargoEntity;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface CargoViewing {

    public List<CargoEntity>getCargo();
}
