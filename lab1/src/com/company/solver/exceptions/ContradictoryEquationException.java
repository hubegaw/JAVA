package com.company.solver.exceptions;

public class ContradictoryEquationException extends SolverException{
    public ContradictoryEquationException() {
        super("Równanie sprzeczne!");
    }
}
