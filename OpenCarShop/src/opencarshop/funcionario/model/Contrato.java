package opencarshop.funcionario.model;

import java.time.LocalDate;
import java.util.Date;

public class Contrato {

    private Character cargo;
    private Double salario;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    
    public Contrato(){}
    
    public Contrato(Character cargo, 
                    double salario, 
                    LocalDate dataInicio, 
                    LocalDate dataTermino){
        this.cargo = cargo;
        this.salario = salario;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }
    
    public Character getCargo() {
        return cargo;
    }

    public void setCargo(Character cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

}
