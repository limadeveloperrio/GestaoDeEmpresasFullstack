package com.companybruno.demoAPI.mapping;

import com.companybruno.demoAPI.entities.Empresa;
import com.companybruno.demoAPI.models.requests.EmpresaDTO;

public class EmpresaMap {
	
	private EmpresaMap() {
		throw new IllegalArgumentException("class static map+ing");		
	}
	
	public static Empresa map(EmpresaDTO request) {
		Empresa empresa = new Empresa();
		
		empresa.setIdEmpresa(request.getId());
		empresa.setCnpj(request.getCnpj());
		empresa.setRazaoSocial(request.getRazaoSocial());
		empresa.setNomeFantasia(request.getNomeFantasia());
		
		return empresa;
	}
	
	public static EmpresaDTO mapToResponse(Empresa empresa) {		
		EmpresaDTO dto = new EmpresaDTO();	
		
		dto.setId(empresa.getIdEmpresa());
		dto.setCnpj(empresa.getCnpj());
		dto.setNomeFantasia(empresa.getNomeFantasia());
		dto.setRazaoSocial(empresa.getRazaoSocial());
		
		return dto;
		
	}

}
