package com.company.solver;

import com.company.solver.exceptions.SolverException;

public interface QFormulaSolver {
    public double[] solve() throws SolverException;
    public void setInitialParameters(double a, double b, double c);
    public boolean isComplex();
}
