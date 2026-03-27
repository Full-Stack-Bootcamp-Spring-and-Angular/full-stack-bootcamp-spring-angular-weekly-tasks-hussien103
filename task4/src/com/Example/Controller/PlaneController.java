package com.Example.Controller;

import com.Example.Models.Vehicle;
import com.Example.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PlaneController implements VehicleController
{

    public DatabaseOperations databaseOperations;

    @Autowired
    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveToDatabase(Vehicle vehicle)
    {
        databaseOperations.save(vehicle);
    }


}
