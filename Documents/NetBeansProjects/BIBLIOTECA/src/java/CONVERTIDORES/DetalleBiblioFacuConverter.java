package CONVERTIDORES;

import ENTIDADES.DetalleBiblioFacu;
import NEGOCIO.DetalleBiblioFacuFacade;
import CONTROLADORES.util.JsfUtil;
import NEGOCIO.BibliografiaFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesConverter(value = "detalleBiblioFacuConverter")
public class DetalleBiblioFacuConverter implements Converter {

    //@Inject
    private DetalleBiblioFacuFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        Object obj=null;
        try {
            if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
                obj= null;
            }
            ejbFacade= (DetalleBiblioFacuFacade)(new InitialContext().lookup("java:global/BIBLIOTECA/DetalleBiblioFacuFacade"));
            
            obj= this.ejbFacade.find(getKey(value));
        } catch (NamingException ex) {
            Logger.getLogger(DetalleBiblioFacuConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof DetalleBiblioFacu) {
            DetalleBiblioFacu o = (DetalleBiblioFacu) object;
            return getStringKey(o.getDtbfCodigo());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DetalleBiblioFacu.class.getName()});
            return null;
        }
    }

}
