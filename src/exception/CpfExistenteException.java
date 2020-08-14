package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import view.MensagemGenerica;

/**
 * Created by victorximenis on 16/06/17.
 */
public class CpfExistenteException extends Exception {

    private MensagemGenerica mensagem;
    private List<String> parametros;

    public CpfExistenteException(MensagemGenerica mensagem) {
        super(mensagem.getCodigo());
        this.mensagem = mensagem;
        this.parametros = new ArrayList<>();
    }

    public CpfExistenteException(MensagemGenerica mensagem, Exception e) {
        super(mensagem.getCodigo(), e);
        this.mensagem = mensagem;
        this.parametros = new ArrayList<>();
    }

    public CpfExistenteException(MensagemGenerica mensagem, CpfExistenteException e) {
        super(mensagem.getCodigo().concat(" ").concat(e.getMensagem().getCodigo()), e);
        this.mensagem = mensagem;
        this.parametros = new ArrayList<>();
    }

    public CpfExistenteException(MensagemGenerica mensagem, String ... parametros) {
        super(mensagem.getCodigo());
        this.mensagem = mensagem;
        this.parametros = Arrays.asList(parametros);
    }

    public CpfExistenteException(MensagemGenerica mensagem, Exception e, String ... parametros) {
        super(mensagem.getCodigo(), e);
        this.mensagem = mensagem;
        this.parametros = Arrays.asList(parametros);
    }

    public CpfExistenteException(MensagemGenerica mensagem, CpfExistenteException e, String ... parametros) {
        super(mensagem.getCodigo().concat(" ").concat(e.getMensagem().getCodigo()), e);
        this.mensagem = mensagem;
        this.parametros = Arrays.asList(parametros);
    }

    public static final String getPilhaErro(Throwable t) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        t.printStackTrace(printWriter);
        return writer.toString();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(CpfExistenteException.class.getSimpleName());
        str.append(" [");
        if(mensagem != null) str.append("error=").append(mensagem).append(", ");
        if(parametros != null) str.append("parameters=").append(parametros);
        str.append("]");
        return str.toString();
    }

    public MensagemGenerica getMensagem() {
        return mensagem;
    }

    public void setMensagem(MensagemGenerica mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getParametros() {
        return parametros;
    }

    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
    }
}
