package com.devkm.app.servlet;

import com.devkm.app.entity.CargoEntity;
import com.devkm.app.remote.CargoViewing;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewCargo")
public class ViewCargoServlet extends HttpServlet {
    @EJB(lookup = "java:global/ear-1.0/com.devkm-web-1.0/ViewCargoImpl")
    private CargoViewing viewCargo;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CargoEntity> cargo = viewCargo.getCargo();
        req.setAttribute("cargoList",cargo);
        RequestDispatcher dispatcher = req.getRequestDispatcher("cargoInformation.jsp");
        dispatcher.forward(req, resp);
    }
}
