package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import util.StringUtil;

public class CpfValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent comp, Object obj){
		String strCpf = obj.toString();

		if(!StringUtil.validaCPF(strCpf)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF invalido", "O CPF não está¡ correto.");
			throw new ValidatorException(msg);
		}
	}

}
