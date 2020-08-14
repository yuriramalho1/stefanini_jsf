package util;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Util {
	public static Object getManagedBean(String managedBean){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = (HttpSession) request.getSession();
		return session.getAttribute(managedBean);
	}
	
	public static String obterCaminhoReal(String caminho) {
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
        return sc.getRealPath(caminho);
    }
	
	public static String formatarCpfCnpj(String cpfCnpj){
		if(cpfCnpj == null || cpfCnpj.isEmpty()){
			return cpfCnpj;
		}
			//CNPJ
		if(cpfCnpj.length() > 11){
			cpfCnpj = cpfCnpj.substring(0,2).concat(".").concat(cpfCnpj.substring(2,5).concat(".")).concat(cpfCnpj.substring(5,8).concat("/")).concat(cpfCnpj.substring(8,12).concat("-")).concat(cpfCnpj.substring(12,14));
			}
			//CPF
		if(cpfCnpj.length() == 11){
			cpfCnpj = cpfCnpj.substring(0,3).concat(".").concat(cpfCnpj.substring(3,6).concat(".")).concat(cpfCnpj.substring(6,9).concat("-")).concat(cpfCnpj.substring(9,11));
		}
		return cpfCnpj;
			
	}

}
