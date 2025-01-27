package es.cursosprhib.jpa03ejerciciojpa.modeloDto;

public class ClienteDto {
    private Integer idPersona;
    private String aèllidos;
    private Integer nroCliente;
    public ClienteDto(Integer idPersona, String aèllidos, Integer nroCliente) {
        this.idPersona = idPersona;
        this.aèllidos = aèllidos;
        this.nroCliente = nroCliente;
    }
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getAèllidos() {
        return aèllidos;
    }
    public void setAèllidos(String aèllidos) {
        this.aèllidos = aèllidos;
    }
    public Integer getNroCliente() {
        return nroCliente;
    }
    public void setNroCliente(Integer nroCliente) {
        this.nroCliente = nroCliente;
    }
    
}
