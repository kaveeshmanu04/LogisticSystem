package com.devkm.app.servlet;


import com.devkm.app.entity.CargoEntity;
import com.devkm.app.remote.CargoUpdating;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateCargo")
public class UpdateCargoServlet extends HttpServlet {
    @EJB(lookup = "java:global/ear-1.0/com.devkm.app-web-1.0/CargoUpdatingImpl")
    private CargoUpdating updateCargo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("cargoId");
        long parseLong= Long.parseLong(id);
        System.out.println(id);
        if (id != null) {
            CargoEntity cargo = updateCargo.viewSelectedCargoDetails(parseLong);
            req.setAttribute("cargo",cargo);
            RequestDispatcher dispatcher = req.getRequestDispatcher("updateCargoInformation.jsp");
            dispatcher.forward(req, resp);
            System.out.println(id);
        } else {
            System.out.println("id is null");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long parseLong= Long.parseLong(id);
        String currentLocation =req.getParameter("currentLocation");
        String destinationLocation=req.getParameter("destinationLocation");
        String details=req.getParameter("details");
        String originLocation=req.getParameter("originLocation");
        String status=req.getParameter("status");
        updateCargo.updateCargo(parseLong,currentLocation,originLocation,destinationLocation,status,details);
        resp.sendRedirect("viewCargo.jsp");
    }
}
